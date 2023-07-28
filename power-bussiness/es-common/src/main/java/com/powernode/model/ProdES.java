package com.powernode.model;

import com.powernode.constant.ESConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

// es实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = ESConstant.PROD_ES_INDEX) // 库名，索引名
@ApiModel("ES商品实现类")
@Setting(shards = 3,replicas = 2,refreshInterval = "2s") // 分片，副本，刷新时间
public class ProdES {

    @ApiModelProperty("商品id")
    @Field(type = FieldType.Long)
    private Long prodId;

    @ApiModelProperty("商品名")
    @Field(type = FieldType.Text,searchAnalyzer = "ik_max_word",analyzer = "ik_max_word")
    private String prodName;

    @ApiModelProperty("店铺ID")
    @Field(type = FieldType.Long)
    private Long shopId;

    @ApiModelProperty("商品价格")
    @Field(type = FieldType.Double)
    private BigDecimal price;

    @ApiModelProperty("商品卖点")
    //                          searchAnalyzer 分词器            analyzer   粗细粒度
    @Field(type = FieldType.Text,searchAnalyzer = "ik_max_word",analyzer = "ik_max_word")
    private String brief;

    @ApiModelProperty("商品图片")
    @Field(type = FieldType.Text)
    private String pic;

    @ApiModelProperty("类别ID")
    @Field(type = FieldType.Long)
    private Long categoryId;

    @ApiModelProperty("库存量")
    @Field(type = FieldType.Integer)
    private Integer soldNum;

    @ApiModelProperty("销量")
    @Field(type = FieldType.Integer)
    private Integer totalStocks;

    @ApiModelProperty("出库日期")
    @Field(type = FieldType.Date)
    private Date putawayTime;


    @ApiModelProperty("标签分组")
    @Field(type = FieldType.Long)
    private List<Long> tagList;


    @ApiModelProperty("好评数")
    @Field(type = FieldType.Long)
    private Long priseNumber = 0L;


    @ApiModelProperty("好评率")
    @Field(type = FieldType.Double)
    private BigDecimal positiveRating = BigDecimal.ZERO;

    private Integer status;
}
