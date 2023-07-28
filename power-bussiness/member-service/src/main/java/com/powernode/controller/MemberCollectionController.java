package com.powernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.MemberCollection;
import com.powernode.model.ProdES;
import com.powernode.model.Result;
import com.powernode.service.MemberCollectionService;
import com.powernode.util.AuthUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/p/collection")
@Api("会员收藏接口")
public class MemberCollectionController {
    @Autowired
    private MemberCollectionService memberCollectionService;

    @GetMapping("/isCollection")
    @ApiOperation("获取商品收藏状态")
    public Result<Boolean> isCollection(Long prodId){
        // 根据pordId查询是否被放到收藏夹
        return Result.success("查询收藏状态成功",memberCollectionService.isCollectionByProdId(prodId));
    }

    @PostMapping("/addOrCancel")
    @ApiOperation("修改商品收藏状态")
    public Result<Integer> addCollection(@RequestBody Long prodId){
        // 根据pordId查询是否被放到收藏夹
        return Result.success("查询收藏状态成功",memberCollectionService.addOrCancel(prodId));
    }

    @GetMapping("/count")
    @ApiOperation("会员的收藏数量")
    public Result<Integer>  collectionCount(Long prodId){
        return Result.success("获取收藏数量成功",memberCollectionService.count(new LambdaQueryWrapper<MemberCollection>()
                .eq(MemberCollection::getOpenId, AuthUtil.getOpenId())));
    }

    @GetMapping("/prods")
    @ApiOperation("会员的收藏列表")
    public Result<Page<ProdES>> getMemberCollectionByPage(Page<MemberCollection> page){
        return Result.success("获取收藏数据成功",memberCollectionService.selectPageByOpenId(page,AuthUtil.getOpenId()));
    }
}
