package com.powernode.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RefreshScope
@Component
@ConfigurationProperties(prefix = "qiniu")
public class FileConfig {
    private String ak;
    private String sk;
    private String bucket;
    private String domain;

}
