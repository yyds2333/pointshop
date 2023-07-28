package com.powernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.powernode.domain.Member;
import com.powernode.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/p/user")
@Api
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/getMembersByOpenIds")
    @ApiOperation("远程获取商品详情页评论对象")
    public List<Member> getMemberListByOpenIds(@RequestParam("openIds")List<String> openIds){
        return memberService.list(new LambdaQueryWrapper<Member>()
                .in(Member::getOpenId,openIds));
    }
}
