package com.powernode;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //排除数据源自动启动
@EnableDiscoveryClient
public class SearchServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApp.class);
    }
}
