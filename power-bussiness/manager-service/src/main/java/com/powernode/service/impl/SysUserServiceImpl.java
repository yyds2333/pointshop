package com.powernode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.constant.BusConstant;
import com.powernode.domain.LoginSysUser;
import com.powernode.domain.SysUserRole;
import com.powernode.mapper.SysRoleMapper;
import com.powernode.mapper.SysUserMapper;
import com.powernode.service.SysUserRoleService;
import com.powernode.service.SysUserService;
import com.powernode.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.domain.SysUser;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 根据page和sysUser查询管理员列表
     * sysUser 获取店铺 ID，然后根据店铺ID获取属于这个店铺的管理员
     *
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
     *
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

    /**
     * 添加角色
     *
     * @param sysUser
     * @return
     */
    @Override
    public Integer addSysUser(SysUser sysUser) {
        // 加密密码
        sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        // 添加修改日期
        sysUser.setCreateTime(new Date());
        // 设置添加人信息
        sysUser.setCreateUserId(AuthUtil.getSysUserId());
        int insert = sysUserMapper.insert(sysUser);
        // 添加角色信息
        if (insert > 0) {
            List<SysUserRole> sysUserRoles = new ArrayList<>();
            for (Long aLong : sysUser.getRoleIdList()) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setRoleId(aLong);
                sysUserRole.setUserId(sysUser.getUserId());
                sysUserRoles.add(sysUserRole);
            }
            boolean b = sysUserRoleService.saveBatch(sysUserRoles);
        }
        return insert;
    }

    /**
     * 修改对象
     *
     * @param sysUser
     * @return
     */
    @Override
    public Integer updateSysUser(SysUser sysUser) {
        // 如果没有设置 或 属性为 ”“ 空串则不修改
        if (sysUser.getPassword() == null || sysUser.getPassword().equals("")) {
            sysUser.setPassword(sysUserMapper.selectById(sysUser.getUserId()).getPassword());
        } else {
            // 对密码进行加密
            sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        }
        int count = sysUserMapper.update(sysUser, new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUserId, sysUser.getUserId()));
        // 先删除原有角色，再插入
        if (count > 0) {
            boolean remove = sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>()
                    .eq(SysUserRole::getUserId, sysUser.getUserId()));
            if (remove) {
                // 插入新角色
                List<Long> roleIdList = sysUser.getRoleIdList();
                roleIdList.forEach(System.out::println);
                List<SysUserRole> sysUserRoles = new ArrayList<>();
                // 如果角色列表不为空
                if (!CollectionUtils.isEmpty(roleIdList)) {
                    roleIdList.forEach(roleId -> {
                        SysUserRole sysUserRole = new SysUserRole();
                        sysUserRole.setUserId(sysUser.getUserId());
                        sysUserRole.setRoleId(roleId);
                        sysUserRoles.add(sysUserRole);
                    });
                    // 批量插入角色
                    boolean b = sysUserRoleService.saveBatch(sysUserRoles);
                }
            }

        }
        // 返回插入的数量
        return count;
    }

    /**
     * 删除单个数据
     *
     * @param sysUserId
     * @return
     */
    @Override
    public Integer deleteById(Long sysUserId) {
        // 删除该用户角色信息
        // 删除角色信息
        boolean remove = sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>()
                .eq(SysUserRole::getUserId, sysUserId));
        // 删除 人物信息
        Integer i = 0;sysUserMapper.deleteById(sysUserId);
        return i;
    }

    /**
     * 获取用户信息并回显到前端
     * @param sysUserId
     * @return
     */
    @Override
    public SysUser getUserById(Long sysUserId) {
        SysUser sysUser = sysUserMapper.selectById(sysUserId);
        // 获取当前用户角色信息
        List<Long> sysRoleList = sysUserRoleService.getbyUserId(sysUserId);
        // 将当前用户角色信息设置给sysUser
        sysUser.setRoleIdList(sysRoleList);
        return sysUser;
    }

    /**
     * 修改密码
     * @param password
     * @param newPassword
     * @return
     */
    @Override
    public Integer updatePassword(String password, String newPassword) {
        // 如果旧密码或新密码不存在，则不允许更改密码
        if (ObjectUtils.isEmpty(password)||ObjectUtils.isEmpty(newPassword)){
            throw new IllegalArgumentException("参数错误");
        }
        SysUser sysUser = sysUserMapper.selectById(AuthUtil.getSysUserId());
        int count = 0;
        if (!ObjectUtils.isEmpty(sysUser)){
            // 查询当前用户,如果当前密码与传输过来的旧密码相同，则进行密码修改操作
            if (sysUser.getPassword().equals(password)){
                sysUser.setPassword(newPassword);
                count = sysUserMapper.updateById(sysUser);
            }
        }
        return count;
    }

    /**
     * 根据ID 批量删除角色
     *
     * @param sysUserIds
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Integer deleteByIds(Long... sysUserIds) {
        // 删除该用户角色信息
        int i = 0;
        for (Long id : sysUserIds) {
            int j = i;
            i += sysUserMapper.deleteById(id);
            // 如果删除人物信息成功，删除人物对应的角色信息
            if (i > j){
                boolean remove = sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>()
                        .eq(SysUserRole::getUserId, id));
            }
        }
        // 返回删除个数
        return i;
    }


}
