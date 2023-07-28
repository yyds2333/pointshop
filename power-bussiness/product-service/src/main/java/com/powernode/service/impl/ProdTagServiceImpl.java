package com.powernode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.constant.ProdTagConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.mapper.ProdTagMapper;
import com.powernode.domain.ProdTag;
import com.powernode.service.ProdTagService;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

@Service
@CacheConfig(cacheNames = "com.powernode.service.impl.ProdTagServiceImpl")
public class ProdTagServiceImpl extends ServiceImpl<ProdTagMapper, ProdTag> implements ProdTagService{

    @Autowired
    private ProdTagMapper prodTagMapper;

    /**
     * 通过分页和标签数据，获取标签列表
     * @param page
     * @param prodTag
     * @return
     */
    @Override
    @Cacheable(key = ProdTagConstant.PROD_TAG_KEY)
    public Page<ProdTag> loadProdPage(Page<ProdTag> page, ProdTag prodTag) {
        return prodTagMapper.selectPage(page, new LambdaQueryWrapper<ProdTag>()
                .like(!ObjectUtils.isEmpty(prodTag.getTitle()), ProdTag::getTitle, prodTag.getTitle())
                .eq(!ObjectUtils.isEmpty(prodTag.getStatus()), ProdTag::getStatus, prodTag.getStatus())
                .orderByAsc(ProdTag::getCreateTime));
    }



    /**
     * 小程序获取商品标签列表
     * @return
     */
    @Override
    public List<ProdTag> loadProdTagsList() {
        return prodTagMapper.selectList(new LambdaQueryWrapper<ProdTag>()
                .select(ProdTag::getTitle,ProdTag::getId,ProdTag::getStyle)
                .eq(ProdTag::getStatus,true)
                .orderByDesc(ProdTag::getCreateTime));
    }

    /**
     * 添加prodTag到数据库
     * @param prodTag
     * @return
     */
    @Override
    @CacheEvict(key = ProdTagConstant.PROD_TAG_KEY)
    public Integer addProdTag(ProdTag prodTag) {
        prodTag.setCreateTime(new Date());
        prodTag.setUpdateTime(new Date());
        return prodTagMapper.insert(prodTag);
    }

    /**
     * 修改prodTag
     * @param prodTag
     * @return
     */
    @Override
    @CacheEvict(key = ProdTagConstant.PROD_TAG_KEY)
    public Integer updateByProdTag(ProdTag prodTag) {
        prodTag.setUpdateTime(new Date());
        return prodTagMapper.updateById(prodTag);
    }

    /**
     * 根据id获取prodTag
     * @param id
     * @return
     */
    @Override
    public ProdTag getProdTagById(Long id) {
        return prodTagMapper.selectOne(new LambdaQueryWrapper<ProdTag>()
                .eq(ProdTag::getId,id));
    }


}
