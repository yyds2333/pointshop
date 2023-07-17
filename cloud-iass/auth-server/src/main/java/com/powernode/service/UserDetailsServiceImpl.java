package com.powernode.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.powernode.constant.AuthConstant;
import com.powernode.domain.LoginSysUser;
import com.powernode.mapper.LoginSysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginSysUserMapper loginSysUserMapper;


    // 自定义用户登录方法
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从 ServletRequestAttributes 中获取 获取请求 并 获取角色类型
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String loginType = request.getHeader(AuthConstant.LOGIN_TYPE);
        // 如果没有角色类型，则认定为非法访问
        if (!StringUtils.hasText(loginType)){
            throw new IllegalArgumentException("非法的用户类型");
        }
        LoginSysUser loginSysUser = null;
        // 根据访问角色的类型来决定用户权限
        switch (loginType){
            // 管理员权限
            case AuthConstant.SYS_USER:{
                // 根据用户名查询用户表
                loginSysUser = loginSysUserMapper.selectOne(new LambdaQueryWrapper<LoginSysUser>()
                        .eq(LoginSysUser::getUsername,username));
                // 如果该用户存在,则获取该用户的权限
                if (!ObjectUtils.isEmpty(loginSysUser)){
                    Set<String> myPerms = loginSysUserMapper.selectPermsById(loginSysUser.getUserId());
                    // 如果权限不为空，则将权限存放到LoginSysUser中
                    if (!CollectionUtils.isEmpty(myPerms)){
                        loginSysUser.setPerms(myPerms);
                    }
                    myPerms.forEach(System.out::println);
                    // 将UserDetails的实现类返回出去
                    return loginSysUser;
                }
            }
            // 如果是会员角色 ，则
            case AuthConstant.MEMBER:{

            }
        }
        return loginSysUser;
    }
}
