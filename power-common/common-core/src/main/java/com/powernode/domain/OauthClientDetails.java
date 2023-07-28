package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
    * 终端信息表
    */
@TableName(value = "oauth_client_details")
public class OauthClientDetails  implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "client_id", type = IdType.AUTO)
    private String clientId;

    @TableField(value = "client_secret")
    private String clientSecret;

    @TableField(value = "resource_ids")
    private String resourceIds;

    @TableField(value = "`scope`")
    private String scope;

    @TableField(value = "authorized_grant_types")
    private String authorizedGrantTypes;

    @TableField(value = "web_server_redirect_uri")
    private String webServerRedirectUri;

    @TableField(value = "authorities")
    private String authorities;

    @TableField(value = "access_token_validity")
    private Integer accessTokenValidity;

    @TableField(value = "refresh_token_validity")
    private Integer refreshTokenValidity;

    @TableField(value = "additional_information")
    private String additionalInformation;

    @TableField(value = "autoapprove")
    private String autoapprove;

    public static final String COL_CLIENT_ID = "client_id";

    public static final String COL_CLIENT_SECRET = "client_secret";

    public static final String COL_RESOURCE_IDS = "resource_ids";

    public static final String COL_SCOPE = "scope";

    public static final String COL_AUTHORIZED_GRANT_TYPES = "authorized_grant_types";

    public static final String COL_WEB_SERVER_REDIRECT_URI = "web_server_redirect_uri";

    public static final String COL_AUTHORITIES = "authorities";

    public static final String COL_ACCESS_TOKEN_VALIDITY = "access_token_validity";

    public static final String COL_REFRESH_TOKEN_VALIDITY = "refresh_token_validity";

    public static final String COL_ADDITIONAL_INFORMATION = "additional_information";

    public static final String COL_AUTOAPPROVE = "autoapprove";

    /**
     * @return client_id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return client_secret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * @param clientSecret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * @return resource_ids
     */
    public String getResourceIds() {
        return resourceIds;
    }

    /**
     * @param resourceIds
     */
    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    /**
     * @return scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * @return authorized_grant_types
     */
    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    /**
     * @param authorizedGrantTypes
     */
    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    /**
     * @return web_server_redirect_uri
     */
    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    /**
     * @param webServerRedirectUri
     */
    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    /**
     * @return authorities
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * @param authorities
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    /**
     * @return access_token_validity
     */
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    /**
     * @param accessTokenValidity
     */
    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    /**
     * @return refresh_token_validity
     */
    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    /**
     * @param refreshTokenValidity
     */
    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    /**
     * @return additional_information
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * @param additionalInformation
     */
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    /**
     * @return autoapprove
     */
    public String getAutoapprove() {
        return autoapprove;
    }

    /**
     * @param autoapprove
     */
    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }
}