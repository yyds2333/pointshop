package com.powernode.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.Transport;
import com.powernode.model.Result;
import com.powernode.service.TransportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("自提点管理接口")
@RequestMapping("/shop/transport")
public class TransPortController {

    @Autowired
    private TransportService transportService;
    @GetMapping("/page")
    public Result<Page<Transport>> loadTransportPage(Page<Transport> page, Transport transport){
        return Result.success("获取运费模板成功",transportService.loadTransportListByPage(page,transport));
    }


    @GetMapping("/list")
    public Result<List<Transport>> getTransportList(){
        return Result.success("获取列表成功",transportService.getTransportListByShopId());
    }

    @GetMapping("/info/{id}")
    public Result<Transport> getTransportById(@PathVariable Long id){
        return Result.success("获取数据成功",transportService.getById(id));
    }

    // 修改自提点

    // 删除自提点

    // 添加自提点
}
