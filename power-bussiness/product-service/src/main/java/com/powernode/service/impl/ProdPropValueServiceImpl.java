package com.powernode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.mapper.ProdPropValueMapper;
import com.powernode.domain.ProdPropValue;
import com.powernode.service.ProdPropValueService;

@Service
public class ProdPropValueServiceImpl extends ServiceImpl<ProdPropValueMapper, ProdPropValue> implements ProdPropValueService {

    @Autowired
    private ProdPropValueMapper prodPropValueMapper;

    /**
     * 级联获取规格值
     * @param prodId
     * @return
     */
    @Override
    public List<ProdPropValue> getByProdId(Long prodId) {
        List<ProdPropValue> prodPropValues = prodPropValueMapper.selectList(new LambdaQueryWrapper<ProdPropValue>()
                .eq(ProdPropValue::getPropId, prodId));
        return prodPropValues;
    }
}
