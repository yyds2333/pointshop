package com.powernode.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.PickAddr;
import com.powernode.model.Result;
import com.powernode.service.PickAddrService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("自提点管理接口")
@RequestMapping("/shop/pickAddr")
public class PickAddrController {

    @Autowired
    private PickAddrService pickAddrService;

    /**
     * 加载自提点列表
     * @param page
     * @param pickAddr
     * @return
     */
    @GetMapping("/page")
    public Result<Page<PickAddr>> loadpickAddrPage(Page<PickAddr> page, PickAddr pickAddr){
        return Result.success("获取自提点列表成功",pickAddrService.loadpickAddrListByPage(page,pickAddr));
    }

    // 删除自提点 || 批量删除自提点

    // 添加自提点

    // 更新自提点


}
