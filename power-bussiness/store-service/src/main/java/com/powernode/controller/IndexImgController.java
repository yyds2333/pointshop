package com.powernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.IndexImg;
import com.powernode.model.Result;
import com.powernode.service.IndexImgService;
import com.powernode.util.AuthUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/indexImg")
@Api("商店轮播图")
public class IndexImgController {

    @Autowired
    private IndexImgService indexImgService;

    /**
     * 加载轮播图到前台
     *
     * @param page
     * @param indexImg
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("轮播图分页加载")
    public Result<Page<IndexImg>> loadIndexImgPage(Page<IndexImg> page, IndexImg indexImg) {
        return Result.success("获取轮播图成功", indexImgService.loadIndexImgListByPage(page, indexImg));
    }

    // 添加轮播图
    @PostMapping
    @ApiOperation("添加轮播图")
    public Result<Integer> addIndexImg(@RequestBody IndexImg indexImg) {
        return Result.success("添加轮播图成功", indexImgService.addIndexImg(indexImg));
    }

    // 删除轮播图
    @DeleteMapping("/{indexImgIds}")
    @ApiOperation("删除轮播图")
    public Result<Integer> deleteIndexImgById(@PathVariable("indexImgIds") Long... indexImgIds) {
        Result result = null;
        if (indexImgIds != null){
            result = Result.success("成功",indexImgService.deleteIndexImg(indexImgIds));
        }else{
            result = Result.failure(HttpStatus.SC_INTERNAL_SERVER_ERROR,"参数错误");
        }
        return result;
    }

    // 获取需要修改的轮播图数据
    @GetMapping("/info/{id}")
    @ApiOperation("获取需要修改的轮播图数据")
    public Result<IndexImg> getIndexImgById(@PathVariable Long id){
        return Result.success("获取数据成功",indexImgService.getById(id));
    }

    // 修改轮播图
    @PutMapping
    @ApiOperation("修改轮播图")
    public Result<Integer> updateIndexImg(@RequestBody IndexImg indexImg){
        return Result.success("修改成功",indexImgService.updateIndexImgById(indexImg));
    }
    /**
     * 小程序所需数据
     */

    @GetMapping("/indexImgs")
    @ApiOperation("前台小程序获取轮播图")
    public Result<List<IndexImg>> loadIndexImgs(){
        return Result.success("获取轮播图列表成功",indexImgService.loadIndexImgMall());
    }


}
