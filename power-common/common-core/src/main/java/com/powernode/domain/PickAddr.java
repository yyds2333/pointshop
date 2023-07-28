package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
    * 用户配送地址
    */
@TableName(value = "pick_addr")
public class PickAddr  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "addr_id", type = IdType.AUTO)
    private Long addrId;

    /**
     * 自提点名称
     */
    @TableField(value = "addr_name")
    private String addrName;

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
     * 省份ID
     */
    @TableField(value = "province_id")
    private Long provinceId;

    /**
     * 省份
     */
    @TableField(value = "province")
    private String province;

    /**
     * 城市ID
     */
    @TableField(value = "city_id")
    private Long cityId;

    /**
     * 城市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 区/县ID
     */
    @TableField(value = "area_id")
    private Long areaId;

    /**
     * 区/县
     */
    @TableField(value = "area")
    private String area;

    /**
     * 店铺id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    public static final String COL_ADDR_ID = "addr_id";

    public static final String COL_ADDR_NAME = "addr_name";

    public static final String COL_ADDR = "addr";

    public static final String COL_MOBILE = "mobile";

    public static final String COL_PROVINCE_ID = "province_id";

    public static final String COL_PROVINCE = "province";

    public static final String COL_CITY_ID = "city_id";

    public static final String COL_CITY = "city";

    public static final String COL_AREA_ID = "area_id";

    public static final String COL_AREA = "area";

    public static final String COL_SHOP_ID = "shop_id";

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
     * 获取自提点名称
     *
     * @return addr_name - 自提点名称
     */
    public String getAddrName() {
        return addrName;
    }

    /**
     * 设置自提点名称
     *
     * @param addrName 自提点名称
     */
    public void setAddrName(String addrName) {
        this.addrName = addrName;
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
     * 获取省份ID
     *
     * @return province_id - 省份ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省份ID
     *
     * @param provinceId 省份ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
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
     * 获取区/县ID
     *
     * @return area_id - 区/县ID
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * 设置区/县ID
     *
     * @param areaId 区/县ID
     */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取区/县
     *
     * @return area - 区/县
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区/县
     *
     * @param area 区/县
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取店铺id
     *
     * @return shop_id - 店铺id
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置店铺id
     *
     * @param shopId 店铺id
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}