package com.powernode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.ProdPropValue;
import com.powernode.exception.ProdException;
import com.powernode.mapper.ProdPropValueMapper;
import com.powernode.service.ProdPropValueService;
import com.powernode.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.mapper.ProdPropMapper;
import com.powernode.domain.ProdProp;
import com.powernode.service.ProdPropService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class ProdPropServiceImpl extends ServiceImpl<ProdPropMapper, ProdProp> implements ProdPropService {

    @Autowired
    private ProdPropMapper prodPropMapper;

    @Autowired
    private ProdPropValueMapper prodPropValueMapper;

    @Autowired
    private ProdPropValueService prodPropValueService;

    @Override
    public Page<ProdProp> loadAllProp(Page<ProdProp> page, ProdProp prodProp) {
        Page<ProdProp> prodPropPage = prodPropMapper.selectPage(page, new LambdaQueryWrapper<ProdProp>()
                .orderByDesc(ProdProp::getPropId));
        // 获取其中的记录
        List<ProdProp> prodPropList = prodPropPage.getRecords();
        if (!CollectionUtils.isEmpty(prodPropList)) {
            // 获取所有属性ID，以流的方式
            List<Long> propList = prodPropList.stream().map(ProdProp::getPropId).collect(Collectors.toList());
            // 通过id查询属性的具体值，循环赋值
            List<ProdPropValue> prodPropValueList = prodPropValueMapper.selectList(new LambdaQueryWrapper<ProdPropValue>()
                    .in(ProdPropValue::getPropId, propList));
            // 循环赋值给prodPropList
            prodPropList.forEach(prodprop0 -> {
                // 以流的方式将这个集合中的数据筛选出来并放到prodprop的属性中
                prodprop0.setProdPropValues(prodPropValueList.stream()
                        .filter(propValue -> propValue.getPropId().equals(prodprop0.getPropId()))
                        .collect(Collectors.toList()));
            });
            prodPropPage.setRecords(prodPropList);
        }
        return prodPropPage;
    }

    /**
     * 新增规格及对应属性
     *
     * @param prodProp
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Integer addProdprop(ProdProp prodProp) {
        prodProp.setRule((byte) 1);
        prodProp.setShopId(AuthUtil.getSysShopId());
        int insert = prodPropMapper.insert(prodProp);
        if (insert > 0) {
            // 插入属性值
            List<ProdPropValue> prodPropValueList = prodProp.getProdPropValues();
            prodPropValueList.forEach(prodPropValue -> {
                prodPropValue.setPropId(prodProp.getPropId());
            });
            // 将属性值插入到对应的表中
            boolean b = prodPropValueService.saveBatch(prodPropValueList);
            if (!b) {
                throw new ProdException("插入属性值失败");
            }
        }
        return insert;
    }

    /**
     * 修改属性值
     *
     * @param prodProp
     * @return
     */
    @Override
    @Transactional
    public Integer updateProdProp(ProdProp prodProp) {
        int i = prodPropMapper.updateById(prodProp);
        List<ProdPropValue> prodPropValues = prodProp.getProdPropValues();
        // 删除原来的规格属性值属性
        int delete = prodPropValueMapper.delete(new LambdaQueryWrapper<ProdPropValue>().eq(ProdPropValue::getPropId, prodProp.getPropId()));
        if (!CollectionUtils.isEmpty(prodPropValues)) {
            // 如果传过来的prodProp的属性值不为空，循环为属性值赋propId
            prodPropValues.stream().forEach(x->{
                x.setPropId(prodProp.getPropId());
            });
            // 则进行更新操作
            if (delete > 0) {
                boolean b = prodPropValueService.saveBatch(prodPropValues);
                i = 1;
            }
        }
        return i;
    }


}
