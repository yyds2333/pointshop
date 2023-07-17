package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName(value = "transport")
public class Transport {
    /**
     * 运费模板id
     */
    @TableId(value = "transport_id", type = IdType.INPUT)
    private Long transportId;

    /**
     * 运费模板名称
     */
    @TableField(value = "trans_name")
    private String transName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 店铺id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 收费方式（0 按件数,1 按重量 2 按体积）
     */
    @TableField(value = "charge_type")
    private Byte chargeType;

    /**
     * 是否包邮 0:不包邮 1:包邮
     */
    @TableField(value = "is_free_fee")
    private Byte isFreeFee;

    /**
     * 是否含有包邮条件 0 否 1是
     */
    @TableField(value = "has_free_condition")
    private Byte hasFreeCondition;

    public static final String COL_TRANSPORT_ID = "transport_id";

    public static final String COL_TRANS_NAME = "trans_name";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_CHARGE_TYPE = "charge_type";

    public static final String COL_IS_FREE_FEE = "is_free_fee";

    public static final String COL_HAS_FREE_CONDITION = "has_free_condition";

    /**
     * 获取运费模板id
     *
     * @return transport_id - 运费模板id
     */
    public Long getTransportId() {
        return transportId;
    }

    /**
     * 设置运费模板id
     *
     * @param transportId 运费模板id
     */
    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    /**
     * 获取运费模板名称
     *
     * @return trans_name - 运费模板名称
     */
    public String getTransName() {
        return transName;
    }

    /**
     * 设置运费模板名称
     *
     * @param transName 运费模板名称
     */
    public void setTransName(String transName) {
        this.transName = transName;
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
     * 获取店铺id
     *
     * @return shop_id - 店铺id
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置店铺id
     *
     * @param shopId 店铺id
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取收费方式（0 按件数,1 按重量 2 按体积）
     *
     * @return charge_type - 收费方式（0 按件数,1 按重量 2 按体积）
     */
    public Byte getChargeType() {
        return chargeType;
    }

    /**
     * 设置收费方式（0 按件数,1 按重量 2 按体积）
     *
     * @param chargeType 收费方式（0 按件数,1 按重量 2 按体积）
     */
    public void setChargeType(Byte chargeType) {
        this.chargeType = chargeType;
    }

    /**
     * 获取是否包邮 0:不包邮 1:包邮
     *
     * @return is_free_fee - 是否包邮 0:不包邮 1:包邮
     */
    public Byte getIsFreeFee() {
        return isFreeFee;
    }

    /**
     * 设置是否包邮 0:不包邮 1:包邮
     *
     * @param isFreeFee 是否包邮 0:不包邮 1:包邮
     */
    public void setIsFreeFee(Byte isFreeFee) {
        this.isFreeFee = isFreeFee;
    }

    /**
     * 获取是否含有包邮条件 0 否 1是
     *
     * @return has_free_condition - 是否含有包邮条件 0 否 1是
     */
    public Byte getHasFreeCondition() {
        return hasFreeCondition;
    }

    /**
     * 设置是否含有包邮条件 0 否 1是
     *
     * @param hasFreeCondition 是否含有包邮条件 0 否 1是
     */
    public void setHasFreeCondition(Byte hasFreeCondition) {
        this.hasFreeCondition = hasFreeCondition;
    }
}