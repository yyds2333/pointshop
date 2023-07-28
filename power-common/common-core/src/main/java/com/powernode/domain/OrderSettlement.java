package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName(value = "order_settlement")
public class OrderSettlement  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 支付结算单据ID
     */
    @TableId(value = "settlement_id", type = IdType.AUTO)
    private Long settlementId;

    /**
     * 外部订单流水号
     */
    @TableField(value = "biz_pay_no")
    private String bizPayNo;

    /**
     * order表中的订单号
     */
    @TableField(value = "order_number")
    private String orderNumber;

    /**
     * 支付方式 1 微信支付 2 支付宝
     */
    @TableField(value = "pay_type")
    private Integer payType;

    /**
     * 支付金额
     */
    @TableField(value = "pay_amount")
    private BigDecimal payAmount;

    /**
     * 是否清算 0:否 1:是
     */
    @TableField(value = "is_clearing")
    private Integer isClearing;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 清算时间
     */
    @TableField(value = "clearing_time")
    private Date clearingTime;

    /**
     * 版本号
     */
    @TableField(value = "version")
    private Integer version;

    /**
     * 支付状态
     */
    @TableField(value = "pay_status")
    private Integer payStatus;

    public static final String COL_SETTLEMENT_ID = "settlement_id";

    public static final String COL_BIZ_PAY_NO = "biz_pay_no";

    public static final String COL_ORDER_NUMBER = "order_number";

    public static final String COL_PAY_TYPE = "pay_type";

    public static final String COL_PAY_AMOUNT = "pay_amount";

    public static final String COL_IS_CLEARING = "is_clearing";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_CLEARING_TIME = "clearing_time";

    public static final String COL_VERSION = "version";

    public static final String COL_PAY_STATUS = "pay_status";

    /**
     * 获取支付结算单据ID
     *
     * @return settlement_id - 支付结算单据ID
     */
    public Long getSettlementId() {
        return settlementId;
    }

    /**
     * 设置支付结算单据ID
     *
     * @param settlementId 支付结算单据ID
     */
    public void setSettlementId(Long settlementId) {
        this.settlementId = settlementId;
    }

    /**
     * 获取外部订单流水号
     *
     * @return biz_pay_no - 外部订单流水号
     */
    public String getBizPayNo() {
        return bizPayNo;
    }

    /**
     * 设置外部订单流水号
     *
     * @param bizPayNo 外部订单流水号
     */
    public void setBizPayNo(String bizPayNo) {
        this.bizPayNo = bizPayNo;
    }

    /**
     * 获取order表中的订单号
     *
     * @return order_number - order表中的订单号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置order表中的订单号
     *
     * @param orderNumber order表中的订单号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取支付方式 1 微信支付 2 支付宝
     *
     * @return pay_type - 支付方式 1 微信支付 2 支付宝
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置支付方式 1 微信支付 2 支付宝
     *
     * @param payType 支付方式 1 微信支付 2 支付宝
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取支付金额
     *
     * @return pay_amount - 支付金额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * 设置支付金额
     *
     * @param payAmount 支付金额
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取是否清算 0:否 1:是
     *
     * @return is_clearing - 是否清算 0:否 1:是
     */
    public Integer getIsClearing() {
        return isClearing;
    }

    /**
     * 设置是否清算 0:否 1:是
     *
     * @param isClearing 是否清算 0:否 1:是
     */
    public void setIsClearing(Integer isClearing) {
        this.isClearing = isClearing;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取清算时间
     *
     * @return clearing_time - 清算时间
     */
    public Date getClearingTime() {
        return clearingTime;
    }

    /**
     * 设置清算时间
     *
     * @param clearingTime 清算时间
     */
    public void setClearingTime(Date clearingTime) {
        this.clearingTime = clearingTime;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取支付状态
     *
     * @return pay_status - 支付状态
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 设置支付状态
     *
     * @param payStatus 支付状态
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
}