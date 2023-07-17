package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "prod_prop")
public class ProdProp {
    /**
     * 属性id
     */
    @TableId(value = "prop_id", type = IdType.INPUT)
    private Long propId;

    /**
     * 属性名称
     */
    @TableField(value = "prop_name")
    private String propName;

    /**
     * ProdPropRule 1:销售属性(规格); 2:参数属性;
     */
    @TableField(value = "`rule`")
    private Byte rule;

    /**
     * 店铺id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    public static final String COL_PROP_ID = "prop_id";

    public static final String COL_PROP_NAME = "prop_name";

    public static final String COL_RULE = "rule";

    public static final String COL_SHOP_ID = "shop_id";

    /**
     * 获取属性id
     *
     * @return prop_id - 属性id
     */
    public Long getPropId() {
        return propId;
    }

    /**
     * 设置属性id
     *
     * @param propId 属性id
     */
    public void setPropId(Long propId) {
        this.propId = propId;
    }

    /**
     * 获取属性名称
     *
     * @return prop_name - 属性名称
     */
    public String getPropName() {
        return propName;
    }

    /**
     * 设置属性名称
     *
     * @param propName 属性名称
     */
    public void setPropName(String propName) {
        this.propName = propName;
    }

    /**
     * 获取ProdPropRule 1:销售属性(规格); 2:参数属性;
     *
     * @return rule - ProdPropRule 1:销售属性(规格); 2:参数属性;
     */
    public Byte getRule() {
        return rule;
    }

    /**
     * 设置ProdPropRule 1:销售属性(规格); 2:参数属性;
     *
     * @param rule ProdPropRule 1:销售属性(规格); 2:参数属性;
     */
    public void setRule(Byte rule) {
        this.rule = rule;
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
}