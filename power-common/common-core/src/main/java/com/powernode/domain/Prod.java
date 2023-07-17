package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;

/**
    * 商品
    */
@TableName(value = "prod")
public class Prod {
    /**
     * 产品ID
     */
    @TableId(value = "prod_id", type = IdType.INPUT)
    private Long prodId;

    /**
     * 商品名称
     */
    @TableField(value = "prod_name")
    private String prodName;

    /**
     * 店铺id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 原价
     */
    @TableField(value = "ori_price")
    private BigDecimal oriPrice;

    /**
     * 现价
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 简要描述,卖点等
     */
    @TableField(value = "brief")
    private String brief;

    /**
     * 详细描述
     */
    @TableField(value = "content")
    private String content;

    /**
     * 商品主图
     */
    @TableField(value = "pic")
    private String pic;

    /**
     * 商品图片，以,分割
     */
    @TableField(value = "imgs")
    private String imgs;

    /**
     * 默认是1，表示正常状态, -1表示删除, 0下架
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 商品分类
     */
    @TableField(value = "category_id")
    private Long categoryId;

    /**
     * 销量
     */
    @TableField(value = "sold_num")
    private Integer soldNum;

    /**
     * 总库存
     */
    @TableField(value = "total_stocks")
    private Integer totalStocks;

    /**
     * 配送方式json见TransportModeVO
     */
    @TableField(value = "delivery_mode")
    private String deliveryMode;

    /**
     * 运费模板id
     */
    @TableField(value = "delivery_template_id")
    private Long deliveryTemplateId;

    /**
     * 录入时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 上架时间
     */
    @TableField(value = "putaway_time")
    private Date putawayTime;

    /**
     * 版本 乐观锁
     */
    @TableField(value = "version")
    private Integer version;

    public static final String COL_PROD_ID = "prod_id";

    public static final String COL_PROD_NAME = "prod_name";

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_ORI_PRICE = "ori_price";

    public static final String COL_PRICE = "price";

    public static final String COL_BRIEF = "brief";

    public static final String COL_CONTENT = "content";

    public static final String COL_PIC = "pic";

    public static final String COL_IMGS = "imgs";

    public static final String COL_STATUS = "status";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_SOLD_NUM = "sold_num";

    public static final String COL_TOTAL_STOCKS = "total_stocks";

    public static final String COL_DELIVERY_MODE = "delivery_mode";

    public static final String COL_DELIVERY_TEMPLATE_ID = "delivery_template_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_PUTAWAY_TIME = "putaway_time";

    public static final String COL_VERSION = "version";

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
     * 获取商品名称
     *
     * @return prod_name - 商品名称
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * 设置商品名称
     *
     * @param prodName 商品名称
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
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
     * 获取原价
     *
     * @return ori_price - 原价
     */
    public BigDecimal getOriPrice() {
        return oriPrice;
    }

    /**
     * 设置原价
     *
     * @param oriPrice 原价
     */
    public void setOriPrice(BigDecimal oriPrice) {
        this.oriPrice = oriPrice;
    }

    /**
     * 获取现价
     *
     * @return price - 现价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置现价
     *
     * @param price 现价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取简要描述,卖点等
     *
     * @return brief - 简要描述,卖点等
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置简要描述,卖点等
     *
     * @param brief 简要描述,卖点等
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }

    /**
     * 获取详细描述
     *
     * @return content - 详细描述
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置详细描述
     *
     * @param content 详细描述
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取商品主图
     *
     * @return pic - 商品主图
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置商品主图
     *
     * @param pic 商品主图
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 获取商品图片，以,分割
     *
     * @return imgs - 商品图片，以,分割
     */
    public String getImgs() {
        return imgs;
    }

    /**
     * 设置商品图片，以,分割
     *
     * @param imgs 商品图片，以,分割
     */
    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    /**
     * 获取默认是1，表示正常状态, -1表示删除, 0下架
     *
     * @return status - 默认是1，表示正常状态, -1表示删除, 0下架
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置默认是1，表示正常状态, -1表示删除, 0下架
     *
     * @param status 默认是1，表示正常状态, -1表示删除, 0下架
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取商品分类
     *
     * @return category_id - 商品分类
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品分类
     *
     * @param categoryId 商品分类
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取销量
     *
     * @return sold_num - 销量
     */
    public Integer getSoldNum() {
        return soldNum;
    }

    /**
     * 设置销量
     *
     * @param soldNum 销量
     */
    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    /**
     * 获取总库存
     *
     * @return total_stocks - 总库存
     */
    public Integer getTotalStocks() {
        return totalStocks;
    }

    /**
     * 设置总库存
     *
     * @param totalStocks 总库存
     */
    public void setTotalStocks(Integer totalStocks) {
        this.totalStocks = totalStocks;
    }

    /**
     * 获取配送方式json见TransportModeVO
     *
     * @return delivery_mode - 配送方式json见TransportModeVO
     */
    public String getDeliveryMode() {
        return deliveryMode;
    }

    /**
     * 设置配送方式json见TransportModeVO
     *
     * @param deliveryMode 配送方式json见TransportModeVO
     */
    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    /**
     * 获取运费模板id
     *
     * @return delivery_template_id - 运费模板id
     */
    public Long getDeliveryTemplateId() {
        return deliveryTemplateId;
    }

    /**
     * 设置运费模板id
     *
     * @param deliveryTemplateId 运费模板id
     */
    public void setDeliveryTemplateId(Long deliveryTemplateId) {
        this.deliveryTemplateId = deliveryTemplateId;
    }

    /**
     * 获取录入时间
     *
     * @return create_time - 录入时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置录入时间
     *
     * @param createTime 录入时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取上架时间
     *
     * @return putaway_time - 上架时间
     */
    public Date getPutawayTime() {
        return putawayTime;
    }

    /**
     * 设置上架时间
     *
     * @param putawayTime 上架时间
     */
    public void setPutawayTime(Date putawayTime) {
        this.putawayTime = putawayTime;
    }

    /**
     * 获取版本 乐观锁
     *
     * @return version - 版本 乐观锁
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本 乐观锁
     *
     * @param version 版本 乐观锁
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}