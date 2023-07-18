package com.powernode.service.impl;

import com.powernode.constant.CategoryConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.domain.Category;
import com.powernode.mapper.CategoryMapper;
import com.powernode.service.CategoryService;
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    @Cacheable(key = CategoryConstant.ALL_CATEGORY_KEY)
    public List<Category> loadAllCategory() {

        return categoryMapper.selectList(null);
    }
}
