package com.powernode.controller;

import com.powernode.domain.Category;
import com.powernode.model.Result;
import com.powernode.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prod/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/table")
    public Result<List<Category>> getProdTable(){
        // 不带缓存的查询
        // return Result.success("查询成功",categoryService.list());
        // 带缓存的查询
        return Result.success("查询成功",categoryService.loadAllCategory());
    }
}
