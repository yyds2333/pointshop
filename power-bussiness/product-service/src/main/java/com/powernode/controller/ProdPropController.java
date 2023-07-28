package com.powernode.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.ProdProp;
import com.powernode.domain.ProdPropValue;
import com.powernode.model.Result;
import com.powernode.service.ProdPropService;
import com.powernode.service.ProdPropValueService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod/spec")
public class ProdPropController {
    @Autowired
    private ProdPropService prodPropService;

    @Autowired
    private ProdPropValueService prodPropValueService;

    /**
     * 获取规格详情
     * @param page
     * @param prodProp
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("hasAnyAuthority('prod:spec:page')")
    public Result<Page<ProdProp>> loadProdPropPage(Page<ProdProp> page,ProdProp prodProp){
        return Result.success("获取规格成功",prodPropService.loadAllProp(page,prodProp));
    }

    /**
     * 获取全部规格
     * @return
     */
    @GetMapping("/list")
    public Result<List<ProdProp>> getProdPropList(){
        return Result.success("获取成功",prodPropService.list());
    }


    /**
     * 根据商品id值查询对应规格
     * @param prodId
     * @return
     */
    @GetMapping("/listSpecValue/{prodId}")
    @ApiOperation("根据属性ID获取属性值的集合")
    public Result<List<ProdPropValue>> getPropValues(@PathVariable Long prodId){
        return Result.success("查询该商品规格值成功", prodPropValueService.getByProdId(prodId));
    }


    @PostMapping
    public Result<Integer> addProdProp(@RequestBody ProdProp prodProp){
        return Result.success("添加数据成功",prodPropService.addProdprop(prodProp));
    }


    @PutMapping
    public Result<Integer> updateProdProp(@RequestBody ProdProp prodProp){
        return Result.success("添加数据成功",prodPropService.updateProdProp(prodProp));
    }

}
