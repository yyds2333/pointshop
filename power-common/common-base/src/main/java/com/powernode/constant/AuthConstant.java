package com.powernode.constant;

import java.util.Arrays;
import java.util.List;

public interface AuthConstant {

    /**
     * 可以放行的地址
     */
    List<String> WHITE_URL = Arrays.asList("/auth-server/doLogin");

    /**
     * 请求token的前缀
     */
    String BEARER = "Bearer";

    /**
     *  token的请求头 key
     */
    String AUTHORIZATION = "Authorization";

    /**
     * redis中存储的token的前缀
     */
    String LOGIN_TOKEN_PREFIX = "login_token";

    /**
     * 登陆的地址
     */
    String LOGIN_URL = "/doLogin";

    /**
     * 登出的地址
     */
    String LOGOUT_URL = "/doLogout";

    /**
     * token的过期时间 3小时
     */
    Long TOKEN_EXPIRES_IN_TIME = 7200L;
    String ACCESS_TOKEN = "access_token";
    String EXPIRES_IN = "expires_in";
    String TYPE = "type";

    /**
     * token过期临界值
     */
    Long RENEW_EXPIRE_THRESHOLD = 300L;

    /**
     * 监控地址
     */
    String[] MONITOR_URLS = {"/actuator/**","/druid/**"};



    /**
     * 登陆类型
     * sysUser 管理员
     * member 商家
     */
    String LOGIN_TYPE = "loginType";
    String SYS_USER = "sysUser";
    String MEMBER = "member";

}
