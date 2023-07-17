package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName(value = "score_log")
public class ScoreLog {
    /**
     * 积分记录id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 0支出 1收入
     */
    @TableField(value = "`type`")
    private Byte type;

    /**
     * 记录创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 流水号
     */
    @TableField(value = "sn")
    private String sn;

    /**
     * 积分类型：1回收加积分 2购买减积分
     */
    @TableField(value = "score_type")
    private Byte scoreType;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_TYPE = "type";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_SN = "sn";

    public static final String COL_SCORE_TYPE = "score_type";

    /**
     * 获取积分记录id
     *
     * @return id - 积分记录id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置积分记录id
     *
     * @param id 积分记录id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取0支出 1收入
     *
     * @return type - 0支出 1收入
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置0支出 1收入
     *
     * @param type 0支出 1收入
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取记录创建时间
     *
     * @return create_time - 记录创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置记录创建时间
     *
     * @param createTime 记录创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取流水号
     *
     * @return sn - 流水号
     */
    public String getSn() {
        return sn;
    }

    /**
     * 设置流水号
     *
     * @param sn 流水号
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * 获取积分类型：1回收加积分 2购买减积分
     *
     * @return score_type - 积分类型：1回收加积分 2购买减积分
     */
    public Byte getScoreType() {
        return scoreType;
    }

    /**
     * 设置积分类型：1回收加积分 2购买减积分
     *
     * @param scoreType 积分类型：1回收加积分 2购买减积分
     */
    public void setScoreType(Byte scoreType) {
        this.scoreType = scoreType;
    }
}