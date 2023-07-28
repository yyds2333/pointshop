package com.powernode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.powernode.domain.ProdComm;
import com.powernode.domain.ProdTagReference;
import com.powernode.vo.ProdCommStatics;
import com.powernode.vo.ProdCommVo;

import java.util.List;

public interface ProdCommMapper extends BaseMapper<ProdComm> {
    List<ProdCommStatics> selectProdCommStatic(List<Long> prodIdList);

    ProdCommVo selectCommSum(Long prodId);
}