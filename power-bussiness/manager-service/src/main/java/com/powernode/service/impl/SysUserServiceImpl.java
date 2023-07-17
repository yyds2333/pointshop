package com.powernode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.constant.BusConstant;
import com.powernode.domain.LoginSysUser;
import com.powernode.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.domain.SysUser;
import com.powernode.mapper.SysUserMapper;
import com.powernode.service.SysUserService;
import org.springframework.util.StringUtils;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 根据page和sysUser查询管理员列表
     * sysUser 获取店铺 ID，然后根据店铺ID获取属于这个店铺的管理员
     * @param page
     * @param sysUser
     * @return
     */
    @Override
    public Page<SysUser> getUserByPage(Page<SysUser> page, SysUser sysUser) {
        // 获取当前用户的店铺ID
        Long shopId = AuthUtil.getSysShopId();
        Page<SysUser> sysUserPage = sysUserMapper.selectPage(page, new LambdaQueryWrapper<SysUser>()
                .eq(!shopId.equals(BusConstant.ADMIN_ID), SysUser::getShopId, shopId)//
                .like(StringUtils.hasText(sysUser.getUsername()), SysUser::getUsername, sysUser.getUsername())
                .orderByDesc(SysUser::getCreateTime) // 通过创建时间排序

        );
        return sysUserPage;
    }

    /**
     * 根据id获取当前用户基本角色信息
     * @param sysUserId
     * @return
     */
    @Override
    public LoginSysUser getLoginUserById(Long sysUserId) {
        LoginSysUser sysUser = new LoginSysUser();
        SysUser sysUser1 = sysUserMapper.selectById(sysUserId);
        sysUser.setUsername(sysUser1.getUsername());
        sysUser.setStatus(sysUser1.getStatus());
        sysUser.setShopId(sysUser1.getShopId());
        return sysUser;
    }


}
