package com.powernode.service;

import com.powernode.domain.Sku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SkuService extends IService<Sku>{


    List<Sku> getListByProdId(Long prodId);

    List<Sku> getListBySkuIds(List<Long> skuIds);
}
