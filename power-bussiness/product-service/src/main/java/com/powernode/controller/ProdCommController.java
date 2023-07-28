package com.powernode.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.ProdComm;
import com.powernode.domain.ProdProp;
import com.powernode.model.Result;
import com.powernode.service.ProdCommService;
import com.powernode.vo.ProdCommInfoVo;
import com.powernode.vo.ProdCommVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prod/prodComm")
public class ProdCommController {

    @Autowired
    private ProdCommService prodCommService;

    /**
     * 获取评论
     * @param page
     * @param prodComm
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("hasAnyAuthority('prod:prodComm:page')")
    public Result<Page<ProdComm>> loadProdPropPage(Page<ProdComm> page, ProdComm prodComm){
        return Result.success("获取规格成功",prodCommService.loadAllProp(page,prodComm));
    }

    @GetMapping("/prodComm/prodCommData")
    @ApiOperation("商品详情页获取评论")
    public Result<ProdCommVo> getProdCommByProdId(Long prodId){
        return Result.success("获取当前商品评论成功",prodCommService.getProdCommDetails(prodId));
    }

    @GetMapping("/prodComm/prodCommPageByProd")
    @ApiOperation("商品分页获取评论")
    public Result<Page<ProdCommInfoVo>> getProdCommPageByProdId(Long prodId,Page<ProdComm> page, Integer evaluate){
        return Result.success("获取商品分页评论成功",prodCommService.getProdCommPageProdId(page,prodId,evaluate));
    }
}
