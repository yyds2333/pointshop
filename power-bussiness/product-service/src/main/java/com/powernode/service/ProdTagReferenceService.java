package com.powernode.service;

import com.powernode.domain.ProdTag;
import com.powernode.domain.ProdTagReference;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ProdTagReferenceService extends IService<ProdTagReference>{


    List<Long> getListByProdId(Long prodId);
}
