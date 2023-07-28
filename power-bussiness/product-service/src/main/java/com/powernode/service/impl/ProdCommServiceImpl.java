package com.powernode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.Member;
import com.powernode.domain.Prod;
import com.powernode.domain.ProdTag;
import com.powernode.feign.MemberFeign;
import com.powernode.vo.ProdCommInfoVo;
import com.powernode.vo.ProdCommVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.mapper.ProdCommMapper;
import com.powernode.domain.ProdComm;
import com.powernode.service.ProdCommService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class ProdCommServiceImpl extends ServiceImpl<ProdCommMapper, ProdComm> implements ProdCommService {


    @Autowired
    private ProdCommMapper prodCommMapper;

    @Autowired
    private MemberFeign memberFeign;

    /**
     * 分页查询
     */
    @Override
    public Page<ProdComm> loadAllProp(Page<ProdComm> page, ProdComm prodComm) {

        return prodCommMapper.selectPage(page, new LambdaQueryWrapper<ProdComm>()
                .like(!ObjectUtils.isEmpty(prodComm.getProdName()), ProdComm::getProdName, prodComm.getProdName())
                .eq(!ObjectUtils.isEmpty(prodComm.getStatus()), ProdComm::getStatus, prodComm.getStatus())
                .orderByAsc(ProdComm::getCreateTime));
    }

    /**
     * 根据商品ID获取评论
     *
     * @param prodId
     * @return
     */
    @Override
    public List<ProdComm> getListByProdId(Long prodId) {
        return prodCommMapper.selectList(new LambdaQueryWrapper<ProdComm>()
                .eq(ProdComm::getProdId, prodId)
                .eq(ProdComm::getStatus, 1));
    }

    /**
     * 获取商品评论详情
     *
     * @param prodId
     * @return
     */
    @Override
    public ProdCommVo getProdCommDetails(Long prodId) {
        ProdCommVo prodCommVo = prodCommMapper.selectCommSum(prodId);

        if (!ObjectUtils.isEmpty(prodCommVo)) {
            // 计算好评率
            BigDecimal positiveRating = prodCommVo.getPositiveRating();
            if (prodCommVo.getNumber() > 0) {
                positiveRating = new BigDecimal(prodCommVo.getPraiseNumber())
                        .divide(new BigDecimal(prodCommVo.getNumber()), 2, RoundingMode.HALF_UP)
                        .multiply(new BigDecimal(100));
                prodCommVo.setPositiveRating(positiveRating);
            } else {
                positiveRating = BigDecimal.ZERO;
            }
        }
        return prodCommVo;
    }



    /**
     * 获取评论详情
     *
     * @param page
     * @param prodId
     * @return
     */
    @Override
    public Page<ProdCommInfoVo> getProdCommPageProdId(Page<ProdComm> page, Long prodId, Integer evaluate) {
        // 参数设置正确
        Page<ProdCommInfoVo> infoVoPage = new Page<>(page.getCurrent(), page.getSize());
        System.out.println(evaluate + "= evaluate");
        Page<ProdComm> prodCommPage = prodCommMapper.selectPage(page, new LambdaQueryWrapper<ProdComm>()
                .eq(ProdComm::getProdId,prodId)
                .eq(!ObjectUtils.isEmpty(evaluate) && !evaluate.equals(-1), ProdComm::getEvaluate, evaluate)
                .orderByDesc(ProdComm::getCreateTime));
//        List<ProdComm> records = prodCommMapper.selectList(new LambdaQueryWrapper<ProdComm>()
//                .eq(ProdComm::getProdId, prodId)
//                .eq(!Integer.valueOf(-1).equals(evalute), ProdComm::getEvaluate, evalute)
//                .orderByDesc(ProdComm::getCreateTime));
        List<ProdComm> records = prodCommPage.getRecords();

        if (CollectionUtils.isEmpty(records)) {
            return infoVoPage;
        }
        List<String> openIds = records.stream().map(ProdComm::getOpenId).collect(Collectors.toList());
        // 获取会员列表
        List<Member> memberListFeign = memberFeign.getMemberListFeign(openIds);
        if (CollectionUtils.isEmpty(memberListFeign)) {
            throw new IllegalArgumentException("远程服务不可用");
        }
        List<ProdCommInfoVo> infoVoList = new ArrayList<>(records.size());
        // 拷贝并添加属性
        records.forEach(record -> {
            ProdCommInfoVo infoVo = new ProdCommInfoVo();
            BeanUtils.copyProperties(record, infoVo);
            Member member1 = memberListFeign.stream().filter(member -> member.getOpenId().equals(record.getOpenId())).collect(Collectors.toList()).get(0);
            String nickName = member1.getNickName();
            if (nickName.length() == 1) {
                infoVo.setNickName(nickName + "****");
            } else {
                infoVo.setNickName(nickName.substring(0, nickName.length() - 1) + "****");
            }
            infoVo.setPic(member1.getPic());
            infoVoList.add(infoVo);
        });
        infoVoPage.setRecords(infoVoList);
        infoVoPage.setTotal(prodCommPage.getTotal());
        return infoVoPage;
    }
}
