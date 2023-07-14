package com.powernode.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 公共包中启动扫描所有mapper
@MapperScan("com.powernode.mapper")
public class MyBatisPlusConfig {
}
