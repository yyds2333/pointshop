package com.powernode.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.HotSearch;
import com.powernode.model.Result;
import com.powernode.service.HotSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hotSearch")
@Api("商店热搜")
public class HotSearchController {

    @Autowired
    private HotSearchService hotSearchService;

    /**
     * 加载热搜数据
     * @param page
     * @param hotSearch
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("加载热搜数据")
    public Result<Page<HotSearch>> loadHotSearchPage(Page<HotSearch> page, HotSearch hotSearch){
        return Result.success("获取热搜成功",hotSearchService.loadHotSearchListByPage(page,hotSearch));
    }

    // 添加热搜
    @PostMapping
    @ApiOperation("添加热搜")
    public Result<Integer> addHotSearch(@RequestBody HotSearch hotSearch){
        return Result.success("添加热搜成功",hotSearchService.addHotSearch(hotSearch));
    }

    // 删除热搜 || 批量删除热搜
    @DeleteMapping("/{ids}")
    @ApiOperation("删除热搜")
    public Result<Integer> deleteHotSearchByIds(@PathVariable Long... ids){
        return Result.success("删除热搜成功",hotSearchService.deleteHotSearchByIds(ids));
    }

    // 获取需要修改的热搜的数据
    @GetMapping("/info/{id}")
    @ApiOperation("获取需要修改的热搜的数据")
    public Result<HotSearch> getHotSearchById(@PathVariable Long id){
        return Result.success("获取热搜成功",hotSearchService.getById(id));
    }


    // 修改热搜
    @PutMapping
    @ApiOperation("修改热搜")
    public Result<Integer> updateHotSearch(@RequestBody HotSearch hotSearch){
        return Result.success("添加热搜",hotSearchService.updateHotSearch(hotSearch));
    }

    /**
     * 小程序获取热搜列表
     */
    @GetMapping("/hotSearchByShopId")
    @ApiOperation("修改热搜")
    public Result<List<HotSearch>> getHotSearchList(Integer number,Long shopId,Integer sort){
        return Result.success("获取热搜",hotSearchService.getHotSearchList(number,shopId,sort));
    }


}
