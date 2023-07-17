package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName(value = "message")
public class Message {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 留言创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 姓名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 联系方式
     */
    @TableField(value = "contact")
    private String contact;

    /**
     * 留言内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 留言回复
     */
    @TableField(value = "reply")
    private String reply;

    /**
     * 状态：0:未审核 1审核通过
     */
    @TableField(value = "`status`")
    private Byte status;

    public static final String COL_ID = "id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_EMAIL = "email";

    public static final String COL_CONTACT = "contact";

    public static final String COL_CONTENT = "content";

    public static final String COL_REPLY = "reply";

    public static final String COL_STATUS = "status";

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取留言创建时间
     *
     * @return create_time - 留言创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置留言创建时间
     *
     * @param createTime 留言创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取姓名
     *
     * @return user_name - 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     *
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取联系方式
     *
     * @return contact - 联系方式
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系方式
     *
     * @param contact 联系方式
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取留言内容
     *
     * @return content - 留言内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置留言内容
     *
     * @param content 留言内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取留言回复
     *
     * @return reply - 留言回复
     */
    public String getReply() {
        return reply;
    }

    /**
     * 设置留言回复
     *
     * @param reply 留言回复
     */
    public void setReply(String reply) {
        this.reply = reply;
    }

    /**
     * 获取状态：0:未审核 1审核通过
     *
     * @return status - 状态：0:未审核 1审核通过
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态：0:未审核 1审核通过
     *
     * @param status 状态：0:未审核 1审核通过
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}