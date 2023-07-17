package com.powernode.controller;

import com.powernode.domain.SysRole;
import com.powernode.domain.SysUser;
import com.powernode.model.Result;
import com.powernode.service.SysRoleService;
import com.powernode.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "系统角色管理API接口")
@RequestMapping("/sys/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/list")
    public Result<List<SysRole>> getUserDetails(){
        return Result.success("获取信息成功",sysRoleService.list());
    }
}
