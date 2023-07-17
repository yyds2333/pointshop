package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "area")
public class Area {
    @TableId(value = "area_id", type = IdType.INPUT)
    private Long areaId;

    @TableField(value = "area_name")
    private String areaName;

    @TableField(value = "parent_id")
    private Long parentId;

    @TableField(value = "`level`")
    private Integer level;

    public static final String COL_AREA_ID = "area_id";

    public static final String COL_AREA_NAME = "area_name";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_LEVEL = "level";

    /**
     * @return area_id
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * @param areaId
     */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    /**
     * @return area_name
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * @param areaName
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * @return parent_id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}