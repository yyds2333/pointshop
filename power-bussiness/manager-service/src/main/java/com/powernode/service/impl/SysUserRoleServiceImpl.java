package com.powernode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.mapper.SysUserRoleMapper;
import com.powernode.domain.SysUserRole;
import com.powernode.service.SysUserRoleService;
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService{

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    /**
     * 获取当前用户 角色信息列表
     * @param sysUserId
     * @return
     */
    @Override
    public List<Long> getbyUserId(Long sysUserId) {
//        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectList(new LambdaQueryWrapper<SysUserRole>()
//                .eq(SysUserRole::getUserId, sysUserId));
//        List<Object> list = sysUserRoleMapper.selectObjs(new LambdaQueryWrapper<SysUserRole>().select(SysUserRole::getRoleId).eq(SysUserRole::getUserId, sysUserId));
        // 通过查询获取sysRoleId列表并转化返回
        List<Object> list = sysUserRoleMapper.selectObjs(new QueryWrapper<SysUserRole>().lambda().select(SysUserRole::getRoleId).eq(SysUserRole::getUserId, sysUserId));
        List<Long> longs = new ArrayList<>();
        list.forEach(xx->{
            longs.add(Long.valueOf(String.valueOf(xx)));
        });
        return longs;
    }
}
