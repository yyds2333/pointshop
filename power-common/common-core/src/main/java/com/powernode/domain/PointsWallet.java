package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName(value = "points_wallet")
public class PointsWallet  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 积分钱包id
     */
    @TableId(value = "points_wallet_id", type = IdType.AUTO)
    private Long pointsWalletId;

    /**
     * 积分Id
     */
    @TableField(value = "points_id")
    private Long pointsId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 待结算积分
     */
    @TableField(value = "unsettled")
    private Double unsettled;

    /**
     * 已结算积分
     */
    @TableField(value = "settled")
    private Double settled;

    /**
     * 积累收益积分
     */
    @TableField(value = "addup")
    private Double addup;

    /**
     * 乐观锁
     */
    @TableField(value = "version")
    private Integer version;

    public static final String COL_POINTS_WALLET_ID = "points_wallet_id";

    public static final String COL_POINTS_ID = "points_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_UNSETTLED = "unsettled";

    public static final String COL_SETTLED = "settled";

    public static final String COL_ADDUP = "addup";

    public static final String COL_VERSION = "version";

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
     * 获取积分Id
     *
     * @return points_id - 积分Id
     */
    public Long getPointsId() {
        return pointsId;
    }

    /**
     * 设置积分Id
     *
     * @param pointsId 积分Id
     */
    public void setPointsId(Long pointsId) {
        this.pointsId = pointsId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取待结算积分
     *
     * @return unsettled - 待结算积分
     */
    public Double getUnsettled() {
        return unsettled;
    }

    /**
     * 设置待结算积分
     *
     * @param unsettled 待结算积分
     */
    public void setUnsettled(Double unsettled) {
        this.unsettled = unsettled;
    }

    /**
     * 获取已结算积分
     *
     * @return settled - 已结算积分
     */
    public Double getSettled() {
        return settled;
    }

    /**
     * 设置已结算积分
     *
     * @param settled 已结算积分
     */
    public void setSettled(Double settled) {
        this.settled = settled;
    }

    /**
     * 获取积累收益积分
     *
     * @return addup - 积累收益积分
     */
    public Double getAddup() {
        return addup;
    }

    /**
     * 设置积累收益积分
     *
     * @param addup 积累收益积分
     */
    public void setAddup(Double addup) {
        this.addup = addup;
    }

    /**
     * 获取乐观锁
     *
     * @return version - 乐观锁
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置乐观锁
     *
     * @param version 乐观锁
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}