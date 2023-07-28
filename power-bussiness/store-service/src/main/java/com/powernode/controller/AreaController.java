package com.powernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.powernode.domain.Area;
import com.powernode.model.Result;
import com.powernode.service.AreaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/area")
@Api("商店地址")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/list")
    public Result<List<Area>> getAreaList(){
        return Result.success("获取地址成功",areaService.loadAllArea());
    }

    @GetMapping("/listByPid")
    public Result<List<Area>> getAreaListByPid(@RequestParam(name = "pid",required = false,defaultValue = "0") String pid){
        return Result.success("获取成功",areaService.list(new LambdaQueryWrapper<Area>()
                .eq(Area::getParentId,pid)));
    }

}
