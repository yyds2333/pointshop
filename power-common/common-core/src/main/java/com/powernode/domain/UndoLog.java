package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName(value = "undo_log")
public class UndoLog {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField(value = "branch_id")
    private Long branchId;

    @TableField(value = "xid")
    private String xid;

    @TableField(value = "context")
    private String context;

    @TableField(value = "rollback_info")
    private byte[] rollbackInfo;

    @TableField(value = "log_status")
    private Integer logStatus;

    @TableField(value = "log_created")
    private Date logCreated;

    @TableField(value = "log_modified")
    private Date logModified;

    @TableField(value = "ext")
    private String ext;

    public static final String COL_ID = "id";

    public static final String COL_BRANCH_ID = "branch_id";

    public static final String COL_XID = "xid";

    public static final String COL_CONTEXT = "context";

    public static final String COL_ROLLBACK_INFO = "rollback_info";

    public static final String COL_LOG_STATUS = "log_status";

    public static final String COL_LOG_CREATED = "log_created";

    public static final String COL_LOG_MODIFIED = "log_modified";

    public static final String COL_EXT = "ext";

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
     * @return branch_id
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * @param branchId
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    /**
     * @return xid
     */
    public String getXid() {
        return xid;
    }

    /**
     * @param xid
     */
    public void setXid(String xid) {
        this.xid = xid;
    }

    /**
     * @return context
     */
    public String getContext() {
        return context;
    }

    /**
     * @param context
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * @return rollback_info
     */
    public byte[] getRollbackInfo() {
        return rollbackInfo;
    }

    /**
     * @param rollbackInfo
     */
    public void setRollbackInfo(byte[] rollbackInfo) {
        this.rollbackInfo = rollbackInfo;
    }

    /**
     * @return log_status
     */
    public Integer getLogStatus() {
        return logStatus;
    }

    /**
     * @param logStatus
     */
    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }

    /**
     * @return log_created
     */
    public Date getLogCreated() {
        return logCreated;
    }

    /**
     * @param logCreated
     */
    public void setLogCreated(Date logCreated) {
        this.logCreated = logCreated;
    }

    /**
     * @return log_modified
     */
    public Date getLogModified() {
        return logModified;
    }

    /**
     * @param logModified
     */
    public void setLogModified(Date logModified) {
        this.logModified = logModified;
    }

    /**
     * @return ext
     */
    public String getExt() {
        return ext;
    }

    /**
     * @param ext
     */
    public void setExt(String ext) {
        this.ext = ext;
    }
}