package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;

@TableName(value = "points_prod")
public class PointsProd {
    /**
     * 积分商品id
     */
    @TableId(value = "points_prod_id", type = IdType.INPUT)
    private Long pointsProdId;

    /**
     * 所需积分id
     */
    @TableField(value = "points_id")
    private Long pointsId;

    /**
     * 所需积分量
     */
    @TableField(value = "points_number")
    private Double pointsNumber;

    /**
     * 所需金额
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 关联商品id
     */
    @TableField(value = "prod_id")
    private Long prodId;

    /**
     * 库存
     */
    @TableField(value = "stocks")
    private Integer stocks;

    /**
     * 状态(0下架 1上架)
     */
    @TableField(value = "`state`")
    private Byte state;

    /**
     * 上架时间
     */
    @TableField(value = "upper_shelf_time")
    private Date upperShelfTime;

    /**
     * 下架时间
     */
    @TableField(value = "lower_shelf")
    private Date lowerShelf;

    public static final String COL_POINTS_PROD_ID = "points_prod_id";

    public static final String COL_POINTS_ID = "points_id";

    public static final String COL_POINTS_NUMBER = "points_number";

    public static final String COL_AMOUNT = "amount";

    public static final String COL_PROD_ID = "prod_id";

    public static final String COL_STOCKS = "stocks";

    public static final String COL_STATE = "state";

    public static final String COL_UPPER_SHELF_TIME = "upper_shelf_time";

    public static final String COL_LOWER_SHELF = "lower_shelf";

    /**
     * 获取积分商品id
     *
     * @return points_prod_id - 积分商品id
     */
    public Long getPointsProdId() {
        return pointsProdId;
    }

    /**
     * 设置积分商品id
     *
     * @param pointsProdId 积分商品id
     */
    public void setPointsProdId(Long pointsProdId) {
        this.pointsProdId = pointsProdId;
    }

    /**
     * 获取所需积分id
     *
     * @return points_id - 所需积分id
     */
    public Long getPointsId() {
        return pointsId;
    }

    /**
     * 设置所需积分id
     *
     * @param pointsId 所需积分id
     */
    public void setPointsId(Long pointsId) {
        this.pointsId = pointsId;
    }

    /**
     * 获取所需积分量
     *
     * @return points_number - 所需积分量
     */
    public Double getPointsNumber() {
        return pointsNumber;
    }

    /**
     * 设置所需积分量
     *
     * @param pointsNumber 所需积分量
     */
    public void setPointsNumber(Double pointsNumber) {
        this.pointsNumber = pointsNumber;
    }

    /**
     * 获取所需金额
     *
     * @return amount - 所需金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置所需金额
     *
     * @param amount 所需金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取关联商品id
     *
     * @return prod_id - 关联商品id
     */
    public Long getProdId() {
        return prodId;
    }

    /**
     * 设置关联商品id
     *
     * @param prodId 关联商品id
     */
    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    /**
     * 获取库存
     *
     * @return stocks - 库存
     */
    public Integer getStocks() {
        return stocks;
    }

    /**
     * 设置库存
     *
     * @param stocks 库存
     */
    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    /**
     * 获取状态(0下架 1上架)
     *
     * @return state - 状态(0下架 1上架)
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置状态(0下架 1上架)
     *
     * @param state 状态(0下架 1上架)
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 获取上架时间
     *
     * @return upper_shelf_time - 上架时间
     */
    public Date getUpperShelfTime() {
        return upperShelfTime;
    }

    /**
     * 设置上架时间
     *
     * @param upperShelfTime 上架时间
     */
    public void setUpperShelfTime(Date upperShelfTime) {
        this.upperShelfTime = upperShelfTime;
    }

    /**
     * 获取下架时间
     *
     * @return lower_shelf - 下架时间
     */
    public Date getLowerShelf() {
        return lowerShelf;
    }

    /**
     * 设置下架时间
     *
     * @param lowerShelf 下架时间
     */
    public void setLowerShelf(Date lowerShelf) {
        this.lowerShelf = lowerShelf;
    }
}