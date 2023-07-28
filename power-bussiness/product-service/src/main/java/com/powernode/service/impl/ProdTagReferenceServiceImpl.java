package com.powernode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.powernode.domain.ProdTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.domain.ProdTagReference;
import com.powernode.mapper.ProdTagReferenceMapper;
import com.powernode.service.ProdTagReferenceService;
@Service
public class ProdTagReferenceServiceImpl extends ServiceImpl<ProdTagReferenceMapper, ProdTagReference> implements ProdTagReferenceService{


    @Autowired
    private ProdTagReferenceMapper prodTagReferenceMapper;
    @Override
    public List<Long> getListByProdId(Long prodId) {
        List<Long> tagList= new ArrayList<>();
        for (ProdTagReference prodTagReference : prodTagReferenceMapper.selectList(new LambdaQueryWrapper<ProdTagReference>()
                .eq(ProdTagReference::getProdId, prodId))) {
            tagList.add(prodTagReference.getTagId());
        }
        return tagList;
    }
}
