package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName(value = "branch_table")
public class BranchTable {
    /**
     * 分支事务ID
     */
    @TableId(value = "branch_id", type = IdType.INPUT)
    private Long branchId;

    /**
     * 全局事务ID
     */
    @TableField(value = "xid")
    private String xid;

    /**
     * 全局事务ID，不带TC地址
     */
    @TableField(value = "transaction_id")
    private Long transactionId;

    /**
     * 资源分组ID
     */
    @TableField(value = "resource_group_id")
    private String resourceGroupId;

    /**
     * 资源ID
     */
    @TableField(value = "resource_id")
    private String resourceId;

    /**
     * 事务模式，AT、XA等
     */
    @TableField(value = "branch_type")
    private String branchType;

    /**
     * 状态
     */
    @TableField(value = "`status`")
    private Byte status;

    /**
     * 客户端ID
     */
    @TableField(value = "client_id")
    private String clientId;

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

    public static final String COL_BRANCH_ID = "branch_id";

    public static final String COL_XID = "xid";

    public static final String COL_TRANSACTION_ID = "transaction_id";

    public static final String COL_RESOURCE_GROUP_ID = "resource_group_id";

    public static final String COL_RESOURCE_ID = "resource_id";

    public static final String COL_BRANCH_TYPE = "branch_type";

    public static final String COL_STATUS = "status";

    public static final String COL_CLIENT_ID = "client_id";

    public static final String COL_APPLICATION_DATA = "application_data";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_GMT_MODIFIED = "gmt_modified";

    /**
     * 获取分支事务ID
     *
     * @return branch_id - 分支事务ID
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置分支事务ID
     *
     * @param branchId 分支事务ID
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

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
     * 获取全局事务ID，不带TC地址
     *
     * @return transaction_id - 全局事务ID，不带TC地址
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * 设置全局事务ID，不带TC地址
     *
     * @param transactionId 全局事务ID，不带TC地址
     */
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 获取资源分组ID
     *
     * @return resource_group_id - 资源分组ID
     */
    public String getResourceGroupId() {
        return resourceGroupId;
    }

    /**
     * 设置资源分组ID
     *
     * @param resourceGroupId 资源分组ID
     */
    public void setResourceGroupId(String resourceGroupId) {
        this.resourceGroupId = resourceGroupId;
    }

    /**
     * 获取资源ID
     *
     * @return resource_id - 资源ID
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * 设置资源ID
     *
     * @param resourceId 资源ID
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取事务模式，AT、XA等
     *
     * @return branch_type - 事务模式，AT、XA等
     */
    public String getBranchType() {
        return branchType;
    }

    /**
     * 设置事务模式，AT、XA等
     *
     * @param branchType 事务模式，AT、XA等
     */
    public void setBranchType(String branchType) {
        this.branchType = branchType;
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
     * 获取客户端ID
     *
     * @return client_id - 客户端ID
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置客户端ID
     *
     * @param clientId 客户端ID
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
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