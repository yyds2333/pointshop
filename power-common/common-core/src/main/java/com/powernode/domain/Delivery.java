package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
    * 物流公司
    */
@TableName(value = "delivery")
public class Delivery  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "dvy_id", type = IdType.AUTO)
    private Long dvyId;

    /**
     * 物流公司名称
     */
    @TableField(value = "dvy_name")
    private String dvyName;

    /**
     * 公司主页
     */
    @TableField(value = "company_home_url")
    private String companyHomeUrl;

    /**
     * 建立时间
     */
    @TableField(value = "rec_time")
    private Date recTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time")
    private Date modifyTime;

    /**
     * 物流查询接口
     */
    @TableField(value = "query_url")
    private String queryUrl;

    public static final String COL_DVY_ID = "dvy_id";

    public static final String COL_DVY_NAME = "dvy_name";

    public static final String COL_COMPANY_HOME_URL = "company_home_url";

    public static final String COL_REC_TIME = "rec_time";

    public static final String COL_MODIFY_TIME = "modify_time";

    public static final String COL_QUERY_URL = "query_url";

    /**
     * 获取ID
     *
     * @return dvy_id - ID
     */
    public Long getDvyId() {
        return dvyId;
    }

    /**
     * 设置ID
     *
     * @param dvyId ID
     */
    public void setDvyId(Long dvyId) {
        this.dvyId = dvyId;
    }

    /**
     * 获取物流公司名称
     *
     * @return dvy_name - 物流公司名称
     */
    public String getDvyName() {
        return dvyName;
    }

    /**
     * 设置物流公司名称
     *
     * @param dvyName 物流公司名称
     */
    public void setDvyName(String dvyName) {
        this.dvyName = dvyName;
    }

    /**
     * 获取公司主页
     *
     * @return company_home_url - 公司主页
     */
    public String getCompanyHomeUrl() {
        return companyHomeUrl;
    }

    /**
     * 设置公司主页
     *
     * @param companyHomeUrl 公司主页
     */
    public void setCompanyHomeUrl(String companyHomeUrl) {
        this.companyHomeUrl = companyHomeUrl;
    }

    /**
     * 获取建立时间
     *
     * @return rec_time - 建立时间
     */
    public Date getRecTime() {
        return recTime;
    }

    /**
     * 设置建立时间
     *
     * @param recTime 建立时间
     */
    public void setRecTime(Date recTime) {
        this.recTime = recTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取物流查询接口
     *
     * @return query_url - 物流查询接口
     */
    public String getQueryUrl() {
        return queryUrl;
    }

    /**
     * 设置物流查询接口
     *
     * @param queryUrl 物流查询接口
     */
    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }
}