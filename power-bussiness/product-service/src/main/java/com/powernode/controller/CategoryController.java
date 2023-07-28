package com.powernode.controller;

import com.powernode.domain.Category;
import com.powernode.model.Result;
import com.powernode.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod/category")
@Api("产品类别api接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取产品种类列表
     * 获取商品列表
     * @return
     */
    @GetMapping({"/table","/listCategory"})
    public Result<List<Category>> getProdTable() {
        // 不带缓存的查询
        // return Result.success("查询成功",categoryService.list());
        // 带缓存的查询
        return Result.success("查询成功", categoryService.loadAllCategory());
    }



    /**
     * 根据id进行删除操作
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('prod:category:delete')")
    public Result<Boolean> deleteById(@PathVariable("id") Long id) {
        return Result.success("删除Id为" + id + "的种类成功", categoryService.removeById(id));
    }

    /**
     * 根据前端传过来的数据修改category
     * @param category
     * @return
     */
    @PutMapping
    @PreAuthorize("hasAnyAuthority('prod:category:update')")
    public Result<Boolean> updateByCategory(@RequestBody Category category) {
        return Result.success("修改成功",categoryService.updateCateGory(category));
    }


    /**
     * 根据前台传来的category添加category
     * @param category
     * @return
     */
    @PostMapping
    @PreAuthorize("hasAnyAuthority('prod:category:save')")
    public Result<Boolean> addCateGory(@RequestBody Category category) {
        return Result.success("添加商品种类成功",categoryService.addCateGory(category));
    }

    /**
     * 根据id获取回显category数据
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAnyAuthority('prod:category:info')")
    public Result<Category> getCategoryById(@PathVariable("id") Long id){
        return Result.success("查找数据成功",categoryService.getById(id));
    }

    /**
     * 小程序获取数据
     */
    @GetMapping("/category/categoryInfo")
    @ApiOperation("前端获取产品类别的接口")
    public Result<List<Category>> wxGetCategoryList(){
        return Result.success("获取数据成功",categoryService.getCategoryListByStatus());
    }


}
