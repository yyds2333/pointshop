package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
    * 购物车
    */
@TableName(value = "basket")
public class Basket {
    /**
     * 主键
     */
    @TableId(value = "basket_id", type = IdType.INPUT)
    private Long basketId;

    /**
     * 店铺ID
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 产品ID
     */
    @TableField(value = "prod_id")
    private Long prodId;

    /**
     * SkuID
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 用户ID
     */
    @TableField(value = "open_id")
    private String openId;

    /**
     * 购物车产品个数
     */
    @TableField(value = "prod_count")
    private Integer prodCount;

    /**
     * 购物时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    public static final String COL_BASKET_ID = "basket_id";

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_PROD_ID = "prod_id";

    public static final String COL_SKU_ID = "sku_id";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_PROD_COUNT = "prod_count";

    public static final String COL_CREATE_TIME = "create_time";

    /**
     * 获取主键
     *
     * @return basket_id - 主键
     */
    public Long getBasketId() {
        return basketId;
    }

    /**
     * 设置主键
     *
     * @param basketId 主键
     */
    public void setBasketId(Long basketId) {
        this.basketId = basketId;
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
     * 获取产品ID
     *
     * @return prod_id - 产品ID
     */
    public Long getProdId() {
        return prodId;
    }

    /**
     * 设置产品ID
     *
     * @param prodId 产品ID
     */
    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    /**
     * 获取SkuID
     *
     * @return sku_id - SkuID
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 设置SkuID
     *
     * @param skuId SkuID
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取用户ID
     *
     * @return open_id - 用户ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置用户ID
     *
     * @param openId 用户ID
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取购物车产品个数
     *
     * @return prod_count - 购物车产品个数
     */
    public Integer getProdCount() {
        return prodCount;
    }

    /**
     * 设置购物车产品个数
     *
     * @param prodCount 购物车产品个数
     */
    public void setProdCount(Integer prodCount) {
        this.prodCount = prodCount;
    }

    /**
     * 获取购物时间
     *
     * @return create_time - 购物时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置购物时间
     *
     * @param createTime 购物时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}