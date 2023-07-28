package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName(value = "category_prop")
public class CategoryProp  implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类id
     */
    @TableField(value = "category_id")
    private Long categoryId;

    /**
     * 商品属性id即表prod_prop中的prop_id
     */
    @TableField(value = "prop_id")
    private Long propId;

    public static final String COL_ID = "id";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_PROP_ID = "prop_id";

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分类id
     *
     * @return category_id - 分类id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类id
     *
     * @param categoryId 分类id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取商品属性id即表prod_prop中的prop_id
     *
     * @return prop_id - 商品属性id即表prod_prop中的prop_id
     */
    public Long getPropId() {
        return propId;
    }

    /**
     * 设置商品属性id即表prod_prop中的prop_id
     *
     * @param propId 商品属性id即表prod_prop中的prop_id
     */
    public void setPropId(Long propId) {
        this.propId = propId;
    }
}