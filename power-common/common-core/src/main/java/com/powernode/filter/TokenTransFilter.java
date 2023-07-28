package com.powernode.filter;

import com.alibaba.fastjson.JSON;
import com.powernode.constant.AuthConstant;
import com.powernode.constant.ResourceConstant;
import com.powernode.domain.LoginMember;
import com.powernode.domain.LoginSysUser;
import com.powernode.model.Result;
import com.powernode.util.PathMatchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 用户携带token访问后端时，需要根据token访问redis
 * 获取用户身份信息及权限信息后，转换为security需要的身份对象
 * 保存到security上下文中
 */
@Configuration
public class TokenTransFilter extends OncePerRequestFilter {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 放行不需要拦截的资源
        String uri = request.getRequestURI();
        if (PathMatchUtil.compare(ResourceConstant.RESOURCE_ALLOW_URLS,uri)) {
            filterChain.doFilter(request, response);
            return;
        }
        // 获取用户 Authorization 解析 token
        String authorization = request.getHeader(AuthConstant.AUTHORIZATION);
        // 如果存在authorization，则继续
        if (StringUtils.hasText(authorization)) {
            String token = authorization.replaceFirst(AuthConstant.BEARER, "");
            if (StringUtils.hasText(token)) {
                // 获取token过期时间
                Long expire = redisTemplate.getExpire(AuthConstant.LOGIN_TOKEN_PREFIX + token, TimeUnit.SECONDS);
                if (!ObjectUtils.isEmpty(expire) && expire < AuthConstant.RENEW_EXPIRE_THRESHOLD) {
                    // 重新设定过期时间
                    redisTemplate.expire(AuthConstant.LOGIN_TOKEN_PREFIX + token, AuthConstant.TOKEN_EXPIRES_IN_TIME, TimeUnit.SECONDS);
                }
                // 根据token获取Reids中的身份
                System.err.println("authenticationToken = " + token);
                String userStr = redisTemplate.opsForValue().get(AuthConstant.LOGIN_TOKEN_PREFIX + token);
                // token 转换成用户对象
                String loginType = request.getHeader(AuthConstant.LOGIN_TYPE);
                UsernamePasswordAuthenticationToken authenticationToken = JSON.parseObject(userStr, UsernamePasswordAuthenticationToken.class);
                // 获取真实用户token
                UsernamePasswordAuthenticationToken realToken = null;
                System.err.println("authenticationToken = " + authenticationToken.getPrincipal().toString());
                // 判断用户类型
                switch (loginType) {
                    // 用户是管理员
                    case (AuthConstant.SYS_USER): {
                        //获取用户信息转换成当前登录对象
                        LoginSysUser loginSysUser = JSON.parseObject(authenticationToken.getPrincipal().toString(), LoginSysUser.class);
                        // 给当前对象赋值security权限
                        List<SimpleGrantedAuthority> authorityList = loginSysUser.getPerms().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
                        // 构建一个带有权限的身份对象
                        realToken = new UsernamePasswordAuthenticationToken(loginSysUser, null, authorityList);
                        break;
                    }
                    // 用户是会员
                    case (AuthConstant.MEMBER): {
                        // 获取会员的身份票据
                        LoginMember loginMember = JSON.parseObject(authenticationToken.getPrincipal().toString(), LoginMember.class);
                        // 会员暂时妹有其他权限，仅有默认访问范围
                        realToken = new UsernamePasswordAuthenticationToken(loginMember,null,new HashSet<>());
                        break;
                    }
                }
                // 将当前对象保存到security上下文
                SecurityContextHolder.getContext().setAuthentication(realToken);
                filterChain.doFilter(request, response);
                return;
            }
        }
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("utf-8");
        // 将数据回写到前端
        Result<String> result = Result.failure(HttpStatus.UNAUTHORIZED.value(),"身份信息不合法");
        String resultStr = JSON.toJSONString(result);
        PrintWriter writer = response.getWriter();
        writer.write(resultStr);
        writer.flush();
        writer.close();
    }
}
