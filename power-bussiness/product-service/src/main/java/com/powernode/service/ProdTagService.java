package com.powernode.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.ProdTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ProdTagService extends IService<ProdTag>{


    Page<ProdTag> loadProdPage(Page<ProdTag> page, ProdTag prodTag);

    List<ProdTag> loadProdTagsList();

    Integer addProdTag(ProdTag prodTag);

    Integer updateByProdTag(ProdTag prodTag);

    ProdTag getProdTagById(Long id);
}
