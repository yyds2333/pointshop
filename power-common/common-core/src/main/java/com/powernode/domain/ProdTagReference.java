package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName(value = "prod_tag_reference")
public class ProdTagReference {
    /**
     * 分组引用id
     */
    @TableId(value = "reference_id", type = IdType.INPUT)
    private Long referenceId;

    /**
     * 店铺id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 标签id
     */
    @TableField(value = "tag_id")
    private Long tagId;

    /**
     * 商品id
     */
    @TableField(value = "prod_id")
    private Long prodId;

    /**
     * 状态(1:正常,0:删除)
     */
    @TableField(value = "`status`")
    private Boolean status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    public static final String COL_REFERENCE_ID = "reference_id";

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_TAG_ID = "tag_id";

    public static final String COL_PROD_ID = "prod_id";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    /**
     * 获取分组引用id
     *
     * @return reference_id - 分组引用id
     */
    public Long getReferenceId() {
        return referenceId;
    }

    /**
     * 设置分组引用id
     *
     * @param referenceId 分组引用id
     */
    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
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
     * 获取标签id
     *
     * @return tag_id - 标签id
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * 设置标签id
     *
     * @param tagId 标签id
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /**
     * 获取商品id
     *
     * @return prod_id - 商品id
     */
    public Long getProdId() {
        return prodId;
    }

    /**
     * 设置商品id
     *
     * @param prodId 商品id
     */
    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    /**
     * 获取状态(1:正常,0:删除)
     *
     * @return status - 状态(1:正常,0:删除)
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态(1:正常,0:删除)
     *
     * @param status 状态(1:正常,0:删除)
     */
    public void setStatus(Boolean status) {
        this.status = status;
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
}