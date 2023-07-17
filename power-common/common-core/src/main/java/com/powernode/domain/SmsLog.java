package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
    * 短信记录表
    */
@TableName(value = "sms_log")
public class SmsLog {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "open_id")
    private String openId;

    /**
     * 手机号码
     */
    @TableField(value = "user_phone")
    private String userPhone;

    /**
     * 短信模板
     */
    @TableField(value = "template_id")
    private String templateId;

    /**
     * 手机验证码
     */
    @TableField(value = "mobile_code")
    private String mobileCode;

    /**
     * 发送时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 发送短信返回码
     */
    @TableField(value = "response_code")
    private String responseCode;

    /**
     * 状态  1:有效  0：失效
     */
    @TableField(value = "`status`")
    private Integer status;

    public static final String COL_ID = "id";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_USER_PHONE = "user_phone";

    public static final String COL_TEMPLATE_ID = "template_id";

    public static final String COL_MOBILE_CODE = "mobile_code";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_RESPONSE_CODE = "response_code";

    public static final String COL_STATUS = "status";

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return open_id - 用户id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置用户id
     *
     * @param openId 用户id
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取手机号码
     *
     * @return user_phone - 手机号码
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置手机号码
     *
     * @param userPhone 手机号码
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取短信模板
     *
     * @return template_id - 短信模板
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 设置短信模板
     *
     * @param templateId 短信模板
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取手机验证码
     *
     * @return mobile_code - 手机验证码
     */
    public String getMobileCode() {
        return mobileCode;
    }

    /**
     * 设置手机验证码
     *
     * @param mobileCode 手机验证码
     */
    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }

    /**
     * 获取发送时间
     *
     * @return create_time - 发送时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发送时间
     *
     * @param createTime 发送时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取发送短信返回码
     *
     * @return response_code - 发送短信返回码
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * 设置发送短信返回码
     *
     * @param responseCode 发送短信返回码
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * 获取状态  1:有效  0：失效
     *
     * @return status - 状态  1:有效  0：失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态  1:有效  0：失效
     *
     * @param status 状态  1:有效  0：失效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}