package com.powernode.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.model.ProdES;
import com.powernode.model.Result;
import com.powernode.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("小程序搜索商品入口")
public class SearchController {
    @Autowired
    private SearchService searchService;

    /**
     * 搜索获取商品列表并高亮关键词
     * @param current
     * @param size
     * @param prodName
     * @param sort
     * @return
     */
    @GetMapping("/search/searchProdPage")
    public Result<Page<ProdES>> wxGetSearchProdList(Integer current, Integer size, String prodName, Integer sort){
        System.out.println(prodName);
        return Result.success("获取搜索数据成功",searchService.getSearchProdList(prodName,current,size,sort));
    }



    @GetMapping("/prod/prodListByTagId")
    @ApiOperation("根据商品标签获取商品")
    public Result<Page<ProdES>> getProdByTagIds(Long tagId, Integer size, @RequestParam(name = "current",required = false,defaultValue = "1") Integer current){
        return Result.success("获取数据成功",searchService.loadProdByTag(tagId,size,current));
    }

    @GetMapping("/prod/pageProd")
    @ApiOperation("根据类别获取商品")
    public Result<Page<ProdES>> getProdESByCategroyId(Long cateGoryId,@RequestParam(name = "current",required = false,defaultValue = "1") Integer current){
        return Result.success("获取商品成功",searchService.loadProdByCategoryId(cateGoryId,current));
    }


    @GetMapping("/prod/getProdPageByProdIds")
    public Page<ProdES> getProdPageByProdIds(@RequestParam("params")String params){
        Page<Long> page = JSON.parseObject(params, Page.class);
        List<Long> prodIds = page.getRecords();
        System.out.println("进入远程调用的对象");
        return searchService.loadProdPageByProdIds(page,prodIds);
    }



}
