package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName(value = "global_table")
public class GlobalTable {
    /**
     * 全局事务ID
     */
    @TableId(value = "xid", type = IdType.INPUT)
    private String xid;

    /**
     * 事务ID
     */
    @TableField(value = "transaction_id")
    private Long transactionId;

    /**
     * 状态
     */
    @TableField(value = "`status`")
    private Byte status;

    /**
     * 应用ID
     */
    @TableField(value = "application_id")
    private String applicationId;

    /**
     * 事务分组名
     */
    @TableField(value = "transaction_service_group")
    private String transactionServiceGroup;

    /**
     * 执行事务的方法
     */
    @TableField(value = "transaction_name")
    private String transactionName;

    /**
     * 超时时间
     */
    @TableField(value = "timeout")
    private Integer timeout;

    /**
     * 开始时间
     */
    @TableField(value = "begin_time")
    private Long beginTime;

    /**
     * 应用数据
     */
    @TableField(value = "application_data")
    private String applicationData;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    public static final String COL_XID = "xid";

    public static final String COL_TRANSACTION_ID = "transaction_id";

    public static final String COL_STATUS = "status";

    public static final String COL_APPLICATION_ID = "application_id";

    public static final String COL_TRANSACTION_SERVICE_GROUP = "transaction_service_group";

    public static final String COL_TRANSACTION_NAME = "transaction_name";

    public static final String COL_TIMEOUT = "timeout";

    public static final String COL_BEGIN_TIME = "begin_time";

    public static final String COL_APPLICATION_DATA = "application_data";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_GMT_MODIFIED = "gmt_modified";

    /**
     * 获取全局事务ID
     *
     * @return xid - 全局事务ID
     */
    public String getXid() {
        return xid;
    }

    /**
     * 设置全局事务ID
     *
     * @param xid 全局事务ID
     */
    public void setXid(String xid) {
        this.xid = xid;
    }

    /**
     * 获取事务ID
     *
     * @return transaction_id - 事务ID
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * 设置事务ID
     *
     * @param transactionId 事务ID
     */
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取应用ID
     *
     * @return application_id - 应用ID
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * 设置应用ID
     *
     * @param applicationId 应用ID
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取事务分组名
     *
     * @return transaction_service_group - 事务分组名
     */
    public String getTransactionServiceGroup() {
        return transactionServiceGroup;
    }

    /**
     * 设置事务分组名
     *
     * @param transactionServiceGroup 事务分组名
     */
    public void setTransactionServiceGroup(String transactionServiceGroup) {
        this.transactionServiceGroup = transactionServiceGroup;
    }

    /**
     * 获取执行事务的方法
     *
     * @return transaction_name - 执行事务的方法
     */
    public String getTransactionName() {
        return transactionName;
    }

    /**
     * 设置执行事务的方法
     *
     * @param transactionName 执行事务的方法
     */
    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    /**
     * 获取超时时间
     *
     * @return timeout - 超时时间
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * 设置超时时间
     *
     * @param timeout 超时时间
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    /**
     * 获取开始时间
     *
     * @return begin_time - 开始时间
     */
    public Long getBeginTime() {
        return beginTime;
    }

    /**
     * 设置开始时间
     *
     * @param beginTime 开始时间
     */
    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取应用数据
     *
     * @return application_data - 应用数据
     */
    public String getApplicationData() {
        return applicationData;
    }

    /**
     * 设置应用数据
     *
     * @param applicationData 应用数据
     */
    public void setApplicationData(String applicationData) {
        this.applicationData = applicationData;
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取修改时间
     *
     * @return gmt_modified - 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}