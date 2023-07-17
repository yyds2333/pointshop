package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
    * 热搜
    */
@TableName(value = "hot_search")
public class HotSearch {
    /**
     * 主键
     */
    @TableId(value = "hot_search_id", type = IdType.INPUT)
    private Long hotSearchId;

    /**
     * 店铺ID 0为全局热搜
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 录入时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 顺序
     */
    @TableField(value = "seq")
    private Integer seq;

    /**
     * 状态 0下线 1上线
     */
    @TableField(value = "`status`")
    private Byte status;

    /**
     * 热搜标题
     */
    @TableField(value = "title")
    private String title;

    public static final String COL_HOT_SEARCH_ID = "hot_search_id";

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_CONTENT = "content";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_SEQ = "seq";

    public static final String COL_STATUS = "status";

    public static final String COL_TITLE = "title";

    /**
     * 获取主键
     *
     * @return hot_search_id - 主键
     */
    public Long getHotSearchId() {
        return hotSearchId;
    }

    /**
     * 设置主键
     *
     * @param hotSearchId 主键
     */
    public void setHotSearchId(Long hotSearchId) {
        this.hotSearchId = hotSearchId;
    }

    /**
     * 获取店铺ID 0为全局热搜
     *
     * @return shop_id - 店铺ID 0为全局热搜
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置店铺ID 0为全局热搜
     *
     * @param shopId 店铺ID 0为全局热搜
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
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
     * 获取顺序
     *
     * @return seq - 顺序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置顺序
     *
     * @param seq 顺序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取状态 0下线 1上线
     *
     * @return status - 状态 0下线 1上线
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 0下线 1上线
     *
     * @param status 状态 0下线 1上线
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取热搜标题
     *
     * @return title - 热搜标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置热搜标题
     *
     * @param title 热搜标题
     */
    public void setTitle(String title) {
        this.title = title;
    }
}