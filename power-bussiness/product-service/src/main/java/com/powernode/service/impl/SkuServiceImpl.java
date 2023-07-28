package com.powernode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.mapper.SkuMapper;
import com.powernode.domain.Sku;
import com.powernode.service.SkuService;

@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    /**
     * 通过商品id获取详情列表
     *
     * @param prodId
     * @return
     */
    @Override
    public List<Sku> getListByProdId(Long prodId) {
        return skuMapper.selectList(new LambdaQueryWrapper<Sku>().eq(Sku::getProdId, prodId));
    }

    /**
     * 通过SkuIds获取Sku列表
     *
     * @param skuIds
     * @return
     */
    @Override
    public List<Sku> getListBySkuIds(List<Long> skuIds) {
        return skuMapper.selectList(new LambdaQueryWrapper<Sku>()
                .eq(Sku::getStatus, 1)
                .in(Sku::getSkuId, skuIds));
    }
}
