package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;

/**
    * 订单表
    */
@TableName(value = "`order`")
public class Order {
    /**
     * 订单ID
     */
    @TableId(value = "order_id", type = IdType.INPUT)
    private Long orderId;

    /**
     * 订购用户ID
     */
    @TableField(value = "open_id")
    private String openId;

    /**
     * 订购流水号
     */
    @TableField(value = "order_number")
    private String orderNumber;

    /**
     * 总值
     */
    @TableField(value = "total_money")
    private BigDecimal totalMoney;

    /**
     * 实际总值
     */
    @TableField(value = "actual_total")
    private BigDecimal actualTotal;

    /**
     * 订单备注
     */
    @TableField(value = "remarks")
    private String remarks;

    /**
     * 订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:成功 6:失败
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 配送类型
     */
    @TableField(value = "dvy_type")
    private String dvyType;

    /**
     * 配送方式ID
     */
    @TableField(value = "dvy_id")
    private Long dvyId;

    /**
     * 物流单号
     */
    @TableField(value = "dvy_flow_id")
    private String dvyFlowId;

    /**
     * 订单运费
     */
    @TableField(value = "freight_amount")
    private BigDecimal freightAmount;

    /**
     * 用户订单地址Id
     */
    @TableField(value = "addr_order_id")
    private Long addrOrderId;

    /**
     * 订单商品总数
     */
    @TableField(value = "product_nums")
    private Integer productNums;

    /**
     * 订购时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 订单更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 付款时间
     */
    @TableField(value = "pay_time")
    private Date payTime;

    /**
     * 发货时间
     */
    @TableField(value = "dvy_time")
    private Date dvyTime;

    /**
     * 完成时间
     */
    @TableField(value = "finally_time")
    private Date finallyTime;

    /**
     * 取消时间
     */
    @TableField(value = "cancel_time")
    private Date cancelTime;

    /**
     * 是否已经支付，1：已经支付过，0：，没有支付过
     */
    @TableField(value = "is_payed")
    private Boolean isPayed;

    /**
     * 用户订单删除状态，0：没有删除， 1：回收站， 2：永久删除
     */
    @TableField(value = "delete_status")
    private Integer deleteStatus;

    /**
     * 0:默认,1:在处理,2:处理完成
     */
    @TableField(value = "refund_sts")
    private Integer refundSts;

    /**
     * 优惠总额
     */
    @TableField(value = "reduce_amount")
    private BigDecimal reduceAmount;

    /**
     * 订单关闭原因 1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易
     */
    @TableField(value = "close_type")
    private Byte closeType;

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_ORDER_NUMBER = "order_number";

    public static final String COL_TOTAL_MONEY = "total_money";

    public static final String COL_ACTUAL_TOTAL = "actual_total";

    public static final String COL_REMARKS = "remarks";

    public static final String COL_STATUS = "status";

    public static final String COL_DVY_TYPE = "dvy_type";

    public static final String COL_DVY_ID = "dvy_id";

    public static final String COL_DVY_FLOW_ID = "dvy_flow_id";

    public static final String COL_FREIGHT_AMOUNT = "freight_amount";

    public static final String COL_ADDR_ORDER_ID = "addr_order_id";

    public static final String COL_PRODUCT_NUMS = "product_nums";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_PAY_TIME = "pay_time";

    public static final String COL_DVY_TIME = "dvy_time";

    public static final String COL_FINALLY_TIME = "finally_time";

    public static final String COL_CANCEL_TIME = "cancel_time";

    public static final String COL_IS_PAYED = "is_payed";

    public static final String COL_DELETE_STATUS = "delete_status";

    public static final String COL_REFUND_STS = "refund_sts";

    public static final String COL_REDUCE_AMOUNT = "reduce_amount";

    public static final String COL_CLOSE_TYPE = "close_type";

    /**
     * 获取订单ID
     *
     * @return order_id - 订单ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID
     *
     * @param orderId 订单ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取订购用户ID
     *
     * @return open_id - 订购用户ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置订购用户ID
     *
     * @param openId 订购用户ID
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取订购流水号
     *
     * @return order_number - 订购流水号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置订购流水号
     *
     * @param orderNumber 订购流水号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取总值
     *
     * @return total_money - 总值
     */
    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    /**
     * 设置总值
     *
     * @param totalMoney 总值
     */
    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * 获取实际总值
     *
     * @return actual_total - 实际总值
     */
    public BigDecimal getActualTotal() {
        return actualTotal;
    }

    /**
     * 设置实际总值
     *
     * @param actualTotal 实际总值
     */
    public void setActualTotal(BigDecimal actualTotal) {
        this.actualTotal = actualTotal;
    }

    /**
     * 获取订单备注
     *
     * @return remarks - 订单备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置订单备注
     *
     * @param remarks 订单备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:成功 6:失败
     *
     * @return status - 订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:成功 6:失败
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:成功 6:失败
     *
     * @param status 订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:成功 6:失败
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取配送类型
     *
     * @return dvy_type - 配送类型
     */
    public String getDvyType() {
        return dvyType;
    }

    /**
     * 设置配送类型
     *
     * @param dvyType 配送类型
     */
    public void setDvyType(String dvyType) {
        this.dvyType = dvyType;
    }

    /**
     * 获取配送方式ID
     *
     * @return dvy_id - 配送方式ID
     */
    public Long getDvyId() {
        return dvyId;
    }

    /**
     * 设置配送方式ID
     *
     * @param dvyId 配送方式ID
     */
    public void setDvyId(Long dvyId) {
        this.dvyId = dvyId;
    }

    /**
     * 获取物流单号
     *
     * @return dvy_flow_id - 物流单号
     */
    public String getDvyFlowId() {
        return dvyFlowId;
    }

    /**
     * 设置物流单号
     *
     * @param dvyFlowId 物流单号
     */
    public void setDvyFlowId(String dvyFlowId) {
        this.dvyFlowId = dvyFlowId;
    }

    /**
     * 获取订单运费
     *
     * @return freight_amount - 订单运费
     */
    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    /**
     * 设置订单运费
     *
     * @param freightAmount 订单运费
     */
    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    /**
     * 获取用户订单地址Id
     *
     * @return addr_order_id - 用户订单地址Id
     */
    public Long getAddrOrderId() {
        return addrOrderId;
    }

    /**
     * 设置用户订单地址Id
     *
     * @param addrOrderId 用户订单地址Id
     */
    public void setAddrOrderId(Long addrOrderId) {
        this.addrOrderId = addrOrderId;
    }

    /**
     * 获取订单商品总数
     *
     * @return product_nums - 订单商品总数
     */
    public Integer getProductNums() {
        return productNums;
    }

    /**
     * 设置订单商品总数
     *
     * @param productNums 订单商品总数
     */
    public void setProductNums(Integer productNums) {
        this.productNums = productNums;
    }

    /**
     * 获取订购时间
     *
     * @return create_time - 订购时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置订购时间
     *
     * @param createTime 订购时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取订单更新时间
     *
     * @return update_time - 订单更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置订单更新时间
     *
     * @param updateTime 订单更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取付款时间
     *
     * @return pay_time - 付款时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置付款时间
     *
     * @param payTime 付款时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取发货时间
     *
     * @return dvy_time - 发货时间
     */
    public Date getDvyTime() {
        return dvyTime;
    }

    /**
     * 设置发货时间
     *
     * @param dvyTime 发货时间
     */
    public void setDvyTime(Date dvyTime) {
        this.dvyTime = dvyTime;
    }

    /**
     * 获取完成时间
     *
     * @return finally_time - 完成时间
     */
    public Date getFinallyTime() {
        return finallyTime;
    }

    /**
     * 设置完成时间
     *
     * @param finallyTime 完成时间
     */
    public void setFinallyTime(Date finallyTime) {
        this.finallyTime = finallyTime;
    }

    /**
     * 获取取消时间
     *
     * @return cancel_time - 取消时间
     */
    public Date getCancelTime() {
        return cancelTime;
    }

    /**
     * 设置取消时间
     *
     * @param cancelTime 取消时间
     */
    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    /**
     * 获取是否已经支付，1：已经支付过，0：，没有支付过
     *
     * @return is_payed - 是否已经支付，1：已经支付过，0：，没有支付过
     */
    public Boolean getIsPayed() {
        return isPayed;
    }

    /**
     * 设置是否已经支付，1：已经支付过，0：，没有支付过
     *
     * @param isPayed 是否已经支付，1：已经支付过，0：，没有支付过
     */
    public void setIsPayed(Boolean isPayed) {
        this.isPayed = isPayed;
    }

    /**
     * 获取用户订单删除状态，0：没有删除， 1：回收站， 2：永久删除
     *
     * @return delete_status - 用户订单删除状态，0：没有删除， 1：回收站， 2：永久删除
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置用户订单删除状态，0：没有删除， 1：回收站， 2：永久删除
     *
     * @param deleteStatus 用户订单删除状态，0：没有删除， 1：回收站， 2：永久删除
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取0:默认,1:在处理,2:处理完成
     *
     * @return refund_sts - 0:默认,1:在处理,2:处理完成
     */
    public Integer getRefundSts() {
        return refundSts;
    }

    /**
     * 设置0:默认,1:在处理,2:处理完成
     *
     * @param refundSts 0:默认,1:在处理,2:处理完成
     */
    public void setRefundSts(Integer refundSts) {
        this.refundSts = refundSts;
    }

    /**
     * 获取优惠总额
     *
     * @return reduce_amount - 优惠总额
     */
    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    /**
     * 设置优惠总额
     *
     * @param reduceAmount 优惠总额
     */
    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    /**
     * 获取订单关闭原因 1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易
     *
     * @return close_type - 订单关闭原因 1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易
     */
    public Byte getCloseType() {
        return closeType;
    }

    /**
     * 设置订单关闭原因 1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易
     *
     * @param closeType 订单关闭原因 1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易
     */
    public void setCloseType(Byte closeType) {
        this.closeType = closeType;
    }
}