package com.powernode.util;

import com.powernode.domain.LoginMember;
import com.powernode.domain.LoginSysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AuthUtil {
    // 获取当前用户的userId
    public static Long getSysUserId(){
        // 获取安全上下文中的角色
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 从角色信息中获取角色对象
        LoginSysUser loginSysUser = (LoginSysUser) authentication.getPrincipal();
        return loginSysUser.getUserId();
    }

    // 获取当前用户的权限集合
    public static List<String> getSysUserPerms() {
        List<String> perms = new ArrayList<>();
        // 获取安全上下文中的角色
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 从角色信息中获取角色对象
        LoginSysUser loginSysUser = (LoginSysUser) authentication.getPrincipal();
        for (String perm : loginSysUser.getPerms()) {
            perms.add(perm);
        }
        return perms;
    }


    public static Long getSysShopId() {
        List<String> perms = new ArrayList<>();
        // 获取安全上下文中的角色
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 从角色信息中获取角色对象
        LoginSysUser loginSysUser = (LoginSysUser) authentication.getPrincipal();
        // 从loginSysUser获取店铺id
        return loginSysUser.getShopId();
    }

    public static String getOpenId(){
        // 获取安全上下文中的角色
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 从角色信息中获取角色对象
        LoginMember loginMember = (LoginMember) authentication.getPrincipal();

        return loginMember.getOpenId();
    }

    public static Integer getMemberId() {

        // 获取安全上下文中的角色
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 从角色信息中获取角色对象
        LoginMember loginMember = (LoginMember) authentication.getPrincipal();
        return loginMember.getId();
    }
}
