package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "points_change")
public class PointsChange  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 积分流动记录表
     */
    @TableId(value = "points_change_id", type = IdType.AUTO)
    private Long pointsChangeId;

    /**
     * 积分钱包id
     */
    @TableField(value = "points_wallet_id")
    private Long pointsWalletId;

    /**
     * 增加或减少(增加 0 减少 1)
     */
    @TableField(value = "add_or_reduce")
    private Byte addOrReduce;

    /**
     * 原因(订单，邀请，签到，兑换)
     */
    @TableField(value = "reason")
    private Byte reason;

    /**
     * 积分状态（0:用户未收货待结算，1:已结算 2:用户退货退单）
     */
    @TableField(value = "`state`")
    private Byte state;

    /**
     * 积分数额
     */
    @TableField(value = "points_number")
    private Double pointsNumber;

    /**
     * 关联订单id
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 商户订单id
     */
    @TableField(value = "merchant_order_id")
    private Long merchantOrderId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    public static final String COL_POINTS_CHANGE_ID = "points_change_id";

    public static final String COL_POINTS_WALLET_ID = "points_wallet_id";

    public static final String COL_ADD_OR_REDUCE = "add_or_reduce";

    public static final String COL_REASON = "reason";

    public static final String COL_STATE = "state";

    public static final String COL_POINTS_NUMBER = "points_number";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_MERCHANT_ORDER_ID = "merchant_order_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    /**
     * 获取积分流动记录表
     *
     * @return points_change_id - 积分流动记录表
     */
    public Long getPointsChangeId() {
        return pointsChangeId;
    }

    /**
     * 设置积分流动记录表
     *
     * @param pointsChangeId 积分流动记录表
     */
    public void setPointsChangeId(Long pointsChangeId) {
        this.pointsChangeId = pointsChangeId;
    }

    /**
     * 获取积分钱包id
     *
     * @return points_wallet_id - 积分钱包id
     */
    public Long getPointsWalletId() {
        return pointsWalletId;
    }

    /**
     * 设置积分钱包id
     *
     * @param pointsWalletId 积分钱包id
     */
    public void setPointsWalletId(Long pointsWalletId) {
        this.pointsWalletId = pointsWalletId;
    }

    /**
     * 获取增加或减少(增加 0 减少 1)
     *
     * @return add_or_reduce - 增加或减少(增加 0 减少 1)
     */
    public Byte getAddOrReduce() {
        return addOrReduce;
    }

    /**
     * 设置增加或减少(增加 0 减少 1)
     *
     * @param addOrReduce 增加或减少(增加 0 减少 1)
     */
    public void setAddOrReduce(Byte addOrReduce) {
        this.addOrReduce = addOrReduce;
    }

    /**
     * 获取原因(订单，邀请，签到，兑换)
     *
     * @return reason - 原因(订单，邀请，签到，兑换)
     */
    public Byte getReason() {
        return reason;
    }

    /**
     * 设置原因(订单，邀请，签到，兑换)
     *
     * @param reason 原因(订单，邀请，签到，兑换)
     */
    public void setReason(Byte reason) {
        this.reason = reason;
    }

    /**
     * 获取积分状态（0:用户未收货待结算，1:已结算 2:用户退货退单）
     *
     * @return state - 积分状态（0:用户未收货待结算，1:已结算 2:用户退货退单）
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置积分状态（0:用户未收货待结算，1:已结算 2:用户退货退单）
     *
     * @param state 积分状态（0:用户未收货待结算，1:已结算 2:用户退货退单）
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 获取积分数额
     *
     * @return points_number - 积分数额
     */
    public Double getPointsNumber() {
        return pointsNumber;
    }

    /**
     * 设置积分数额
     *
     * @param pointsNumber 积分数额
     */
    public void setPointsNumber(Double pointsNumber) {
        this.pointsNumber = pointsNumber;
    }

    /**
     * 获取关联订单id
     *
     * @return order_id - 关联订单id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置关联订单id
     *
     * @param orderId 关联订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取商户订单id
     *
     * @return merchant_order_id - 商户订单id
     */
    public Long getMerchantOrderId() {
        return merchantOrderId;
    }

    /**
     * 设置商户订单id
     *
     * @param merchantOrderId 商户订单id
     */
    public void setMerchantOrderId(Long merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}