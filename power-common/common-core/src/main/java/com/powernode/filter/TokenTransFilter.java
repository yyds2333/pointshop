package com.powernode.filter;

import com.powernode.constant.AuthConstant;
import com.powernode.util.PathMatchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 用户携带token访问后端时，需要根据token访问redis
 * 获取用户身份信息及权限信息后，转换为security需要的身份对象
 * 保存到security上下文中
 */
@Configuration
public class TokenTransFilter extends OncePerRequestFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 放行不需要拦截的资源
        String uri = request.getRequestURI();
        if (PathMatchUtil.compare(uri)) {
            filterChain.doFilter(request, response);
            return;
        }
        // 获取用户 Authorization 解析 token
        String authorization = request.getHeader(AuthConstant.AUTHORIZATION);
        // 如果存在authorization，则继续
        if (StringUtils.hasText(authorization)) {
            String token = authorization.replaceFirst(AuthConstant.BEARER, "");
            // 获取token过期时间
            Long expire = stringRedisTemplate.getExpire(AuthConstant.LOGIN_TOKEN_PREFIX + token, TimeUnit.SECONDS);
            if (!ObjectUtils.isEmpty(expire) && expire < AuthConstant.RENEW_EXPIRE_THRESHOLD) {
                stringRedisTemplate.opsForValue().set(AuthConstant.LOGIN_TOKEN_PREFIX + token,null,AuthConstant.TOKEN_EXPIRES_IN_TIME,TimeUnit.SECONDS);
            }
        }
    }
}
