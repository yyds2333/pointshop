package com.powernode.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powernode.constant.AuthConstant;
import com.powernode.model.LoginSuccess;
import com.powernode.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * Spring Security 5.7 之前使用的配置方法
 */
//@Configuration
public class OldWebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserDetailsService userDetailsService;

    // 定义用户的身份验证 ，完成登陆实现
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用跨域访问限制
        http.csrf().disable();

        // 配置登录处理的url
        http.formLogin().loginProcessingUrl(AuthConstant.LOGIN_URL)
                // 登陆成功处理器
                .successHandler(authenticationSuccessHandler())
                // 登录失败处理器
                .failureHandler(authenticationFailureHandler())
        ;

        // 配置注销
        http.logout().logoutUrl(AuthConstant.LOGOUT_URL)
                .logoutSuccessHandler(logoutSuccessHandler());

        // 每个请求都经过 身份验证
        http.authorizeHttpRequests()
                .anyRequest() // 任何请求都拦截
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("使用老式Security继承");
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        return daoAuthenticationProvider;
    }



    // 登陆成功，生成 token 并返回到前端
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return ((request, response, authentication) -> {
            Result<String> result = Result.success();
            // 生成token 可以使用 JWT 生成
            String token = UUID.randomUUID().toString();
            // 将登陆的身份对象转换为JSON字符串
            String userStr = new ObjectMapper().writeValueAsString(authentication);
            // 将身份写入Redis ，Login_token:UUID 2小时过期时间
            stringRedisTemplate.opsForValue()
                    .set(AuthConstant.LOGIN_TOKEN_PREFIX + token,userStr,
                            AuthConstant.TOKEN_EXPIRES_IN_TIME,
                            TimeUnit.SECONDS);
            // 将登陆成功信息封装到 LoginSuccess
            LoginSuccess loginSuccess = new LoginSuccess();
            loginSuccess.setAccessToken(token);
            loginSuccess.setExpiresIn((AuthConstant.TOKEN_EXPIRES_IN_TIME).toString());
            loginSuccess.setType(AuthConstant.BEARER);
            // 将LoginSuccess封装并返回给前端
            sendResponse(response,loginSuccess);
        });
    }


    // 登录失败  往容器中注册 AuthenticationFailureHandler 并实现这个函数式接口
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return ((request, response, exception) -> {
            Result<String> result = new Result<>();
            result.setCode(HttpStatus.UNAUTHORIZED.value());
            // 设置响应 格式 和 编码
            if (exception instanceof LockedException) {
                result.setMsg("账户被锁定");
            } else if (exception instanceof BadCredentialsException) {
                result.setMsg("密码错误");
            } else {
                result.setMsg("账户或密码错误");
            }
            // 响应数据到前端
            sendResponse(response,result);
        });
    }

    // 注销，清除Redis中的身份信息
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (((request, response, authentication) -> {
            // 获取token
            String authorization = request.getHeader(AuthConstant.AUTHORIZATION);
            // 获取真实token
            String realToken = authorization.replaceFirst(AuthConstant.BEARER, "");
            // 删除Redis中的token
            Boolean delete = stringRedisTemplate.delete(AuthConstant.LOGIN_TOKEN_PREFIX + realToken);
            Result<String> result = Result.success("成功登出", null);
            // 回显给前端
            sendResponse(response,result);
        }));
    }

    // 密码对称加密
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 将data发送给前端
     * @param response
     * @param data
     */
    private <T> void sendResponse(HttpServletResponse response, T data){
        ObjectMapper objectMapper = new ObjectMapper();
        // 设置响应 类型 编码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = null;
        // 写出数据
        try{
            writer = response.getWriter();
            String string = objectMapper.writeValueAsString(data);
            writer.write(string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
}
