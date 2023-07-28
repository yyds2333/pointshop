package com.powernode.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.Prod;
import com.baomidou.mybatisplus.extension.service.IService;
import com.powernode.dto.ProdDto;
import com.powernode.model.ProdES;
import com.powernode.vo.ProdInfoVo;

import java.util.Date;
import java.util.List;

public interface ProdService extends IService<Prod>{


    // 产品展示
    Page<Prod> getProdByPage(Page<Prod> page, Prod prod);

    // 产品删除
    Integer deleteById(Long id);

    //商品修改获取信息
    ProdDto getProdInfo(Long prodId);

    // 修改商品
    Integer updateProd(ProdDto prodDto);

    // 添加商品
    Integer addProd(ProdDto prodDto);

    Integer updateByProdDto(ProdDto prodDto);

    // 为导入分页提供数据
    Integer selectCount(Date t1,Date t2);

    //为导入服务提供分页查询（增量导入 使用日期范围作为查询条件）
    List<ProdES> loadProdESwithPage(Page<Prod> page,Date t1,Date t2);

    ProdInfoVo getProdInfoVo(Long prodId);

}
