package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName(value = "prod_prop_value")
public class ProdPropValue  implements Serializable {
    /**
     * 属性值ID
     */
    @TableId(value = "value_id", type = IdType.AUTO)
    private Long valueId;

    /**
     * 属性值名称
     */
    @TableField(value = "prop_value")
    private String propValue;

    /**
     * 属性ID
     */
    @TableField(value = "prop_id")
    private Long propId;

    public static final String COL_VALUE_ID = "value_id";

    public static final String COL_PROP_VALUE = "prop_value";

    public static final String COL_PROP_ID = "prop_id";

    /**
     * 获取属性值ID
     *
     * @return value_id - 属性值ID
     */
    public Long getValueId() {
        return valueId;
    }

    /**
     * 设置属性值ID
     *
     * @param valueId 属性值ID
     */
    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    /**
     * 获取属性值名称
     *
     * @return prop_value - 属性值名称
     */
    public String getPropValue() {
        return propValue;
    }

    /**
     * 设置属性值名称
     *
     * @param propValue 属性值名称
     */
    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    /**
     * 获取属性ID
     *
     * @return prop_id - 属性ID
     */
    public Long getPropId() {
        return propId;
    }

    /**
     * 设置属性ID
     *
     * @param propId 属性ID
     */
    public void setPropId(Long propId) {
        this.propId = propId;
    }
}