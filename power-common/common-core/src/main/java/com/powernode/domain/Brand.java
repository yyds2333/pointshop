package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
    * 品牌表
    */
@TableName(value = "brand")
public class Brand  implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "brand_id", type = IdType.AUTO)
    private Long brandId;

    /**
     * 品牌名称
     */
    @TableField(value = "brand_name")
    private String brandName;

    /**
     * 图片路径
     */
    @TableField(value = "brand_pic")
    private String brandPic;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 备注
     */
    @TableField(value = "memo")
    private String memo;

    /**
     * 顺序
     */
    @TableField(value = "seq")
    private Integer seq;

    /**
     * 默认是1，表示正常状态,0为下线状态
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 简要描述
     */
    @TableField(value = "brief")
    private String brief;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 记录时间
     */
    @TableField(value = "rec_time")
    private Date recTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 品牌首字母
     */
    @TableField(value = "first_char")
    private String firstChar;

    public static final String COL_BRAND_ID = "brand_id";

    public static final String COL_BRAND_NAME = "brand_name";

    public static final String COL_BRAND_PIC = "brand_pic";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_MEMO = "memo";

    public static final String COL_SEQ = "seq";

    public static final String COL_STATUS = "status";

    public static final String COL_BRIEF = "brief";

    public static final String COL_CONTENT = "content";

    public static final String COL_REC_TIME = "rec_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_FIRST_CHAR = "first_char";

    /**
     * 获取主键
     *
     * @return brand_id - 主键
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 设置主键
     *
     * @param brandId 主键
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取品牌名称
     *
     * @return brand_name - 品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置品牌名称
     *
     * @param brandName 品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 获取图片路径
     *
     * @return brand_pic - 图片路径
     */
    public String getBrandPic() {
        return brandPic;
    }

    /**
     * 设置图片路径
     *
     * @param brandPic 图片路径
     */
    public void setBrandPic(String brandPic) {
        this.brandPic = brandPic;
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

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
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
     * 获取默认是1，表示正常状态,0为下线状态
     *
     * @return status - 默认是1，表示正常状态,0为下线状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置默认是1，表示正常状态,0为下线状态
     *
     * @param status 默认是1，表示正常状态,0为下线状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取简要描述
     *
     * @return brief - 简要描述
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置简要描述
     *
     * @param brief 简要描述
     */
    public void setBrief(String brief) {
        this.brief = brief;
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
     * 获取记录时间
     *
     * @return rec_time - 记录时间
     */
    public Date getRecTime() {
        return recTime;
    }

    /**
     * 设置记录时间
     *
     * @param recTime 记录时间
     */
    public void setRecTime(Date recTime) {
        this.recTime = recTime;
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

    /**
     * 获取品牌首字母
     *
     * @return first_char - 品牌首字母
     */
    public String getFirstChar() {
        return firstChar;
    }

    /**
     * 设置品牌首字母
     *
     * @param firstChar 品牌首字母
     */
    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
}