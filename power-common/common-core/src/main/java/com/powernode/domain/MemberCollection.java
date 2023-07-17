package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName(value = "member_collection")
public class MemberCollection {
    /**
     * 收藏表
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 商品id
     */
    @TableField(value = "prod_id")
    private Long prodId;

    /**
     * 用户id
     */
    @TableField(value = "open_id")
    private String openId;

    /**
     * 收藏时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    public static final String COL_ID = "id";

    public static final String COL_PROD_ID = "prod_id";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_CREATE_TIME = "create_time";

    /**
     * 获取收藏表
     *
     * @return id - 收藏表
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置收藏表
     *
     * @param id 收藏表
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取用户id
     *
     * @return open_id - 用户id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置用户id
     *
     * @param openId 用户id
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取收藏时间
     *
     * @return create_time - 收藏时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置收藏时间
     *
     * @param createTime 收藏时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}