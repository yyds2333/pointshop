package com.powernode.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

// 阿里云短信接口
@Data
@AllArgsConstructor
@NoArgsConstructor
@RefreshScope
@ConfigurationProperties(prefix = "ali.sms") // 从配置文件读取配置信息
public class AliSmsProperties {
    // 阿里云短信接口
    private String accessKeyId;

    private String accessKeySecret;

    private String domain;


}
