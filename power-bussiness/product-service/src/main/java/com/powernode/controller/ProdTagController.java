package com.powernode.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.ProdTag;
import com.powernode.model.Result;
import com.powernode.service.ProdTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod/prodTag")
@Api("商品标签服务接口")
public class ProdTagController {

    @Autowired
    private ProdTagService prodTagService;

    /**
     * 分页查询获取 标签列表
     * @param page
     * @param prodTag
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页查询获取 标签列表")
    public Result<Page<ProdTag>> loadProdTagList(Page<ProdTag> page,ProdTag prodTag){
        return Result.success("成功获取分组列表",prodTagService.loadProdPage(page,prodTag));
    }


    /**
     * 获取全部商品标签用于商品添加
     * @return
     */
    @GetMapping("/listTagList")
    @ApiOperation("获取全部商品标签用于商品添加")
    public Result<List<ProdTag>> getProdTagList(){
        return Result.success("获取标签数据成功",prodTagService.list());
    }


    /**
     * 添加prodTag
     */
    @PostMapping
    @ApiOperation("添加prodTag")
    public Result<Integer> addProdTag(@RequestBody ProdTag prodTag){
        return Result.success("添加成功",prodTagService.addProdTag(prodTag));
    }

    /**
     * 获取需要修改的prodTag的数据
     */
    @GetMapping("/info/{id}")
    @ApiOperation("获取需要修改的prodTag的数据")
    public Result<ProdTag> getProdTagById(@PathVariable Long id){
        return Result.success("获取成功",prodTagService.getProdTagById(id));
    }


    /**
     * 修改prodTag
     */
    @PutMapping
    @ApiOperation("修改prodTag")
    public Result<Integer> updateProdTag(@RequestBody ProdTag prodTag){
        return Result.success("修改成功",prodTagService.updateByProdTag(prodTag));
    }


    /**
     * 小程序获取标签列表用
     */
    @GetMapping("/prodTagList")
    @ApiOperation("小程序获取标签列表")
    public Result<List<ProdTag>> loadProdTagByList(){
        return Result.success("获取标签列表成功",prodTagService.loadProdTagsList());
    }


}
