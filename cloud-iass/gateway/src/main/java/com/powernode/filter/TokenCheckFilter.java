package com.powernode.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powernode.constant.AuthConstant;
import com.powernode.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferWrapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

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
        ServerHttpRequest request = exchange.getRequest();
        // 获取请求路径
        URI uri = request.getURI();
        String url = uri.getPath();
        // 判断url是否是登录url,如果是登录请求，则直接放行，无需过滤
        if (AuthConstant.WHITE_URL.contains(url)){
            return chain.filter(exchange);
        }
        // 获取请求头中的token
        List<String> authorization = request.getHeaders().get("token");
        // 判断token是否存在
        if (!CollectionUtils.isEmpty(authorization)){
            // 获取token，去掉附属的标识，去掉Bear  获取真正的token值
            String authToken = authorization.get(0);
            // 用户携带了token，且在redis中没有过期，则放行
            System.out.println("authToken的值为" + authToken);
            if (StringUtils.hasText(authToken)){
                // 获取真实token
                String realToken = authToken.replaceFirst(AuthConstant.BEARER, "");
                System.out.println("realToken的值为" + realToken);
                if (StringUtils.hasText(realToken)){
                    String token = AuthConstant.LOGIN_TOKEN_PREFIX + realToken;
                    System.out.println(stringRedisTemplate.hasKey(AuthConstant.LOGIN_TOKEN_PREFIX + realToken));
                    if (stringRedisTemplate.hasKey(AuthConstant.LOGIN_TOKEN_PREFIX + realToken)){
                        // 携带了合法的token，可以放行
                        return chain.filter(exchange);
                    }
                }
            }
        }
        // 用户没有携带token、不合法、过期等 则拦截请求

        // 设置响应输出类型 --json
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

        // 自定义输出结果
        ObjectMapper objectMapper = new ObjectMapper();
        Result<Object> result = Result.failure(HttpStatus.UNAUTHORIZED.value(),"没有携带正确的token");

        byte[] bytes = new byte[0];
        try {
            bytes = objectMapper.writeValueAsBytes(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // 将输出流包装为 DataBuffer
        DataBuffer db = response.bufferFactory().wrap(bytes);
        // 输出到流中
        return response.writeWith(Mono.just(db));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
