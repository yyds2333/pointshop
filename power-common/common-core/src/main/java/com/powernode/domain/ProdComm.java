package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
    * 商品评论
    */
@TableName(value = "prod_comm")
public class ProdComm {
    /**
     * ID
     */
    @TableId(value = "prod_comm_id", type = IdType.INPUT)
    private Long prodCommId;

    /**
     * 商品ID
     */
    @TableField(value = "prod_id")
    private Long prodId;

    /**
     * 商品的名字
     */
    @TableField(value = "prod_name")
    private String prodName;

    /**
     * 订单项ID
     */
    @TableField(value = "order_item_id")
    private Long orderItemId;

    /**
     * 评论用户ID
     */
    @TableField(value = "open_id")
    private String openId;

    /**
     * 评论内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 掌柜回复
     */
    @TableField(value = "reply_content")
    private String replyContent;

    /**
     * 记录时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 回复时间
     */
    @TableField(value = "reply_time")
    private Date replyTime;

    /**
     * 是否回复 0:未回复  1:已回复
     */
    @TableField(value = "reply_sts")
    private Integer replySts;

    /**
     * IP来源
     */
    @TableField(value = "postip")
    private String postip;

    /**
     * 得分，0-5分
     */
    @TableField(value = "score")
    private Byte score;

    /**
     * 有用的计数
     */
    @TableField(value = "useful_counts")
    private Integer usefulCounts;

    /**
     * 晒图的json字符串
     */
    @TableField(value = "pics")
    private String pics;

    /**
     * 是否匿名(1:是  0:否)
     */
    @TableField(value = "is_anonymous")
    private Integer isAnonymous;

    /**
     * 是否显示，1:为显示，0:待审核， -1：不通过审核，不显示。 如果需要审核评论，则是0,，否则1
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 评价(0好评 1中评 2差评)
     */
    @TableField(value = "evaluate")
    private Byte evaluate;

    /**
     * 店铺
     */
    @TableField(value = "shop_id")
    private Long shopId;

    public static final String COL_PROD_COMM_ID = "prod_comm_id";

    public static final String COL_PROD_ID = "prod_id";

    public static final String COL_PROD_NAME = "prod_name";

    public static final String COL_ORDER_ITEM_ID = "order_item_id";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_CONTENT = "content";

    public static final String COL_REPLY_CONTENT = "reply_content";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_REPLY_TIME = "reply_time";

    public static final String COL_REPLY_STS = "reply_sts";

    public static final String COL_POSTIP = "postip";

    public static final String COL_SCORE = "score";

    public static final String COL_USEFUL_COUNTS = "useful_counts";

    public static final String COL_PICS = "pics";

    public static final String COL_IS_ANONYMOUS = "is_anonymous";

    public static final String COL_STATUS = "status";

    public static final String COL_EVALUATE = "evaluate";

    public static final String COL_SHOP_ID = "shop_id";

    /**
     * 获取ID
     *
     * @return prod_comm_id - ID
     */
    public Long getProdCommId() {
        return prodCommId;
    }

    /**
     * 设置ID
     *
     * @param prodCommId ID
     */
    public void setProdCommId(Long prodCommId) {
        this.prodCommId = prodCommId;
    }

    /**
     * 获取商品ID
     *
     * @return prod_id - 商品ID
     */
    public Long getProdId() {
        return prodId;
    }

    /**
     * 设置商品ID
     *
     * @param prodId 商品ID
     */
    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    /**
     * 获取商品的名字
     *
     * @return prod_name - 商品的名字
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * 设置商品的名字
     *
     * @param prodName 商品的名字
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    /**
     * 获取订单项ID
     *
     * @return order_item_id - 订单项ID
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     * 设置订单项ID
     *
     * @param orderItemId 订单项ID
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * 获取评论用户ID
     *
     * @return open_id - 评论用户ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置评论用户ID
     *
     * @param openId 评论用户ID
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取掌柜回复
     *
     * @return reply_content - 掌柜回复
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * 设置掌柜回复
     *
     * @param replyContent 掌柜回复
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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
     * 获取回复时间
     *
     * @return reply_time - 回复时间
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * 设置回复时间
     *
     * @param replyTime 回复时间
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * 获取是否回复 0:未回复  1:已回复
     *
     * @return reply_sts - 是否回复 0:未回复  1:已回复
     */
    public Integer getReplySts() {
        return replySts;
    }

    /**
     * 设置是否回复 0:未回复  1:已回复
     *
     * @param replySts 是否回复 0:未回复  1:已回复
     */
    public void setReplySts(Integer replySts) {
        this.replySts = replySts;
    }

    /**
     * 获取IP来源
     *
     * @return postip - IP来源
     */
    public String getPostip() {
        return postip;
    }

    /**
     * 设置IP来源
     *
     * @param postip IP来源
     */
    public void setPostip(String postip) {
        this.postip = postip;
    }

    /**
     * 获取得分，0-5分
     *
     * @return score - 得分，0-5分
     */
    public Byte getScore() {
        return score;
    }

    /**
     * 设置得分，0-5分
     *
     * @param score 得分，0-5分
     */
    public void setScore(Byte score) {
        this.score = score;
    }

    /**
     * 获取有用的计数
     *
     * @return useful_counts - 有用的计数
     */
    public Integer getUsefulCounts() {
        return usefulCounts;
    }

    /**
     * 设置有用的计数
     *
     * @param usefulCounts 有用的计数
     */
    public void setUsefulCounts(Integer usefulCounts) {
        this.usefulCounts = usefulCounts;
    }

    /**
     * 获取晒图的json字符串
     *
     * @return pics - 晒图的json字符串
     */
    public String getPics() {
        return pics;
    }

    /**
     * 设置晒图的json字符串
     *
     * @param pics 晒图的json字符串
     */
    public void setPics(String pics) {
        this.pics = pics;
    }

    /**
     * 获取是否匿名(1:是  0:否)
     *
     * @return is_anonymous - 是否匿名(1:是  0:否)
     */
    public Integer getIsAnonymous() {
        return isAnonymous;
    }

    /**
     * 设置是否匿名(1:是  0:否)
     *
     * @param isAnonymous 是否匿名(1:是  0:否)
     */
    public void setIsAnonymous(Integer isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    /**
     * 获取是否显示，1:为显示，0:待审核， -1：不通过审核，不显示。 如果需要审核评论，则是0,，否则1
     *
     * @return status - 是否显示，1:为显示，0:待审核， -1：不通过审核，不显示。 如果需要审核评论，则是0,，否则1
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否显示，1:为显示，0:待审核， -1：不通过审核，不显示。 如果需要审核评论，则是0,，否则1
     *
     * @param status 是否显示，1:为显示，0:待审核， -1：不通过审核，不显示。 如果需要审核评论，则是0,，否则1
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取评价(0好评 1中评 2差评)
     *
     * @return evaluate - 评价(0好评 1中评 2差评)
     */
    public Byte getEvaluate() {
        return evaluate;
    }

    /**
     * 设置评价(0好评 1中评 2差评)
     *
     * @param evaluate 评价(0好评 1中评 2差评)
     */
    public void setEvaluate(Byte evaluate) {
        this.evaluate = evaluate;
    }

    /**
     * 获取店铺
     *
     * @return shop_id - 店铺
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置店铺
     *
     * @param shopId 店铺
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}