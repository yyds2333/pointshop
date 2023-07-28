package com.powernode.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.model.ProdES;

import java.util.List;


public interface SearchService {
    Page<ProdES> getSearchProdList(String prodName, Integer current, Integer size, Integer sort);

    Page<ProdES> loadProdByTag(Long tagId, Integer size, Integer current);

    Page<ProdES> loadProdByCategoryId(Long cateGoryId, Integer current);

    Page<ProdES> loadProdPageByProdIds(Page<Long> page, List<Long> prodIds);
}
