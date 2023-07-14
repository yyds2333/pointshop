package com.powernode.constant;

public interface ResourceConstant {
    /**
     * 资源服务器的放行路径
     */
    String[] RESOURCE_ALLOW_URLS = {
            "actuator/**",
            "druid/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/swagger-resources/configuration/ui",
            "/swagger-resources",
            "/swagger-resources/configuration/security",
            "/wevjars/**",
            "swagger-ui/**"
    };

    /**
     * 安全上下文不需要权限的路径
     */
    String[] SECURITY_ALLOW_URLS = {
            "actuator/**",
            "druid/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/swagger-resources/configuration/ui",
            "/swagger-resources",
            "/swagger-resources/configuration/security",
            "/wevjars/**",
            "swagger-ui/**"
    };
}
