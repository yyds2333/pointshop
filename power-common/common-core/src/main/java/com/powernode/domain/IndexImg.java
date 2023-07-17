package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
    * 主页轮播图
    */
@TableName(value = "index_img")
public class IndexImg {
    /**
     * 主键
     */
    @TableId(value = "img_id", type = IdType.INPUT)
    private Long imgId;

    /**
     * 店铺ID
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 图片
     */
    @TableField(value = "img_url")
    private String imgUrl;

    /**
     * 说明文字,描述
     */
    @TableField(value = "des")
    private String des;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 链接
     */
    @TableField(value = "link")
    private String link;

    /**
     * 状态
     */
    @TableField(value = "`status`")
    private Boolean status;

    /**
     * 顺序
     */
    @TableField(value = "seq")
    private Integer seq;

    /**
     * 上传时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 关联
     */
    @TableField(value = "prod_id")
    private Long prodId;

    public static final String COL_IMG_ID = "img_id";

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_IMG_URL = "img_url";

    public static final String COL_DES = "des";

    public static final String COL_TITLE = "title";

    public static final String COL_LINK = "link";

    public static final String COL_STATUS = "status";

    public static final String COL_SEQ = "seq";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_PROD_ID = "prod_id";

    /**
     * 获取主键
     *
     * @return img_id - 主键
     */
    public Long getImgId() {
        return imgId;
    }

    /**
     * 设置主键
     *
     * @param imgId 主键
     */
    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    /**
     * 获取店铺ID
     *
     * @return shop_id - 店铺ID
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置店铺ID
     *
     * @param shopId 店铺ID
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取图片
     *
     * @return img_url - 图片
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片
     *
     * @param imgUrl 图片
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取说明文字,描述
     *
     * @return des - 说明文字,描述
     */
    public String getDes() {
        return des;
    }

    /**
     * 设置说明文字,描述
     *
     * @param des 说明文字,描述
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取链接
     *
     * @return link - 链接
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置链接
     *
     * @param link 链接
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Boolean status) {
        this.status = status;
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
     * 获取上传时间
     *
     * @return create_time - 上传时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置上传时间
     *
     * @param createTime 上传时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取关联
     *
     * @return prod_id - 关联
     */
    public Long getProdId() {
        return prodId;
    }

    /**
     * 设置关联
     *
     * @param prodId 关联
     */
    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }
}