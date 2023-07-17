package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "transcity_free")
public class TranscityFree {
    /**
     * 指定条件包邮城市项id
     */
    @TableId(value = "transcity_free_id", type = IdType.INPUT)
    private Long transcityFreeId;

    /**
     * 指定条件包邮项id
     */
    @TableField(value = "transfee_free_id")
    private Long transfeeFreeId;

    /**
     * 城市id
     */
    @TableField(value = "free_city_id")
    private Long freeCityId;

    public static final String COL_TRANSCITY_FREE_ID = "transcity_free_id";

    public static final String COL_TRANSFEE_FREE_ID = "transfee_free_id";

    public static final String COL_FREE_CITY_ID = "free_city_id";

    /**
     * 获取指定条件包邮城市项id
     *
     * @return transcity_free_id - 指定条件包邮城市项id
     */
    public Long getTranscityFreeId() {
        return transcityFreeId;
    }

    /**
     * 设置指定条件包邮城市项id
     *
     * @param transcityFreeId 指定条件包邮城市项id
     */
    public void setTranscityFreeId(Long transcityFreeId) {
        this.transcityFreeId = transcityFreeId;
    }

    /**
     * 获取指定条件包邮项id
     *
     * @return transfee_free_id - 指定条件包邮项id
     */
    public Long getTransfeeFreeId() {
        return transfeeFreeId;
    }

    /**
     * 设置指定条件包邮项id
     *
     * @param transfeeFreeId 指定条件包邮项id
     */
    public void setTransfeeFreeId(Long transfeeFreeId) {
        this.transfeeFreeId = transfeeFreeId;
    }

    /**
     * 获取城市id
     *
     * @return free_city_id - 城市id
     */
    public Long getFreeCityId() {
        return freeCityId;
    }

    /**
     * 设置城市id
     *
     * @param freeCityId 城市id
     */
    public void setFreeCityId(Long freeCityId) {
        this.freeCityId = freeCityId;
    }
}