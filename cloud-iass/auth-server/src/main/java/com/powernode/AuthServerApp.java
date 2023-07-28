package com.powernode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.powernode.mapper")
public class AuthServerApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApp.class);
    }

    // 小程序通过该方法发送登录请求获取openId
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
