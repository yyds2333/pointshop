package com.powernode.controller;

import com.powernode.dto.PhoneDto;
import com.powernode.model.Result;
import com.powernode.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/p/sms")
@Api("短信服务接口")
public class SmsController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @PostMapping("/send")
    @ApiOperation("前台调用发送短信")
    public Result<Integer> sendSms(@RequestBody PhoneDto phoneDto){
        memberService.send(phoneDto);
        return Result.success();
    }

    @PostMapping("/savePhone")
    @ApiOperation("校验验证码")
    public Result<Integer> savePhone(@RequestBody PhoneDto phoneDto){
        return Result.success("绑定成功",memberService.addMemberPhone(phoneDto));
    }

}
