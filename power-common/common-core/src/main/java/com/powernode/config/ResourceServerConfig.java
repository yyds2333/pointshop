package com.powernode.config;

import com.powernode.constant.ResourceConstant;
import com.powernode.filter.TokenTransFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// 开启方法级别权限注解
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig {


    @Autowired
    private TokenTransFilter tokenTransFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        // 添加token解析过滤 在security身份拦截之前 执行
        http.addFilterBefore(tokenTransFilter, UsernamePasswordAuthenticationFilter.class);

        // 处理 访问被拒绝 的程序
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());

        // 配置权限拦截
        http.authorizeHttpRequests().antMatchers(ResourceConstant.SECURITY_ALLOW_URLS) // 过滤掉非拦截名单
                .permitAll()
                .anyRequest()
                .authenticated();
        return http.build();
    }

    // 身份拒绝 的 处理
    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        // 相应给前台
        return (((request, response, accessDeniedException) -> {

        }));
    }
}
