package com.powernode.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@RefreshScope
public class ESConfig {
    /**
     * 一次导入的量
     */
    @Value("${esimport.size}")
    private Integer size;
}
