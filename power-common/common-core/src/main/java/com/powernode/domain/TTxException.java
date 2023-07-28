package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "t_tx_exception")
public class TTxException implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "ex_state")
    private Short exState;

    @TableField(value = "group_id")
    private String groupId;

    @TableField(value = "mod_id")
    private String modId;

    @TableField(value = "registrar")
    private Short registrar;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "transaction_state")
    private Integer transactionState;

    @TableField(value = "unit_id")
    private String unitId;

    public static final String COL_ID = "id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_EX_STATE = "ex_state";

    public static final String COL_GROUP_ID = "group_id";

    public static final String COL_MOD_ID = "mod_id";

    public static final String COL_REGISTRAR = "registrar";

    public static final String COL_REMARK = "remark";

    public static final String COL_TRANSACTION_STATE = "transaction_state";

    public static final String COL_UNIT_ID = "unit_id";

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
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return ex_state
     */
    public Short getExState() {
        return exState;
    }

    /**
     * @param exState
     */
    public void setExState(Short exState) {
        this.exState = exState;
    }

    /**
     * @return group_id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * @return mod_id
     */
    public String getModId() {
        return modId;
    }

    /**
     * @param modId
     */
    public void setModId(String modId) {
        this.modId = modId;
    }

    /**
     * @return registrar
     */
    public Short getRegistrar() {
        return registrar;
    }

    /**
     * @param registrar
     */
    public void setRegistrar(Short registrar) {
        this.registrar = registrar;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return transaction_state
     */
    public Integer getTransactionState() {
        return transactionState;
    }

    /**
     * @param transactionState
     */
    public void setTransactionState(Integer transactionState) {
        this.transactionState = transactionState;
    }

    /**
     * @return unit_id
     */
    public String getUnitId() {
        return unitId;
    }

    /**
     * @param unitId
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
}