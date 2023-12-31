package com.powernode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.powernode.domain.LoginSysUser;

import java.util.Set;

public interface LoginSysUserMapper extends BaseMapper<LoginSysUser> {
    Set<String> selectPermsById(Long sysUserId);
}