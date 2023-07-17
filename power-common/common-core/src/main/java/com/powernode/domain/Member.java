package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
    * 用户表
    */
@TableName(value = "`member`")
public class Member {
    /**
     * 会员表的主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * ID
     */
    @TableField(value = "open_id")
    private String openId;

    /**
     * 用户昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 真实姓名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 用户邮箱
     */
    @TableField(value = "user_mail")
    private String userMail;

    /**
     * 支付密码
     */
    @TableField(value = "pay_password")
    private String payPassword;

    /**
     * 手机号码
     */
    @TableField(value = "user_mobile")
    private String userMobile;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 注册时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 注册IP
     */
    @TableField(value = "user_regip")
    private String userRegip;

    /**
     * 最后登录时间
     */
    @TableField(value = "user_lasttime")
    private Date userLasttime;

    /**
     * 最后登录IP
     */
    @TableField(value = "user_lastip")
    private String userLastip;

    /**
     * M(男) or F(女)
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 例如：2009-11-27
     */
    @TableField(value = "birth_date")
    private String birthDate;

    /**
     * 头像图片路径
     */
    @TableField(value = "pic")
    private String pic;

    /**
     * 状态 1 正常 0 无效
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 用户积分
     */
    @TableField(value = "score")
    private Integer score;

    public static final String COL_ID = "id";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_NICK_NAME = "nick_name";

    public static final String COL_REAL_NAME = "real_name";

    public static final String COL_USER_MAIL = "user_mail";

    public static final String COL_PAY_PASSWORD = "pay_password";

    public static final String COL_USER_MOBILE = "user_mobile";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_USER_REGIP = "user_regip";

    public static final String COL_USER_LASTTIME = "user_lasttime";

    public static final String COL_USER_LASTIP = "user_lastip";

    public static final String COL_SEX = "sex";

    public static final String COL_BIRTH_DATE = "birth_date";

    public static final String COL_PIC = "pic";

    public static final String COL_STATUS = "status";

    public static final String COL_SCORE = "score";

    /**
     * 获取会员表的主键
     *
     * @return id - 会员表的主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置会员表的主键
     *
     * @param id 会员表的主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取ID
     *
     * @return open_id - ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置ID
     *
     * @param openId ID
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取用户邮箱
     *
     * @return user_mail - 用户邮箱
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * 设置用户邮箱
     *
     * @param userMail 用户邮箱
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    /**
     * 获取支付密码
     *
     * @return pay_password - 支付密码
     */
    public String getPayPassword() {
        return payPassword;
    }

    /**
     * 设置支付密码
     *
     * @param payPassword 支付密码
     */
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    /**
     * 获取手机号码
     *
     * @return user_mobile - 手机号码
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 设置手机号码
     *
     * @param userMobile 手机号码
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取注册时间
     *
     * @return create_time - 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置注册时间
     *
     * @param createTime 注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取注册IP
     *
     * @return user_regip - 注册IP
     */
    public String getUserRegip() {
        return userRegip;
    }

    /**
     * 设置注册IP
     *
     * @param userRegip 注册IP
     */
    public void setUserRegip(String userRegip) {
        this.userRegip = userRegip;
    }

    /**
     * 获取最后登录时间
     *
     * @return user_lasttime - 最后登录时间
     */
    public Date getUserLasttime() {
        return userLasttime;
    }

    /**
     * 设置最后登录时间
     *
     * @param userLasttime 最后登录时间
     */
    public void setUserLasttime(Date userLasttime) {
        this.userLasttime = userLasttime;
    }

    /**
     * 获取最后登录IP
     *
     * @return user_lastip - 最后登录IP
     */
    public String getUserLastip() {
        return userLastip;
    }

    /**
     * 设置最后登录IP
     *
     * @param userLastip 最后登录IP
     */
    public void setUserLastip(String userLastip) {
        this.userLastip = userLastip;
    }

    /**
     * 获取M(男) or F(女)
     *
     * @return sex - M(男) or F(女)
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置M(男) or F(女)
     *
     * @param sex M(男) or F(女)
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取例如：2009-11-27
     *
     * @return birth_date - 例如：2009-11-27
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * 设置例如：2009-11-27
     *
     * @param birthDate 例如：2009-11-27
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 获取头像图片路径
     *
     * @return pic - 头像图片路径
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置头像图片路径
     *
     * @param pic 头像图片路径
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 获取状态 1 正常 0 无效
     *
     * @return status - 状态 1 正常 0 无效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 1 正常 0 无效
     *
     * @param status 状态 1 正常 0 无效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取用户积分
     *
     * @return score - 用户积分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置用户积分
     *
     * @param score 用户积分
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}