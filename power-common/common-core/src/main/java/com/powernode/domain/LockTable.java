package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "lock_table")
public class LockTable  implements Serializable {
    /**
     * 行键
     */
    @TableId(value = "row_key", type = IdType.INPUT)
    private String rowKey;

    /**
     * 全局事务ID
     */
    @TableField(value = "xid")
    private String xid;

    /**
     * 全局事务ID，不带TC 地址
     */
    @TableField(value = "transaction_id")
    private Long transactionId;

    /**
     * 分支ID
     */
    @TableField(value = "branch_id")
    private Long branchId;

    /**
     * 资源ID
     */
    @TableField(value = "resource_id")
    private String resourceId;

    /**
     * 表名
     */
    @TableField(value = "`table_name`")
    private String tableName;

    /**
     * 主键对应的值
     */
    @TableField(value = "pk")
    private String pk;

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

    public static final String COL_ROW_KEY = "row_key";

    public static final String COL_XID = "xid";

    public static final String COL_TRANSACTION_ID = "transaction_id";

    public static final String COL_BRANCH_ID = "branch_id";

    public static final String COL_RESOURCE_ID = "resource_id";

    public static final String COL_TABLE_NAME = "table_name";

    public static final String COL_PK = "pk";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_GMT_MODIFIED = "gmt_modified";

    /**
     * 获取行键
     *
     * @return row_key - 行键
     */
    public String getRowKey() {
        return rowKey;
    }

    /**
     * 设置行键
     *
     * @param rowKey 行键
     */
    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
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
     * 获取全局事务ID，不带TC 地址
     *
     * @return transaction_id - 全局事务ID，不带TC 地址
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * 设置全局事务ID，不带TC 地址
     *
     * @param transactionId 全局事务ID，不带TC 地址
     */
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 获取分支ID
     *
     * @return branch_id - 分支ID
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置分支ID
     *
     * @param branchId 分支ID
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
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
     * 获取表名
     *
     * @return table_name - 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置表名
     *
     * @param tableName 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 获取主键对应的值
     *
     * @return pk - 主键对应的值
     */
    public String getPk() {
        return pk;
    }

    /**
     * 设置主键对应的值
     *
     * @param pk 主键对应的值
     */
    public void setPk(String pk) {
        this.pk = pk;
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