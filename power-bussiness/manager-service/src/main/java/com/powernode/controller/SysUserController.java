package com.powernode.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.ann.MyLog;
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
    @MyLog(oprate = "获取当前用户信息")
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
    @MyLog(oprate = "分页获取管理员列表")
    @PreAuthorize("hasAnyAuthority('sys:user:page')")
    public Result<Page<SysUser>> getUserList(Page<SysUser> page,SysUser sysUser){
        // 通过MyBatisPlus 的分页拦截器，传入分页对象，根据sysUser 的 shopId 获取分页数据
        Page<SysUser> sysUserPage = sysUserService.getUserByPage(page,sysUser);
        return Result.success("获取管理员列表成功",sysUserPage);
    }

    /**
     * 根据sysUserId删除对应角色
     * @param sysUserIds
     * @return
     */
    @DeleteMapping("/{sysUserIds}")
    @MyLog(oprate = "根据sysUserId列表删除对应角色")
    public Result<Integer> deleteByUserId(@PathVariable("sysUserIds")Long... sysUserIds){
        Result result = null;
        if (sysUserIds.length == 1){
            result = Result.success("删除成功",sysUserService.deleteById(sysUserIds[0]));
        }else{
            result = Result.success("批量删除成功",sysUserService.deleteByIds(sysUserIds));
        }
        return result;
    }

    /**
     * 获取编辑回显数据
     * @param sysUserId
     * @return
     */
    @GetMapping("/info/{sysUserId}")
    @MyLog(oprate = "获取当前userId的用户信息")
    public Result<SysUser> getSysUserById(@PathVariable Long sysUserId){
        return Result.success("获取成功",sysUserService.getUserById(sysUserId));
    }

    /**
     * 添加新的角色对象
     * @param sysUser
     * @return
     */
    @PostMapping
    @MyLog(oprate = "添加新的角色对象")
    public Result<Integer> addSysUser(@RequestBody SysUser sysUser){
        return Result.success("添加成功",sysUserService.addSysUser(sysUser));
    }

    /**
     * 根据提交对象修改对应角色数据
     * @param sysUser
     * @return
     */
    @PutMapping
    @MyLog(oprate = "根据提交对象修改对应角色数据")
    public Result<Integer> updateSysUserById(@RequestBody SysUser sysUser){
        System.out.println(sysUser);
        return Result.success("修改成功",sysUserService.updateSysUser(sysUser));
    }

    /**
     * 根据传来的旧密码和新密码修改密码
     * @param password
     * @param newPassword
     * @return
     */
    @PutMapping("/password")
    @MyLog(oprate = "修改密码")
    public Result<Integer> updatePassword(String password,String newPassword){
        return Result.success("修改密码成功",sysUserService.updatePassword(password,newPassword));
    }



}
