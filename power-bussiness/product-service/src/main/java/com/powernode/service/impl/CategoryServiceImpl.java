package com.powernode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.powernode.constant.CategoryConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.domain.Category;
import com.powernode.mapper.CategoryMapper;
import com.powernode.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
// 开启缓存
@CacheConfig(cacheNames = "com.powernode.service.impl.CategoryServiceImpl")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    @Cacheable(key = CategoryConstant.ALL_CATEGORY_KEY)
    public List<Category> loadAllCategory() {

        return categoryMapper.selectList(new LambdaQueryWrapper<Category>().orderByDesc(Category::getSeq));
    }

    /**
     * 修改category表
     *
     * @param category
     * @return
     */
    @Override
    public Boolean updateCateGory(Category category) {
        category.setUpdateTime(new Date());
        int i = categoryMapper.updateById(category);
        return i > 0;
    }

    /**
     * 添加category
     * 并添加缓存
     * @param category
     * @return
     */
    @Override
    @CacheEvict(key = CategoryConstant.ALL_CATEGORY_KEY)
    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean addCateGory(Category category) {
        System.err.println(category);
        // 如果没有父类，直接跳过
        if (!ObjectUtils.isEmpty(category.getParentId())){
            // 如果添加的父类不存在，则报错
            if (ObjectUtils.isEmpty(categoryMapper.selectOne(new LambdaQueryWrapper<Category>().eq(Category::getCategoryId, category.getParentId())))) {
                throw new IllegalArgumentException("该数据不存在");
            }
        }
        // 添加category到数据库
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        int insert = categoryMapper.insert(category);
        return insert > 0;
    }

    /**
     * 获取所有启用的商品分组
     * @return
     */
    @Override
    public List<Category> getCategoryListByStatus() {
        return categoryMapper.selectList(new LambdaQueryWrapper<Category>()
                .eq(Category::getStatus,1));
    }
}
