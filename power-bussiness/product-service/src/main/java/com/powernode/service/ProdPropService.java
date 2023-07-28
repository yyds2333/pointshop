package com.powernode.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.ProdProp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ProdPropService extends IService<ProdProp>{


    Page<ProdProp> loadAllProp(Page<ProdProp> page, ProdProp prodProp);

    Integer addProdprop(ProdProp prodProp);

    Integer updateProdProp(ProdProp prodProp);
}
