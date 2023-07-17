package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
    * 产品类目
    */
@TableName(value = "category")
public class Category {
    /**
     * 类目ID
     */
    @TableId(value = "category_id", type = IdType.INPUT)
    private Long categoryId;

    /**
     * 父节点
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 产品类目名称
     */
    @TableField(value = "category_name")
    private String categoryName;

    /**
     * 类目图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 类目的显示图片
     */
    @TableField(value = "pic")
    private String pic;

    /**
     * 排序
     */
    @TableField(value = "seq")
    private Integer seq;

    /**
     * 默认是1，表示正常状态,0为下线状态
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 记录时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_CATEGORY_NAME = "category_name";

    public static final String COL_ICON = "icon";

    public static final String COL_PIC = "pic";

    public static final String COL_SEQ = "seq";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    /**
     * 获取类目ID
     *
     * @return category_id - 类目ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类目ID
     *
     * @param categoryId 类目ID
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取父节点
     *
     * @return parent_id - 父节点
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父节点
     *
     * @param parentId 父节点
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取产品类目名称
     *
     * @return category_name - 产品类目名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置产品类目名称
     *
     * @param categoryName 产品类目名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 获取类目图标
     *
     * @return icon - 类目图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置类目图标
     *
     * @param icon 类目图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取类目的显示图片
     *
     * @return pic - 类目的显示图片
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置类目的显示图片
     *
     * @param pic 类目的显示图片
     */
    public void setPic(String pic) {
        this.pic = pic;
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
     * 获取记录时间
     *
     * @return create_time - 记录时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置记录时间
     *
     * @param createTime 记录时间
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