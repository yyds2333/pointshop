package com.powernode.service;

import com.powernode.domain.ProdPropValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ProdPropValueService extends IService<ProdPropValue>{


    List<ProdPropValue> getByProdId(Long prodId);
}
