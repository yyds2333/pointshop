package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
    * 用户配送地址
    */
@TableName(value = "member_addr")
public class MemberAddr  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "addr_id", type = IdType.AUTO)
    private Long addrId;

    /**
     * 用户ID
     */
    @TableField(value = "open_id")
    private String openId;

    /**
     * 收货人
     */
    @TableField(value = "receiver")
    private String receiver;

    /**
     * 省ID
     */
    @TableField(value = "province_id")
    private Long provinceId;

    /**
     * 省
     */
    @TableField(value = "province")
    private String province;

    /**
     * 城市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 城市ID
     */
    @TableField(value = "city_id")
    private Long cityId;

    /**
     * 区
     */
    @TableField(value = "area")
    private String area;

    /**
     * 区ID
     */
    @TableField(value = "area_id")
    private Long areaId;

    /**
     * 邮编
     */
    @TableField(value = "post_code")
    private String postCode;

    /**
     * 地址
     */
    @TableField(value = "addr")
    private String addr;

    /**
     * 手机
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 状态,1正常，0无效
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 是否默认地址 1是
     */
    @TableField(value = "common_addr")
    private Integer commonAddr;

    /**
     * 建立时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    public static final String COL_ADDR_ID = "addr_id";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_RECEIVER = "receiver";

    public static final String COL_PROVINCE_ID = "province_id";

    public static final String COL_PROVINCE = "province";

    public static final String COL_CITY = "city";

    public static final String COL_CITY_ID = "city_id";

    public static final String COL_AREA = "area";

    public static final String COL_AREA_ID = "area_id";

    public static final String COL_POST_CODE = "post_code";

    public static final String COL_ADDR = "addr";

    public static final String COL_MOBILE = "mobile";

    public static final String COL_STATUS = "status";

    public static final String COL_COMMON_ADDR = "common_addr";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    /**
     * 获取ID
     *
     * @return addr_id - ID
     */
    public Long getAddrId() {
        return addrId;
    }

    /**
     * 设置ID
     *
     * @param addrId ID
     */
    public void setAddrId(Long addrId) {
        this.addrId = addrId;
    }

    /**
     * 获取用户ID
     *
     * @return open_id - 用户ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置用户ID
     *
     * @param openId 用户ID
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取收货人
     *
     * @return receiver - 收货人
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 设置收货人
     *
     * @param receiver 收货人
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 获取省ID
     *
     * @return province_id - 省ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省ID
     *
     * @param provinceId 省ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取城市ID
     *
     * @return city_id - 城市ID
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置城市ID
     *
     * @param cityId 城市ID
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取区
     *
     * @return area - 区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区
     *
     * @param area 区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取区ID
     *
     * @return area_id - 区ID
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * 设置区ID
     *
     * @param areaId 区ID
     */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取邮编
     *
     * @return post_code - 邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 设置邮编
     *
     * @param postCode 邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * 获取地址
     *
     * @return addr - 地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置地址
     *
     * @param addr 地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取状态,1正常，0无效
     *
     * @return status - 状态,1正常，0无效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态,1正常，0无效
     *
     * @param status 状态,1正常，0无效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取是否默认地址 1是
     *
     * @return common_addr - 是否默认地址 1是
     */
    public Integer getCommonAddr() {
        return commonAddr;
    }

    /**
     * 设置是否默认地址 1是
     *
     * @param commonAddr 是否默认地址 1是
     */
    public void setCommonAddr(Integer commonAddr) {
        this.commonAddr = commonAddr;
    }

    /**
     * 获取建立时间
     *
     * @return create_time - 建立时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置建立时间
     *
     * @param createTime 建立时间
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