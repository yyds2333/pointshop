package com.powernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.powernode.domain.Basket;
import com.powernode.domain.Prod;
import com.powernode.model.Result;
import com.powernode.service.BasketService;
import com.powernode.util.AuthUtil;
import com.powernode.vo.CartIem;
import com.powernode.vo.CartVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("购物车服务接口")
@RequestMapping("/p")
public class CartController {

    @Autowired
    private BasketService basketService;

    @GetMapping("/shopCart/prodCount")
    @ApiOperation("获取购物车商品数量")
    public Result<Integer> getCartCount(){
        return Result.success("获取数量成功",basketService.getProdCount());
    }

    @GetMapping("/info")
    @ApiOperation("获取当前用户的购物车详情")
    public Result<CartVo> getCartDetails(){
        return Result.success("获取数据成功",basketService.selectCartInfoVo());
    }

    @PostMapping("/changeItem")
    @ApiOperation("添加商品到购物车")
    public Result<Integer> addProdToCart(@RequestBody Basket basket){
        return Result.success("添加到购物车成功",basketService.addProdToC(basket));
    }

}
