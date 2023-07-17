package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
    * 商品分组表
    */
@TableName(value = "prod_tag")
public class ProdTag {
    /**
     * 分组标签id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 分组标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 状态(1为正常,0为删除)
     */
    @TableField(value = "`status`")
    private Boolean status;

    /**
     * 列表样式(0:一列一个,1:一列两个,2:一列三个)
     */
    @TableField(value = "`style`")
    private Integer style;

    /**
     * 排序
     */
    @TableField(value = "seq")
    private Integer seq;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    public static final String COL_ID = "id";

    public static final String COL_TITLE = "title";

    public static final String COL_STATUS = "status";

    public static final String COL_STYLE = "style";

    public static final String COL_SEQ = "seq";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    /**
     * 获取分组标签id
     *
     * @return id - 分组标签id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置分组标签id
     *
     * @param id 分组标签id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分组标题
     *
     * @return title - 分组标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置分组标题
     *
     * @param title 分组标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取状态(1为正常,0为删除)
     *
     * @return status - 状态(1为正常,0为删除)
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态(1为正常,0为删除)
     *
     * @param status 状态(1为正常,0为删除)
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取列表样式(0:一列一个,1:一列两个,2:一列三个)
     *
     * @return style - 列表样式(0:一列一个,1:一列两个,2:一列三个)
     */
    public Integer getStyle() {
        return style;
    }

    /**
     * 设置列表样式(0:一列一个,1:一列两个,2:一列三个)
     *
     * @param style 列表样式(0:一列一个,1:一列两个,2:一列三个)
     */
    public void setStyle(Integer style) {
        this.style = style;
    }

    /**
     * 获取排序
     *
     * @return seq - 排序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置排序
     *
     * @param seq 排序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
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

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}