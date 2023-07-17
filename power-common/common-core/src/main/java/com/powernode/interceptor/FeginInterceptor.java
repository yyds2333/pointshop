package com.powernode.interceptor;

import com.powernode.constant.AuthConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用于实现token在远程服务之间的传递
 * 每次调用远程服务都要执行
 */
@Component
public class FeginInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 获取上下文请求
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // 如果requestAttributes为空则代表自己直接调用
        if (!ObjectUtils.isEmpty(requestAttributes)){
            HttpServletRequest request = requestAttributes.getRequest();

            String token = request.getHeader(AuthConstant.AUTHORIZATION);
            String loginType = request.getHeader(AuthConstant.LOGIN_TYPE);
            if (StringUtils.hasText(token)&& StringUtils.hasText(loginType)){
                requestTemplate.header(AuthConstant.AUTHORIZATION,token);
                requestTemplate.header(AuthConstant.LOGIN_TYPE,loginType);
            }
        }
    }
}
