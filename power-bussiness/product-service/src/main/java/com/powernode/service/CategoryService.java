package com.powernode.service;

import com.powernode.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CategoryService extends IService<Category>{


    List<Category> loadAllCategory();

    Boolean updateCateGory(Category category);

    Boolean addCateGory(Category category);

    List<Category> getCategoryListByStatus();
}
