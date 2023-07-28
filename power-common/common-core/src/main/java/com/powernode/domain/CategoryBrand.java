package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName(value = "category_brand")
public class CategoryBrand  implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类id
     */
    @TableField(value = "category_id")
    private Long categoryId;

    /**
     * 品牌id
     */
    @TableField(value = "brand_id")
    private Long brandId;

    public static final String COL_ID = "id";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_BRAND_ID = "brand_id";

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
     * 获取品牌id
     *
     * @return brand_id - 品牌id
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 设置品牌id
     *
     * @param brandId 品牌id
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}