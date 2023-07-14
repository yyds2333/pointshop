package com.powernode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginSuccess{
    // token的值
    private String accessToken;
    // 到期时间
    private String expiresIn;
    // 登录用户类型
    private String type;
}
