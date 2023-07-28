package com.powernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.powernode.domain.MemberAddr;
import com.powernode.model.Result;
import com.powernode.service.MemberAddrService;
import com.powernode.util.AuthUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/p/address")
@Api("会员收货地址管理")
public class MemberAddrController {


    @Autowired
    private MemberAddrService memberAddrService;

    @GetMapping("/list")
    @ApiOperation("全部收货地址")
    public Result<List<MemberAddr>> memberAddrList(){
        return Result.success("获取数据成功",memberAddrService.list(new LambdaQueryWrapper<MemberAddr>()
                .eq(MemberAddr::getOpenId, AuthUtil.getOpenId())));
    }

    @PostMapping
    @ApiOperation("添加地址")
    public Result<Integer> addMemberAddr(@RequestBody MemberAddr memberAddr){
        return Result.success("添加地址成功",memberAddrService.addMemberAddr(memberAddr));
    }

}
