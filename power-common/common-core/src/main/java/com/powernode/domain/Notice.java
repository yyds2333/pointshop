package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "notice")
public class Notice  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 公告id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 店铺id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 公告标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 公告内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 状态(1:公布 0:撤回)
     */
    @TableField(value = "`status`")
    private Boolean status;

    /**
     * 是否置顶
     */
    @TableField(value = "is_top")
    private Byte isTop;

    /**
     * 发布时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    public static final String COL_ID = "id";

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_TITLE = "title";

    public static final String COL_CONTENT = "content";

    public static final String COL_STATUS = "status";

    public static final String COL_IS_TOP = "is_top";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    /**
     * 获取公告id
     *
     * @return id - 公告id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置公告id
     *
     * @param id 公告id
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取公告标题
     *
     * @return title - 公告标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置公告标题
     *
     * @param title 公告标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取公告内容
     *
     * @return content - 公告内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置公告内容
     *
     * @param content 公告内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取状态(1:公布 0:撤回)
     *
     * @return status - 状态(1:公布 0:撤回)
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态(1:公布 0:撤回)
     *
     * @param status 状态(1:公布 0:撤回)
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取是否置顶
     *
     * @return is_top - 是否置顶
     */
    public Byte getIsTop() {
        return isTop;
    }

    /**
     * 设置是否置顶
     *
     * @param isTop 是否置顶
     */
    public void setIsTop(Byte isTop) {
        this.isTop = isTop;
    }

    /**
     * 获取发布时间
     *
     * @return create_time - 发布时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发布时间
     *
     * @param createTime 发布时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}