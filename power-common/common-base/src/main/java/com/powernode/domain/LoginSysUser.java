package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

/**
    * 系统登录用户
    */
@Data
@TableName(value = "sys_user")
public class LoginSysUser implements Serializable, UserDetails {
    @TableId(value = "user_id", type = IdType.INPUT)
    private Long userId;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 邮箱
     */
//    @TableField(value = "email")
//    private String email;

    /**
     * 手机号
     */
//    @TableField(value = "mobile")
//    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    @TableField(value = "`status`")
    private Byte status;

    /**
     * 创建者ID
     */
//    @TableField(value = "create_user_id")
//    private Long createUserId;

    /**
     * 创建时间
     */
//    @TableField(value = "create_time")
//    private Date createTime;

    /**
     * 用户所在的商城Id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    // 用户的权限合集,不需要跟数据库中的中的列映射
    @TableField(exist = false)
    private Set<String> perms = new HashSet<>();

    /**
     * 取出数据库中用户的权限，拆分开赋值给perms
     * @param myperms
     */
    public void setPerms(Set<String> myperms){
        Set<String> realPerems = new HashSet<>();
        myperms.forEach(perm->{
            if (perm.contains(",")){
                for (String s : perm.split(",")) {
                    realPerems.add(s);
                }
            }else{
                realPerems.add(perm);
            }
        });
        this.perms = realPerems;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return status == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return status == 1;
    }

    @Override
    public boolean isEnabled() {
        return status == 1;
    }




}