package com.powernode.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.LoginSysUser;
import com.powernode.domain.SysUser;
import com.powernode.model.Result;
import com.powernode.service.SysUserService;
import com.powernode.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 获取当前用户信息
     * @return
     */
    @GetMapping("/info")
    public Result<LoginSysUser> info(){
        LoginSysUser sysUser = sysUserService.getLoginUserById(AuthUtil.getSysUserId());
        return Result.success("登陆成功",sysUser);
    }

    /**
     * 分页获取管理员列表
     * @param page
     * @param sysUser
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("hasAnyAuthority('sys:user:page')")
    public Result<Page<SysUser>> getUserList(Page<SysUser> page,SysUser sysUser){
        // 通过MyBatisPlus 的分页拦截器，传入分页对象，根据sysUser 的 shopId 获取分页数据
        Page<SysUser> sysUserPage = sysUserService.getUserByPage(page,sysUser);
        return Result.success("获取管理员列表成功",sysUserPage);
    }

    /**
     * 根据sysUserId删除对应角色
     * @param sysUserId
     * @return
     */
    @DeleteMapping("/{sysUserId}")
    public Result<Integer> deleteByUserId(@PathVariable("sysUserId")Long sysUserId){
        return Result.success("删除成功",sysUserService.deleteByIds(sysUserId));
    }

    /**
     * 获取编辑回显数据
     * @param sysUserId
     * @return
     */
    @GetMapping("/info/{sysUserId}")
    public Result<SysUser> getSysUserById(@PathVariable Long sysUserId){
        return Result.success("获取成功",sysUserService.getById(sysUserId));
    }

    /**
     * 添加新的角色对象
     * @param sysUser
     * @return
     */
    @PostMapping
    public Result<Integer> addSysUser(@RequestBody SysUser sysUser){
        return Result.success("添加成功",sysUserService.addSysUser(sysUser));
    }

    /**
     * 根据提交对象修改对应角色数据
     * @param sysUser
     * @return
     */
    @PutMapping
    public Result<Integer> updateSysUserById(@RequestBody SysUser sysUser){
        return Result.success("修改成功",sysUserService.updateSysUser(sysUser));
    }

}
