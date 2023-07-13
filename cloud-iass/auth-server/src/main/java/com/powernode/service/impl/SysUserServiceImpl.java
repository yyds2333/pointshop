package com.powernode.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.domain.LoginSysUser;
import com.powernode.mapper.SysUserMapper;
import com.powernode.service.SysUserService;
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, LoginSysUser> implements SysUserService{

}
