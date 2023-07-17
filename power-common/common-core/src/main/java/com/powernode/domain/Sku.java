package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;

/**
    * 单品SKU表
    */
@TableName(value = "sku")
public class Sku {
    /**
     * 单品ID
     */
    @TableId(value = "sku_id", type = IdType.INPUT)
    private Long skuId;

    /**
     * 商品ID
     */
    @TableField(value = "prod_id")
    private Long prodId;

    /**
     * 销售属性组合字符串 格式是p1:v1;p2:v2
     */
    @TableField(value = "properties")
    private String properties;

    /**
     * 原价
     */
    @TableField(value = "ori_price")
    private BigDecimal oriPrice;

    /**
     * 价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 商品在付款减库存的状态下，该sku上未付款的订单数量
     */
    @TableField(value = "stocks")
    private Integer stocks;

    /**
     * 实际库存
     */
    @TableField(value = "actual_stocks")
    private Integer actualStocks;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 记录时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 商家编码
     */
    @TableField(value = "party_code")
    private String partyCode;

    /**
     * 商品条形码
     */
    @TableField(value = "model_id")
    private String modelId;

    /**
     * sku图片
     */
    @TableField(value = "pic")
    private String pic;

    /**
     * sku名称
     */
    @TableField(value = "sku_name")
    private String skuName;

    /**
     * 商品名称
     */
    @TableField(value = "prod_name")
    private String prodName;

    /**
     * 版本号
     */
    @TableField(value = "version")
    private Integer version;

    /**
     * 商品重量
     */
    @TableField(value = "weight")
    private Double weight;

    /**
     * 商品体积
     */
    @TableField(value = "volume")
    private Double volume;

    /**
     * 0 禁用 1 启用
     */
    @TableField(value = "`status`")
    private Byte status;

    /**
     * 0 正常 1 已被删除
     */
    @TableField(value = "is_delete")
    private Byte isDelete;

    public static final String COL_SKU_ID = "sku_id";

    public static final String COL_PROD_ID = "prod_id";

    public static final String COL_PROPERTIES = "properties";

    public static final String COL_ORI_PRICE = "ori_price";

    public static final String COL_PRICE = "price";

    public static final String COL_STOCKS = "stocks";

    public static final String COL_ACTUAL_STOCKS = "actual_stocks";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_PARTY_CODE = "party_code";

    public static final String COL_MODEL_ID = "model_id";

    public static final String COL_PIC = "pic";

    public static final String COL_SKU_NAME = "sku_name";

    public static final String COL_PROD_NAME = "prod_name";

    public static final String COL_VERSION = "version";

    public static final String COL_WEIGHT = "weight";

    public static final String COL_VOLUME = "volume";

    public static final String COL_STATUS = "status";

    public static final String COL_IS_DELETE = "is_delete";

    /**
     * 获取单品ID
     *
     * @return sku_id - 单品ID
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 设置单品ID
     *
     * @param skuId 单品ID
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取商品ID
     *
     * @return prod_id - 商品ID
     */
    public Long getProdId() {
        return prodId;
    }

    /**
     * 设置商品ID
     *
     * @param prodId 商品ID
     */
    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    /**
     * 获取销售属性组合字符串 格式是p1:v1;p2:v2
     *
     * @return properties - 销售属性组合字符串 格式是p1:v1;p2:v2
     */
    public String getProperties() {
        return properties;
    }

    /**
     * 设置销售属性组合字符串 格式是p1:v1;p2:v2
     *
     * @param properties 销售属性组合字符串 格式是p1:v1;p2:v2
     */
    public void setProperties(String properties) {
        this.properties = properties;
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
     * 获取价格
     *
     * @return price - 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取商品在付款减库存的状态下，该sku上未付款的订单数量
     *
     * @return stocks - 商品在付款减库存的状态下，该sku上未付款的订单数量
     */
    public Integer getStocks() {
        return stocks;
    }

    /**
     * 设置商品在付款减库存的状态下，该sku上未付款的订单数量
     *
     * @param stocks 商品在付款减库存的状态下，该sku上未付款的订单数量
     */
    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    /**
     * 获取实际库存
     *
     * @return actual_stocks - 实际库存
     */
    public Integer getActualStocks() {
        return actualStocks;
    }

    /**
     * 设置实际库存
     *
     * @param actualStocks 实际库存
     */
    public void setActualStocks(Integer actualStocks) {
        this.actualStocks = actualStocks;
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
     * 获取记录时间
     *
     * @return create_time - 记录时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置记录时间
     *
     * @param createTime 记录时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取商家编码
     *
     * @return party_code - 商家编码
     */
    public String getPartyCode() {
        return partyCode;
    }

    /**
     * 设置商家编码
     *
     * @param partyCode 商家编码
     */
    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    /**
     * 获取商品条形码
     *
     * @return model_id - 商品条形码
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * 设置商品条形码
     *
     * @param modelId 商品条形码
     */
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    /**
     * 获取sku图片
     *
     * @return pic - sku图片
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置sku图片
     *
     * @param pic sku图片
     */
    public void setPic(String pic) {
        this.pic = pic;
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
     * 获取商品重量
     *
     * @return weight - 商品重量
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 设置商品重量
     *
     * @param weight 商品重量
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 获取商品体积
     *
     * @return volume - 商品体积
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * 设置商品体积
     *
     * @param volume 商品体积
     */
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    /**
     * 获取0 禁用 1 启用
     *
     * @return status - 0 禁用 1 启用
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置0 禁用 1 启用
     *
     * @param status 0 禁用 1 启用
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取0 正常 1 已被删除
     *
     * @return is_delete - 0 正常 1 已被删除
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * 设置0 正常 1 已被删除
     *
     * @param isDelete 0 正常 1 已被删除
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}