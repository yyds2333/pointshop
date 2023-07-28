package com.powernode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient // 开启服务发现
@EnableCaching // 开启缓存
@EnableFeignClients // 开启Feign
public class MemberServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(MemberServiceApp.class);
    }
}
