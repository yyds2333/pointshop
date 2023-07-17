package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "app_connect")
public class AppConnect {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 本系统userId
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 第三方系统id 1：微信小程序
     */
    @TableField(value = "app_id")
    private Byte appId;

    /**
     * 第三方系统昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 第三方系统头像
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 第三方系统userid
     */
    @TableField(value = "biz_user_id")
    private String bizUserId;

    /**
     * 第三方系统unionid
     */
    @TableField(value = "biz_unionid")
    private String bizUnionid;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_APP_ID = "app_id";

    public static final String COL_NICK_NAME = "nick_name";

    public static final String COL_IMAGE_URL = "image_url";

    public static final String COL_BIZ_USER_ID = "biz_user_id";

    public static final String COL_BIZ_UNIONID = "biz_unionid";

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取本系统userId
     *
     * @return user_id - 本系统userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置本系统userId
     *
     * @param userId 本系统userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取第三方系统id 1：微信小程序
     *
     * @return app_id - 第三方系统id 1：微信小程序
     */
    public Byte getAppId() {
        return appId;
    }

    /**
     * 设置第三方系统id 1：微信小程序
     *
     * @param appId 第三方系统id 1：微信小程序
     */
    public void setAppId(Byte appId) {
        this.appId = appId;
    }

    /**
     * 获取第三方系统昵称
     *
     * @return nick_name - 第三方系统昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置第三方系统昵称
     *
     * @param nickName 第三方系统昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取第三方系统头像
     *
     * @return image_url - 第三方系统头像
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置第三方系统头像
     *
     * @param imageUrl 第三方系统头像
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 获取第三方系统userid
     *
     * @return biz_user_id - 第三方系统userid
     */
    public String getBizUserId() {
        return bizUserId;
    }

    /**
     * 设置第三方系统userid
     *
     * @param bizUserId 第三方系统userid
     */
    public void setBizUserId(String bizUserId) {
        this.bizUserId = bizUserId;
    }

    /**
     * 获取第三方系统unionid
     *
     * @return biz_unionid - 第三方系统unionid
     */
    public String getBizUnionid() {
        return bizUnionid;
    }

    /**
     * 设置第三方系统unionid
     *
     * @param bizUnionid 第三方系统unionid
     */
    public void setBizUnionid(String bizUnionid) {
        this.bizUnionid = bizUnionid;
    }
}