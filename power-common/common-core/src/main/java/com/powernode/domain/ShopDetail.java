package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;

@TableName(value = "shop_detail")
public class ShopDetail {
    /**
     * 店铺id
     */
    @TableId(value = "shop_id", type = IdType.INPUT)
    private Long shopId;

    /**
     * 店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一
     */
    @TableField(value = "shop_name")
    private String shopName;

    /**
     * 店长用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 店铺类型
     */
    @TableField(value = "shop_type")
    private Byte shopType;

    /**
     * 店铺简介(可修改)
     */
    @TableField(value = "intro")
    private String intro;

    /**
     * 店铺公告(可修改)
     */
    @TableField(value = "shop_notice")
    private String shopNotice;

    /**
     * 店铺行业(餐饮、生鲜果蔬、鲜花等)
     */
    @TableField(value = "shop_industry")
    private Byte shopIndustry;

    /**
     * 店长
     */
    @TableField(value = "shop_owner")
    private String shopOwner;

    /**
     * 店铺绑定的手机(登录账号：唯一)
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 店铺联系电话
     */
    @TableField(value = "tel")
    private String tel;

    /**
     * 店铺所在纬度(可修改)
     */
    @TableField(value = "shop_lat")
    private String shopLat;

    /**
     * 店铺所在经度(可修改)
     */
    @TableField(value = "shop_lng")
    private String shopLng;

    /**
     * 店铺详细地址
     */
    @TableField(value = "shop_address")
    private String shopAddress;

    /**
     * 店铺所在省份（描述）
     */
    @TableField(value = "province")
    private String province;

    /**
     * 店铺所在城市（描述）
     */
    @TableField(value = "city")
    private String city;

    /**
     * 店铺所在区域（描述）
     */
    @TableField(value = "area")
    private String area;

    /**
     * 店铺省市区代码，用于回显
     */
    @TableField(value = "pca_code")
    private String pcaCode;

    /**
     * 店铺logo(可修改)
     */
    @TableField(value = "shop_logo")
    private String shopLogo;

    /**
     * 店铺相册
     */
    @TableField(value = "shop_photos")
    private String shopPhotos;

    /**
     * 每天营业时间段(可修改)
     */
    @TableField(value = "open_time")
    private String openTime;

    /**
     * 店铺状态(-1:未开通 0: 停业中 1:营业中)，可修改
     */
    @TableField(value = "shop_status")
    private Byte shopStatus;

    /**
     * 0:商家承担运费; 1:买家承担运费
     */
    @TableField(value = "transport_type")
    private Byte transportType;

    /**
     * 固定运费
     */
    @TableField(value = "fixed_freight")
    private BigDecimal fixedFreight;

    /**
     * 满X包邮
     */
    @TableField(value = "full_free_shipping")
    private BigDecimal fullFreeShipping;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 分销开关(0:开启 1:关闭)
     */
    @TableField(value = "is_distribution")
    private Byte isDistribution;

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_SHOP_NAME = "shop_name";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_SHOP_TYPE = "shop_type";

    public static final String COL_INTRO = "intro";

    public static final String COL_SHOP_NOTICE = "shop_notice";

    public static final String COL_SHOP_INDUSTRY = "shop_industry";

    public static final String COL_SHOP_OWNER = "shop_owner";

    public static final String COL_MOBILE = "mobile";

    public static final String COL_TEL = "tel";

    public static final String COL_SHOP_LAT = "shop_lat";

    public static final String COL_SHOP_LNG = "shop_lng";

    public static final String COL_SHOP_ADDRESS = "shop_address";

    public static final String COL_PROVINCE = "province";

    public static final String COL_CITY = "city";

    public static final String COL_AREA = "area";

    public static final String COL_PCA_CODE = "pca_code";

    public static final String COL_SHOP_LOGO = "shop_logo";

    public static final String COL_SHOP_PHOTOS = "shop_photos";

    public static final String COL_OPEN_TIME = "open_time";

    public static final String COL_SHOP_STATUS = "shop_status";

    public static final String COL_TRANSPORT_TYPE = "transport_type";

    public static final String COL_FIXED_FREIGHT = "fixed_freight";

    public static final String COL_FULL_FREE_SHIPPING = "full_free_shipping";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_IS_DISTRIBUTION = "is_distribution";

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

    /**
     * 获取店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一
     *
     * @return shop_name - 店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 设置店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一
     *
     * @param shopName 店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * 获取店长用户id
     *
     * @return user_id - 店长用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置店长用户id
     *
     * @param userId 店长用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取店铺类型
     *
     * @return shop_type - 店铺类型
     */
    public Byte getShopType() {
        return shopType;
    }

    /**
     * 设置店铺类型
     *
     * @param shopType 店铺类型
     */
    public void setShopType(Byte shopType) {
        this.shopType = shopType;
    }

    /**
     * 获取店铺简介(可修改)
     *
     * @return intro - 店铺简介(可修改)
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置店铺简介(可修改)
     *
     * @param intro 店铺简介(可修改)
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * 获取店铺公告(可修改)
     *
     * @return shop_notice - 店铺公告(可修改)
     */
    public String getShopNotice() {
        return shopNotice;
    }

    /**
     * 设置店铺公告(可修改)
     *
     * @param shopNotice 店铺公告(可修改)
     */
    public void setShopNotice(String shopNotice) {
        this.shopNotice = shopNotice;
    }

    /**
     * 获取店铺行业(餐饮、生鲜果蔬、鲜花等)
     *
     * @return shop_industry - 店铺行业(餐饮、生鲜果蔬、鲜花等)
     */
    public Byte getShopIndustry() {
        return shopIndustry;
    }

    /**
     * 设置店铺行业(餐饮、生鲜果蔬、鲜花等)
     *
     * @param shopIndustry 店铺行业(餐饮、生鲜果蔬、鲜花等)
     */
    public void setShopIndustry(Byte shopIndustry) {
        this.shopIndustry = shopIndustry;
    }

    /**
     * 获取店长
     *
     * @return shop_owner - 店长
     */
    public String getShopOwner() {
        return shopOwner;
    }

    /**
     * 设置店长
     *
     * @param shopOwner 店长
     */
    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    /**
     * 获取店铺绑定的手机(登录账号：唯一)
     *
     * @return mobile - 店铺绑定的手机(登录账号：唯一)
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置店铺绑定的手机(登录账号：唯一)
     *
     * @param mobile 店铺绑定的手机(登录账号：唯一)
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取店铺联系电话
     *
     * @return tel - 店铺联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置店铺联系电话
     *
     * @param tel 店铺联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取店铺所在纬度(可修改)
     *
     * @return shop_lat - 店铺所在纬度(可修改)
     */
    public String getShopLat() {
        return shopLat;
    }

    /**
     * 设置店铺所在纬度(可修改)
     *
     * @param shopLat 店铺所在纬度(可修改)
     */
    public void setShopLat(String shopLat) {
        this.shopLat = shopLat;
    }

    /**
     * 获取店铺所在经度(可修改)
     *
     * @return shop_lng - 店铺所在经度(可修改)
     */
    public String getShopLng() {
        return shopLng;
    }

    /**
     * 设置店铺所在经度(可修改)
     *
     * @param shopLng 店铺所在经度(可修改)
     */
    public void setShopLng(String shopLng) {
        this.shopLng = shopLng;
    }

    /**
     * 获取店铺详细地址
     *
     * @return shop_address - 店铺详细地址
     */
    public String getShopAddress() {
        return shopAddress;
    }

    /**
     * 设置店铺详细地址
     *
     * @param shopAddress 店铺详细地址
     */
    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    /**
     * 获取店铺所在省份（描述）
     *
     * @return province - 店铺所在省份（描述）
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置店铺所在省份（描述）
     *
     * @param province 店铺所在省份（描述）
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取店铺所在城市（描述）
     *
     * @return city - 店铺所在城市（描述）
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置店铺所在城市（描述）
     *
     * @param city 店铺所在城市（描述）
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取店铺所在区域（描述）
     *
     * @return area - 店铺所在区域（描述）
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置店铺所在区域（描述）
     *
     * @param area 店铺所在区域（描述）
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取店铺省市区代码，用于回显
     *
     * @return pca_code - 店铺省市区代码，用于回显
     */
    public String getPcaCode() {
        return pcaCode;
    }

    /**
     * 设置店铺省市区代码，用于回显
     *
     * @param pcaCode 店铺省市区代码，用于回显
     */
    public void setPcaCode(String pcaCode) {
        this.pcaCode = pcaCode;
    }

    /**
     * 获取店铺logo(可修改)
     *
     * @return shop_logo - 店铺logo(可修改)
     */
    public String getShopLogo() {
        return shopLogo;
    }

    /**
     * 设置店铺logo(可修改)
     *
     * @param shopLogo 店铺logo(可修改)
     */
    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    /**
     * 获取店铺相册
     *
     * @return shop_photos - 店铺相册
     */
    public String getShopPhotos() {
        return shopPhotos;
    }

    /**
     * 设置店铺相册
     *
     * @param shopPhotos 店铺相册
     */
    public void setShopPhotos(String shopPhotos) {
        this.shopPhotos = shopPhotos;
    }

    /**
     * 获取每天营业时间段(可修改)
     *
     * @return open_time - 每天营业时间段(可修改)
     */
    public String getOpenTime() {
        return openTime;
    }

    /**
     * 设置每天营业时间段(可修改)
     *
     * @param openTime 每天营业时间段(可修改)
     */
    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    /**
     * 获取店铺状态(-1:未开通 0: 停业中 1:营业中)，可修改
     *
     * @return shop_status - 店铺状态(-1:未开通 0: 停业中 1:营业中)，可修改
     */
    public Byte getShopStatus() {
        return shopStatus;
    }

    /**
     * 设置店铺状态(-1:未开通 0: 停业中 1:营业中)，可修改
     *
     * @param shopStatus 店铺状态(-1:未开通 0: 停业中 1:营业中)，可修改
     */
    public void setShopStatus(Byte shopStatus) {
        this.shopStatus = shopStatus;
    }

    /**
     * 获取0:商家承担运费; 1:买家承担运费
     *
     * @return transport_type - 0:商家承担运费; 1:买家承担运费
     */
    public Byte getTransportType() {
        return transportType;
    }

    /**
     * 设置0:商家承担运费; 1:买家承担运费
     *
     * @param transportType 0:商家承担运费; 1:买家承担运费
     */
    public void setTransportType(Byte transportType) {
        this.transportType = transportType;
    }

    /**
     * 获取固定运费
     *
     * @return fixed_freight - 固定运费
     */
    public BigDecimal getFixedFreight() {
        return fixedFreight;
    }

    /**
     * 设置固定运费
     *
     * @param fixedFreight 固定运费
     */
    public void setFixedFreight(BigDecimal fixedFreight) {
        this.fixedFreight = fixedFreight;
    }

    /**
     * 获取满X包邮
     *
     * @return full_free_shipping - 满X包邮
     */
    public BigDecimal getFullFreeShipping() {
        return fullFreeShipping;
    }

    /**
     * 设置满X包邮
     *
     * @param fullFreeShipping 满X包邮
     */
    public void setFullFreeShipping(BigDecimal fullFreeShipping) {
        this.fullFreeShipping = fullFreeShipping;
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
     * 获取分销开关(0:开启 1:关闭)
     *
     * @return is_distribution - 分销开关(0:开启 1:关闭)
     */
    public Byte getIsDistribution() {
        return isDistribution;
    }

    /**
     * 设置分销开关(0:开启 1:关闭)
     *
     * @param isDistribution 分销开关(0:开启 1:关闭)
     */
    public void setIsDistribution(Byte isDistribution) {
        this.isDistribution = isDistribution;
    }
}