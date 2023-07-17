package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
    * 商品收藏表
    */
@TableName(value = "prod_favorite")
public class ProdFavorite {
    /**
     * 主键
     */
    @TableId(value = "favorite_id", type = IdType.INPUT)
    private Long favoriteId;

    /**
     * 商品ID
     */
    @TableField(value = "prod_id")
    private Long prodId;

    /**
     * 收藏时间
     */
    @TableField(value = "rec_time")
    private Date recTime;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;

    public static final String COL_FAVORITE_ID = "favorite_id";

    public static final String COL_PROD_ID = "prod_id";

    public static final String COL_REC_TIME = "rec_time";

    public static final String COL_USER_ID = "user_id";

    /**
     * 获取主键
     *
     * @return favorite_id - 主键
     */
    public Long getFavoriteId() {
        return favoriteId;
    }

    /**
     * 设置主键
     *
     * @param favoriteId 主键
     */
    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
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
     * 获取收藏时间
     *
     * @return rec_time - 收藏时间
     */
    public Date getRecTime() {
        return recTime;
    }

    /**
     * 设置收藏时间
     *
     * @param recTime 收藏时间
     */
    public void setRecTime(Date recTime) {
        this.recTime = recTime;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}