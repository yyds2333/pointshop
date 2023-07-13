package com.powernode.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 网关对每一个进入的请求都必须携带 token，网关对token校验 后端
 * 不携带 token 则拦截
 * 携带  token 就放行
 */
@Component
public class TokenCheckFilter implements GlobalFilter, Ordered {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求对象

        // 获取请求路径

        // 判断url是否是登录url,如果是登录请求，则直接放行，无需过滤

        // 获取请求头中的token

        // 获取token，去掉附属的标识，获取真正的token值

        // 用户携带了token，且在redis中没有过期，则放行

        // 用户没有携带token、不合法、过期等 则拦截请求

        // 设置响应输出类型 --json
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

        // 自定义输出结果
        ObjectMapper objectMapper = new ObjectMapper();



        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
