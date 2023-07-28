package com.powernode.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.Prod;
import com.powernode.domain.ProdComm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.powernode.vo.ProdCommInfoVo;
import com.powernode.vo.ProdCommVo;

import java.util.List;

public interface ProdCommService extends IService<ProdComm>{


    Page<ProdComm> loadAllProp(Page<ProdComm> page, ProdComm prodComm);

    List<ProdComm> getListByProdId(Long prodId);

    ProdCommVo getProdCommDetails(Long prodId);

    Page<ProdCommInfoVo> getProdCommPageProdId(Page<ProdComm> page, Long prodId,Integer evaluate);
}
