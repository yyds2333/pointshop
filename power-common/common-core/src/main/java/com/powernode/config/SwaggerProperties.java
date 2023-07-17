package com.powernode.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@AllArgsConstructor
@NoArgsConstructor
@Data
// 与Value注解一样，获取配哦之文件中的数据
@ConfigurationProperties(prefix = "swagger")
// 用来实现Bean中属性的热更新，热处理
@RefreshScope
public class SwaggerProperties {
    private String version;
    private String title;
    private String description;
    private String termsOfServiceUrl;
    private String license;
    private String licenseUrl;
    private String name;
    private String url;
    private String email;
    private String basePackage;
}
