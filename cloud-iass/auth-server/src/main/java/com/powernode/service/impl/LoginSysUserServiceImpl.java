package com.powernode.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.domain.LoginSysUser;
import com.powernode.mapper.LoginSysUserMapper;
import com.powernode.service.LoginSysUserService;
@Service
public class LoginSysUserServiceImpl extends ServiceImpl<LoginSysUserMapper, LoginSysUser> implements LoginSysUserService {

}
