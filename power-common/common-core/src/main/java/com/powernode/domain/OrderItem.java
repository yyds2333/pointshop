package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;

/**
    * 订单项
    */
@TableName(value = "order_item")
public class OrderItem {
    /**
     * 订单项ID
     */
    @TableId(value = "order_item_id", type = IdType.INPUT)
    private Long orderItemId;

    /**
     * 店铺id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 订单order_number
     */
    @TableField(value = "order_number")
    private String orderNumber;

    /**
     * 产品ID
     */
    @TableField(value = "prod_id")
    private Long prodId;

    /**
     * 产品SkuID
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 购物车产品个数
     */
    @TableField(value = "prod_count")
    private Integer prodCount;

    /**
     * 产品名称
     */
    @TableField(value = "prod_name")
    private String prodName;

    /**
     * sku名称
     */
    @TableField(value = "sku_name")
    private String skuName;

    /**
     * 产品主图片路径
     */
    @TableField(value = "pic")
    private String pic;

    /**
     * 产品价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 商品总金额
     */
    @TableField(value = "product_total_amount")
    private BigDecimal productTotalAmount;

    /**
     * 购物时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 评论状态： 0 未评价  1 已评价
     */
    @TableField(value = "comm_sts")
    private Integer commSts;

    public static final String COL_ORDER_ITEM_ID = "order_item_id";

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_ORDER_NUMBER = "order_number";

    public static final String COL_PROD_ID = "prod_id";

    public static final String COL_SKU_ID = "sku_id";

    public static final String COL_PROD_COUNT = "prod_count";

    public static final String COL_PROD_NAME = "prod_name";

    public static final String COL_SKU_NAME = "sku_name";

    public static final String COL_PIC = "pic";

    public static final String COL_PRICE = "price";

    public static final String COL_PRODUCT_TOTAL_AMOUNT = "product_total_amount";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_COMM_STS = "comm_sts";

    /**
     * 获取订单项ID
     *
     * @return order_item_id - 订单项ID
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     * 设置订单项ID
     *
     * @param orderItemId 订单项ID
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
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
     * 获取订单order_number
     *
     * @return order_number - 订单order_number
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置订单order_number
     *
     * @param orderNumber 订单order_number
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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
     * 获取产品SkuID
     *
     * @return sku_id - 产品SkuID
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 设置产品SkuID
     *
     * @param skuId 产品SkuID
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
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
     * 获取产品名称
     *
     * @return prod_name - 产品名称
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * 设置产品名称
     *
     * @param prodName 产品名称
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    /**
     * 获取sku名称
     *
     * @return sku_name - sku名称
     */
    public String getSkuName() {
        return skuName;
    }

    /**
     * 设置sku名称
     *
     * @param skuName sku名称
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    /**
     * 获取产品主图片路径
     *
     * @return pic - 产品主图片路径
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置产品主图片路径
     *
     * @param pic 产品主图片路径
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 获取产品价格
     *
     * @return price - 产品价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置产品价格
     *
     * @param price 产品价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取商品总金额
     *
     * @return product_total_amount - 商品总金额
     */
    public BigDecimal getProductTotalAmount() {
        return productTotalAmount;
    }

    /**
     * 设置商品总金额
     *
     * @param productTotalAmount 商品总金额
     */
    public void setProductTotalAmount(BigDecimal productTotalAmount) {
        this.productTotalAmount = productTotalAmount;
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

    /**
     * 获取评论状态： 0 未评价  1 已评价
     *
     * @return comm_sts - 评论状态： 0 未评价  1 已评价
     */
    public Integer getCommSts() {
        return commSts;
    }

    /**
     * 设置评论状态： 0 未评价  1 已评价
     *
     * @param commSts 评论状态： 0 未评价  1 已评价
     */
    public void setCommSts(Integer commSts) {
        this.commSts = commSts;
    }
}