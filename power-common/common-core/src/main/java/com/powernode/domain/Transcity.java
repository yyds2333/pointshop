package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName(value = "transcity")
public class Transcity implements Serializable {
    @TableId(value = "transcity_id", type = IdType.AUTO)
    private Long transcityId;

    /**
     * 运费项id
     */
    @TableField(value = "transfee_id")
    private Long transfeeId;

    /**
     * 城市id
     */
    @TableField(value = "city_id")
    private Long cityId;

    public static final String COL_TRANSCITY_ID = "transcity_id";

    public static final String COL_TRANSFEE_ID = "transfee_id";

    public static final String COL_CITY_ID = "city_id";

    /**
     * @return transcity_id
     */
    public Long getTranscityId() {
        return transcityId;
    }

    /**
     * @param transcityId
     */
    public void setTranscityId(Long transcityId) {
        this.transcityId = transcityId;
    }

    /**
     * 获取运费项id
     *
     * @return transfee_id - 运费项id
     */
    public Long getTransfeeId() {
        return transfeeId;
    }

    /**
     * 设置运费项id
     *
     * @param transfeeId 运费项id
     */
    public void setTransfeeId(Long transfeeId) {
        this.transfeeId = transfeeId;
    }

    /**
     * 获取城市id
     *
     * @return city_id - 城市id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置城市id
     *
     * @param cityId 城市id
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}