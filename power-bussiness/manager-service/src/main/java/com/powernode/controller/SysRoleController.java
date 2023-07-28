package com.powernode.controller;

import com.powernode.ann.MyLog;
import com.powernode.domain.SysRole;
import com.powernode.model.Result;
import com.powernode.service.SysRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "系统角色管理API接口")
@RequestMapping("/sys/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/list")
    @MyLog(oprate = "获取管理员列表")
    public Result<List<SysRole>> getUserDetails(){
        return Result.success("获取信息成功",sysRoleService.list());
    }
}
