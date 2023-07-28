package com.powernode.feign;

import com.powernode.domain.Sku;

import java.util.List;

public class SkuFeignImpl implements SkuFeign{
    @Override
    public List<Sku> getSkuListBySkuIds(List<Long> skuIds) {
        return null;
    }
}
