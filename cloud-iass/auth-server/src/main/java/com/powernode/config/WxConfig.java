package com.powernode.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RefreshScope
@Component
@ConfigurationProperties(prefix = "wx.auth")
public class WxConfig {

    private String appId;
    private String appSecret;

    private String wxTokenUrl;
}
