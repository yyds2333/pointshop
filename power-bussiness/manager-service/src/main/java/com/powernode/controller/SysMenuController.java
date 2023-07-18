package com.powernode.controller;

import com.powernode.domain.SysMenu;
import com.powernode.model.Result;
import com.powernode.service.SysMenuService;
import com.powernode.util.AuthUtil;
import com.powernode.vo.MenuAndAuthVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "系统菜单管理API接口")
@RequestMapping("/sys/menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/nav")

    public Result<MenuAndAuthVo> getMenuAndAuth() {
        MenuAndAuthVo maa = new MenuAndAuthVo();
        List<SysMenu> menuByUserId = sysMenuService.getMenuByUserId(AuthUtil.getSysUserId());
        maa.setMenuList(menuByUserId);
        maa.setAuthorities(AuthUtil.getSysUserPerms());
        return Result.success("成功", maa);
    }
}
