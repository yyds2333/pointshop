package com.powernode.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.LoginSysUser;
import com.powernode.domain.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
public interface SysUserService extends IService<SysUser>{


    /**
     * 根据page和sysUser查询管理员列表
     * @param page
     * @param sysUser
     * @return
     */
    Page<SysUser> getUserByPage(Page<SysUser> page, SysUser sysUser);

    LoginSysUser getLoginUserById(Long sysUserId);
}
