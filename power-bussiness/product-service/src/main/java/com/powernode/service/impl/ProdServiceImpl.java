package com.powernode.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.ProdTagReference;
import com.powernode.domain.Sku;
import com.powernode.dto.ProdDto;
import com.powernode.exception.ProdException;
import com.powernode.mapper.ProdCommMapper;
import com.powernode.model.ProdES;
import com.powernode.service.ProdTagReferenceService;
import com.powernode.service.SkuService;
import com.powernode.util.AuthUtil;
import com.powernode.vo.ProdCommStatics;
import com.powernode.vo.ProdInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.mapper.ProdMapper;
import com.powernode.domain.Prod;
import com.powernode.service.ProdService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class ProdServiceImpl extends ServiceImpl<ProdMapper, Prod> implements ProdService {

    @Autowired
    private ProdMapper prodMapper;

    @Autowired
    private SkuService skuService;

    @Autowired
    private ProdTagReferenceService prodTagReferenceService;

    @Autowired
    private ProdCommMapper prodCommMapper;



    /**
     * 通过分页数据获取 商品数据
     *
     * @param page
     * @param prod
     * @return
     */
    @Override
    public Page<Prod> getProdByPage(Page<Prod> page, Prod prod) {
        Long shopId = AuthUtil.getSysShopId();
        // 如果不存在shopId的话，直接返回null,无数据
        if (ObjectUtils.isEmpty(shopId)) {
            return null;
        }
        Page<Prod> prodPage = prodMapper.selectPage(page, new LambdaQueryWrapper<Prod>()
                .eq(Prod::getShopId, shopId)
                .eq(!ObjectUtils.isEmpty(prod.getStatus()), Prod::getStatus, prod.getStatus())
                .like(!ObjectUtils.isEmpty(prod.getProdName()), Prod::getProdName, prod.getProdName())
                .orderByAsc(Prod::getCreateTime));
        return prodPage;
    }

    /**
     * 根据 商品id将商品的状态设置为不可见
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteById(Long id) {
        return prodMapper.updateStatusById(0L, id);
    }

    /**
     * 查询数据
     *
     * @param prodId
     * @return
     */
    @Override
    public ProdDto getProdInfo(Long prodId) {
        ProdDto pd = new ProdDto();
        // 通过prodId查询商品信息
        Prod prod = prodMapper.selectOne(new LambdaQueryWrapper<Prod>().eq(Prod::getProdId, prodId));
        if (!ObjectUtils.isEmpty(prod)) {
            // 根据prodId获取详情列表skuList
            List<Sku> skuList = skuService.getListByProdId(prodId);
            // 根据prodId获取商品标签
            List<Long> tagList = prodTagReferenceService.getListByProdId(prodId);
            // 获取配送信息
            String deliveryModeStr = prod.getDeliveryMode();
            // 将prod的属性值赋予pd
            BeanUtils.copyProperties(prod, pd);
            pd.setSkuList(skuList);
            pd.setTagList(tagList);
            pd.setDeliveryModeVo(JSON.parseObject(deliveryModeStr, ProdDto.DeliveryModeVo.class));
        }
        return pd;
    }

    /**
     * 修改商品数据
     * @param prodDto
     * @return
     */
    @Override
    @Transactional
    public Integer updateProd(ProdDto prodDto) {
        log.info("修改商品，商品:{},用户:{}", JSON.toJSONString(prodDto), AuthUtil.getSysUserId());
        prodDto.setUpdateTime(new Date());
        prodDto.setVersion(prodDto.getVersion()+1);
        int count = prodMapper.updateById(prodDto);
        if (count > 0) {
            // 删除SKu
            skuService.remove(new LambdaQueryWrapper<Sku>()
                    .eq(Sku::getProdId,prodDto.getProdId()));
            // 插入sku
            insertSku(prodDto);
            // 删除tagRefence
            prodTagReferenceService.remove(new LambdaQueryWrapper<ProdTagReference>()
                    .eq(ProdTagReference::getProdId,prodDto.getProdId()));
            // 插入tagRefence
            insertTagRefence(prodDto);
        }
        return count;
    }

    /**
     * 产品添加
     *
     * @param prodDto
     * @return
     */
    @Override
    @Transactional
    public Integer addProd(ProdDto prodDto) {
        System.err.println(prodDto);
        prodDto.setVersion(1);
        prodDto.setCreateTime(new Date());
        prodDto.setUpdateTime(new Date());
        prodDto.setPutawayTime(new Date());
        prodDto.setShopId(AuthUtil.getSysShopId());
        // 依据现有的数据分析，将配送模式转换为字符串
        prodDto.setDeliveryMode(JSON.toJSONString(prodDto.getDeliveryModeVo()));
        prodDto.setOriPrice(prodDto.getPrice());
        prodDto.setSoldNum(0);
        // 将数据插入到商品表
        int insert = prodMapper.insert(prodDto);
        if (insert > 0) {
            // 插入sku
            insertSku(prodDto);
            // 插入tagRefence
            insertTagRefence(prodDto);
        }
        return insert;
    }

    /**
     * 导入数据到ES
     * 如果 t1 t2 均为 null ，则进行全量导入，否则进行增量导入
     *
     * @param t1
     * @param t2
     * @return
     */
    @Override
    public Integer selectCount(Date t1, Date t2) {
        return prodMapper.selectCount(new LambdaQueryWrapper<Prod>()
                .eq(Prod::getStatus, 1)
                .between(t1 != null && t2 != null, Prod::getUpdateTime, t1, t2));
    }

    /**
     * 根据日期范围选择指定页数导入，同时将Prod中的数据 转成ProdES
     * @param page
     * @param t1
     * @param t2
     * @return
     */
    @Override
    public List<ProdES> loadProdESwithPage(Page<Prod> page, Date t1, Date t2) {
        Page<Prod> prodPage = prodMapper.selectPage(page, new LambdaQueryWrapper<Prod>()
                .eq(Prod::getStatus, 1)
                .between(t1 != null && t2 != null, Prod::getUpdateTime, t1, t2));
        List<Prod> prodList = prodPage.getRecords();
        // 如果没获取到数据
        if (CollectionUtils.isEmpty(prodList)){
            return Collections.emptyList();
        }

        // 如果获取到了数据
        List<ProdES> prodESList = new ArrayList<>();

        // 1.获取当前商品ID的集合
        List<Long> prodIdList = prodList.stream().map(Prod::getProdId).collect(Collectors.toList());
        // 2.查询prod_tag_refence，获取tag标签的集合
        List<ProdTagReference> ptrList = prodTagReferenceService.list(new LambdaQueryWrapper<ProdTagReference>()
                .in(ProdTagReference::getProdId, prodIdList));
        // 3.获取当前商品评价的集合
        List<ProdCommStatics> prodCommStaticsList = prodCommMapper.selectProdCommStatic(prodIdList);

        // 循环将这些数据设置到ProdES中
        prodList.forEach(prod -> {
            ProdES prodES = new ProdES();
            // 将prod中的属性值拷贝给prodES
            BeanUtils.copyProperties(prod,prodES);

            // 获取商品的标签列表数据
            List<Long> tagList = ptrList.stream().filter(ptr ->ptr.getProdId().equals(prod.getProdId()))
                    .map(ProdTagReference::getTagId).collect(Collectors.toList());

            //给prodES赋值
            prodES.setTagList(tagList);

            // 获取当前页商品的集合数
            List<ProdCommStatics> prodCommStaticss = prodCommStaticsList.stream().filter(pcs -> pcs.getProdId().equals(prod.getProdId())).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(prodCommStaticss)){
                // 获取当前商品的评价
                ProdCommStatics prodCommStatics = prodCommStaticss.get(0);
                // 计算好评率
                Integer goodCount = prodCommStatics.getGoodCount();
                Integer allCount = prodCommStatics.getAllCount();
                prodES.setPriseNumber(Long.valueOf(allCount));
                if (!goodCount.equals(0)){
                    // 计算好评率保留两位小数,向上取整
                    BigDecimal divide = new BigDecimal(goodCount).divide(new BigDecimal(allCount), 2, RoundingMode.HALF_UP);
                    prodES.setPositiveRating(divide);
                }
            }
            // 将数据添加到集合中
            prodESList.add(prodES);
        });
        return prodESList;
    }

    @Override
    public ProdInfoVo getProdInfoVo(Long prodId) {
        Prod prod = prodMapper.selectOne(new LambdaQueryWrapper<Prod>().eq(Prod::getProdId, prodId));
        ProdInfoVo prodInfoVo = new ProdInfoVo();
        if (ObjectUtils.isEmpty(prod)){
            return null;
        }
        BeanUtils.copyProperties(prod,prodInfoVo);
        // 获取商品详情
        List<Sku> skuList = skuService.getListByProdId(prodId);
        prodInfoVo.setSkuList(skuList);
        // 返回商品给前端
        return prodInfoVo;
    }


    /**
     * 修改数据
     *
     * @param prodDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Integer updateByProdDto(ProdDto prodDto) {

        // 先对未传的值进行补充
        log.info("修改商品，商品:{},用户:{}", JSON.toJSONString(prodDto), AuthUtil.getSysUserId());
        prodDto.setUpdateTime(new Date());
        prodDto.setVersion((prodDto.getVersion() == null ? 0 : prodDto.getVersion()) + 1);
        // 更新商品表
        int count = prodMapper.updateById(prodDto);
        if (count > 0) {
            // 删除sku表中对应数据
            skuService.remove(new LambdaQueryWrapper<Sku>().eq(Sku::getProdId, prodDto.getProdId()));
            // 更新sku表
            insertSku(prodDto);
            // 删除对应tag表
            prodTagReferenceService.remove(new LambdaQueryWrapper<ProdTagReference>()
                    .eq(ProdTagReference::getProdId, prodDto.getProdId()));
            // 更新tag表
            insertTagRefence(prodDto);
        } else {
            throw new ProdException("修改数据失败");
        }
        return count;
    }

    /**
     * 插入sku数据
     *
     * @param prodDto
     */
    public void insertSku(ProdDto prodDto) {
        List<Sku> skuList = prodDto.getSkuList();
        if (!CollectionUtils.isEmpty(skuList)) {
            skuList.forEach(sku -> {
                sku.setCreateTime(new Date());
                sku.setProdId(prodDto.getProdId());
                sku.setUpdateTime(new Date());
                sku.setVersion(1);
                sku.setIsDelete((byte) 0);
                sku.setActualStocks(sku.getStocks());
                sku.setOriPrice(sku.getOriPrice());
            });
            boolean b = skuService.saveBatch(skuList);
            if (!b) {
                // 插入失败抛出自定义异常
                throw new ProdException("插入Sku失败");
            }
        }
    }

    /**
     * 插入商品标签表
     *
     * @param prodDto
     */
    public void insertTagRefence(ProdDto prodDto) {
        List<Long> tagList = prodDto.getTagList();
        List<ProdTagReference> prodTagReferenceList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(tagList)) {
            tagList.forEach(tagId -> {
                ProdTagReference prodTagReference = new ProdTagReference();
                prodTagReference.setProdId(prodDto.getProdId());
                prodTagReference.setTagId(tagId);
                prodTagReference.setStatus(true);
                prodTagReference.setCreateTime(new Date());
                prodTagReference.setShopId(prodDto.getShopId());
                prodTagReferenceList.add(prodTagReference);
            });
            boolean b = prodTagReferenceService.saveBatch(prodTagReferenceList);
            if (!b) {
                throw new ProdException("插入标签列表失败");
            }
        }
    }
}
