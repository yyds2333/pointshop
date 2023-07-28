package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName(value = "order_refund")
public class OrderRefund  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 记录ID
     */
    @TableId(value = "refund_id", type = IdType.AUTO)
    private Long refundId;

    /**
     * 店铺ID
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 订单流水号
     */
    @TableField(value = "order_number")
    private String orderNumber;

    /**
     * 订单总金额
     */
    @TableField(value = "order_amount")
    private Double orderAmount;

    /**
     * 订单项ID 全部退款是0
     */
    @TableField(value = "order_item_id")
    private Long orderItemId;

    /**
     * 退款编号
     */
    @TableField(value = "refund_sn")
    private String refundSn;

    /**
     * 订单支付流水号
     */
    @TableField(value = "flow_trade_no")
    private String flowTradeNo;

    /**
     * 第三方退款单号(微信退款单号)
     */
    @TableField(value = "out_refund_no")
    private String outRefundNo;

    /**
     * 订单支付方式 1 微信支付 2 支付宝
     */
    @TableField(value = "pay_type")
    private Integer payType;

    /**
     * 订单支付名称
     */
    @TableField(value = "pay_type_name")
    private String payTypeName;

    /**
     * 买家ID
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 退货数量
     */
    @TableField(value = "goods_num")
    private Integer goodsNum;

    /**
     * 退款金额
     */
    @TableField(value = "refund_amount")
    private BigDecimal refundAmount;

    /**
     * 申请类型:1,仅退款,2退款退货
     */
    @TableField(value = "apply_type")
    private Integer applyType;

    /**
     * 处理状态:1为待审核,2为同意,3为不同意
     */
    @TableField(value = "refund_sts")
    private Integer refundSts;

    /**
     * 处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败
     */
    @TableField(value = "return_money_sts")
    private Integer returnMoneySts;

    /**
     * 申请时间
     */
    @TableField(value = "apply_time")
    private Date applyTime;

    /**
     * 卖家处理时间
     */
    @TableField(value = "handel_time")
    private Date handelTime;

    /**
     * 退款时间
     */
    @TableField(value = "refund_time")
    private Date refundTime;

    /**
     * 文件凭证json
     */
    @TableField(value = "photo_files")
    private String photoFiles;

    /**
     * 申请原因
     */
    @TableField(value = "buyer_msg")
    private String buyerMsg;

    /**
     * 卖家备注
     */
    @TableField(value = "seller_msg")
    private String sellerMsg;

    /**
     * 物流公司名称
     */
    @TableField(value = "express_name")
    private String expressName;

    /**
     * 物流单号
     */
    @TableField(value = "express_no")
    private String expressNo;

    /**
     * 发货时间
     */
    @TableField(value = "ship_time")
    private Date shipTime;

    /**
     * 收货时间
     */
    @TableField(value = "receive_time")
    private Date receiveTime;

    /**
     * 收货备注
     */
    @TableField(value = "receive_message")
    private String receiveMessage;

    public static final String COL_REFUND_ID = "refund_id";

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_ORDER_NUMBER = "order_number";

    public static final String COL_ORDER_AMOUNT = "order_amount";

    public static final String COL_ORDER_ITEM_ID = "order_item_id";

    public static final String COL_REFUND_SN = "refund_sn";

    public static final String COL_FLOW_TRADE_NO = "flow_trade_no";

    public static final String COL_OUT_REFUND_NO = "out_refund_no";

    public static final String COL_PAY_TYPE = "pay_type";

    public static final String COL_PAY_TYPE_NAME = "pay_type_name";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_GOODS_NUM = "goods_num";

    public static final String COL_REFUND_AMOUNT = "refund_amount";

    public static final String COL_APPLY_TYPE = "apply_type";

    public static final String COL_REFUND_STS = "refund_sts";

    public static final String COL_RETURN_MONEY_STS = "return_money_sts";

    public static final String COL_APPLY_TIME = "apply_time";

    public static final String COL_HANDEL_TIME = "handel_time";

    public static final String COL_REFUND_TIME = "refund_time";

    public static final String COL_PHOTO_FILES = "photo_files";

    public static final String COL_BUYER_MSG = "buyer_msg";

    public static final String COL_SELLER_MSG = "seller_msg";

    public static final String COL_EXPRESS_NAME = "express_name";

    public static final String COL_EXPRESS_NO = "express_no";

    public static final String COL_SHIP_TIME = "ship_time";

    public static final String COL_RECEIVE_TIME = "receive_time";

    public static final String COL_RECEIVE_MESSAGE = "receive_message";

    /**
     * 获取记录ID
     *
     * @return refund_id - 记录ID
     */
    public Long getRefundId() {
        return refundId;
    }

    /**
     * 设置记录ID
     *
     * @param refundId 记录ID
     */
    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    /**
     * 获取店铺ID
     *
     * @return shop_id - 店铺ID
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置店铺ID
     *
     * @param shopId 店铺ID
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

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
     * 获取订单流水号
     *
     * @return order_number - 订单流水号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置订单流水号
     *
     * @param orderNumber 订单流水号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取订单总金额
     *
     * @return order_amount - 订单总金额
     */
    public Double getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置订单总金额
     *
     * @param orderAmount 订单总金额
     */
    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取订单项ID 全部退款是0
     *
     * @return order_item_id - 订单项ID 全部退款是0
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     * 设置订单项ID 全部退款是0
     *
     * @param orderItemId 订单项ID 全部退款是0
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * 获取退款编号
     *
     * @return refund_sn - 退款编号
     */
    public String getRefundSn() {
        return refundSn;
    }

    /**
     * 设置退款编号
     *
     * @param refundSn 退款编号
     */
    public void setRefundSn(String refundSn) {
        this.refundSn = refundSn;
    }

    /**
     * 获取订单支付流水号
     *
     * @return flow_trade_no - 订单支付流水号
     */
    public String getFlowTradeNo() {
        return flowTradeNo;
    }

    /**
     * 设置订单支付流水号
     *
     * @param flowTradeNo 订单支付流水号
     */
    public void setFlowTradeNo(String flowTradeNo) {
        this.flowTradeNo = flowTradeNo;
    }

    /**
     * 获取第三方退款单号(微信退款单号)
     *
     * @return out_refund_no - 第三方退款单号(微信退款单号)
     */
    public String getOutRefundNo() {
        return outRefundNo;
    }

    /**
     * 设置第三方退款单号(微信退款单号)
     *
     * @param outRefundNo 第三方退款单号(微信退款单号)
     */
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    /**
     * 获取订单支付方式 1 微信支付 2 支付宝
     *
     * @return pay_type - 订单支付方式 1 微信支付 2 支付宝
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置订单支付方式 1 微信支付 2 支付宝
     *
     * @param payType 订单支付方式 1 微信支付 2 支付宝
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取订单支付名称
     *
     * @return pay_type_name - 订单支付名称
     */
    public String getPayTypeName() {
        return payTypeName;
    }

    /**
     * 设置订单支付名称
     *
     * @param payTypeName 订单支付名称
     */
    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    /**
     * 获取买家ID
     *
     * @return user_id - 买家ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置买家ID
     *
     * @param userId 买家ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取退货数量
     *
     * @return goods_num - 退货数量
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * 设置退货数量
     *
     * @param goodsNum 退货数量
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 获取退款金额
     *
     * @return refund_amount - 退款金额
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * 设置退款金额
     *
     * @param refundAmount 退款金额
     */
    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * 获取申请类型:1,仅退款,2退款退货
     *
     * @return apply_type - 申请类型:1,仅退款,2退款退货
     */
    public Integer getApplyType() {
        return applyType;
    }

    /**
     * 设置申请类型:1,仅退款,2退款退货
     *
     * @param applyType 申请类型:1,仅退款,2退款退货
     */
    public void setApplyType(Integer applyType) {
        this.applyType = applyType;
    }

    /**
     * 获取处理状态:1为待审核,2为同意,3为不同意
     *
     * @return refund_sts - 处理状态:1为待审核,2为同意,3为不同意
     */
    public Integer getRefundSts() {
        return refundSts;
    }

    /**
     * 设置处理状态:1为待审核,2为同意,3为不同意
     *
     * @param refundSts 处理状态:1为待审核,2为同意,3为不同意
     */
    public void setRefundSts(Integer refundSts) {
        this.refundSts = refundSts;
    }

    /**
     * 获取处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败
     *
     * @return return_money_sts - 处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败
     */
    public Integer getReturnMoneySts() {
        return returnMoneySts;
    }

    /**
     * 设置处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败
     *
     * @param returnMoneySts 处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败
     */
    public void setReturnMoneySts(Integer returnMoneySts) {
        this.returnMoneySts = returnMoneySts;
    }

    /**
     * 获取申请时间
     *
     * @return apply_time - 申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请时间
     *
     * @param applyTime 申请时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取卖家处理时间
     *
     * @return handel_time - 卖家处理时间
     */
    public Date getHandelTime() {
        return handelTime;
    }

    /**
     * 设置卖家处理时间
     *
     * @param handelTime 卖家处理时间
     */
    public void setHandelTime(Date handelTime) {
        this.handelTime = handelTime;
    }

    /**
     * 获取退款时间
     *
     * @return refund_time - 退款时间
     */
    public Date getRefundTime() {
        return refundTime;
    }

    /**
     * 设置退款时间
     *
     * @param refundTime 退款时间
     */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /**
     * 获取文件凭证json
     *
     * @return photo_files - 文件凭证json
     */
    public String getPhotoFiles() {
        return photoFiles;
    }

    /**
     * 设置文件凭证json
     *
     * @param photoFiles 文件凭证json
     */
    public void setPhotoFiles(String photoFiles) {
        this.photoFiles = photoFiles;
    }

    /**
     * 获取申请原因
     *
     * @return buyer_msg - 申请原因
     */
    public String getBuyerMsg() {
        return buyerMsg;
    }

    /**
     * 设置申请原因
     *
     * @param buyerMsg 申请原因
     */
    public void setBuyerMsg(String buyerMsg) {
        this.buyerMsg = buyerMsg;
    }

    /**
     * 获取卖家备注
     *
     * @return seller_msg - 卖家备注
     */
    public String getSellerMsg() {
        return sellerMsg;
    }

    /**
     * 设置卖家备注
     *
     * @param sellerMsg 卖家备注
     */
    public void setSellerMsg(String sellerMsg) {
        this.sellerMsg = sellerMsg;
    }

    /**
     * 获取物流公司名称
     *
     * @return express_name - 物流公司名称
     */
    public String getExpressName() {
        return expressName;
    }

    /**
     * 设置物流公司名称
     *
     * @param expressName 物流公司名称
     */
    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    /**
     * 获取物流单号
     *
     * @return express_no - 物流单号
     */
    public String getExpressNo() {
        return expressNo;
    }

    /**
     * 设置物流单号
     *
     * @param expressNo 物流单号
     */
    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    /**
     * 获取发货时间
     *
     * @return ship_time - 发货时间
     */
    public Date getShipTime() {
        return shipTime;
    }

    /**
     * 设置发货时间
     *
     * @param shipTime 发货时间
     */
    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    /**
     * 获取收货时间
     *
     * @return receive_time - 收货时间
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置收货时间
     *
     * @param receiveTime 收货时间
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 获取收货备注
     *
     * @return receive_message - 收货备注
     */
    public String getReceiveMessage() {
        return receiveMessage;
    }

    /**
     * 设置收货备注
     *
     * @param receiveMessage 收货备注
     */
    public void setReceiveMessage(String receiveMessage) {
        this.receiveMessage = receiveMessage;
    }
}