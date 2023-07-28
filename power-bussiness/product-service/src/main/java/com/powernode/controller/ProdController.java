package com.powernode.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.Prod;
import com.powernode.domain.Sku;
import com.powernode.dto.ProdDto;
import com.powernode.model.ProdES;
import com.powernode.model.Result;
import com.powernode.service.ProdService;
import com.powernode.service.SkuService;
import com.powernode.vo.ProdInfoVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod/prod")
@Api(value = "商品管理接口Api")
public class ProdController {

    @Autowired
    private ProdService prodService;

    @Autowired
    private SkuService skuService;

    @GetMapping("/page")
    // 获取日志信息
    @PreAuthorize("hasAnyAuthority('prod:prod:page')")
    public Result<Page<Prod>> loadProdPage( Page<Prod> page,Prod prod){
        return Result.success("获取商品列表成功",prodService.getProdByPage(page,prod));
    }

    /**
     * 获取需要修改的产品信息
     * @param prodId
     * @return
     */
    @GetMapping("/info/{prodId}")
    public Result<ProdDto> getProdInfo(@PathVariable Long prodId){
        return Result.success("修改成功",prodService.getProdInfo(prodId));
    }


    @PutMapping
    @PreAuthorize("hasAnyAuthority('prod:prod:update')")
    public Result<Integer> updateProd(@RequestBody ProdDto prodDto){
        return Result.success("修改成功",prodService.updateByProdDto(prodDto));
    }


    @PostMapping
    @PreAuthorize("hasAnyAuthority('prod:prod:save')")
    public Result<Integer> addProd(@RequestBody ProdDto prodDto){
        return Result.success("修改成功",prodService.addProd(prodDto));
    }

    /**
     * 小程序获取商品详情根据prodID
     */
    @GetMapping("/prod/prodInfo")
    public Result<ProdInfoVo> wxAppGetProdByProdId(Long prodId){
        return Result.success("获取商品详情成功",prodService.getProdInfoVo(prodId));
    }

    @GetMapping("/getSkuListBySkuIds")
    public List<Sku> getSkuListBySkuIds(@RequestParam("skuIds")List<Long> skuIds){
        return skuService.getListBySkuIds(skuIds);
    }

}
