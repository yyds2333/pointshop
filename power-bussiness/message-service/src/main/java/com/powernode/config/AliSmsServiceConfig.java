package com.powernode.config;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AliSmsProperties.class)
public class AliSmsServiceConfig {

    @Autowired
    private AliSmsProperties aliSmsProperties;

    /**
     * 用于将一个包含阿里云短信服务的组件注册到spring容器中
     * @return
     * @throws Exception
     */
    @Bean
    public Client creatClient() throws Exception {
        Config config = new Config().setAccessKeyId(aliSmsProperties.getAccessKeyId())
                .setAccessKeySecret(aliSmsProperties.getAccessKeySecret());

        config.endpoint = aliSmsProperties.getDomain();

        return new Client(config);
    }


}
