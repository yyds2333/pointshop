package com.powernode.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("购物车实体类条目")
public class CartIem {
    @ApiModelProperty("购物车ID")
    private Long basketId;
    @ApiModelProperty("是否选中")
    private Boolean checked;
    @ApiModelProperty("商品id")
    private Long prodId;
    @ApiModelProperty("商品名称")
    private String prodName;
    @ApiModelProperty("skuId")
    private Long skuId;
    @ApiModelProperty("sku名称")
    private String skuName;
    @ApiModelProperty("商品主图")
    private String pic;
    @ApiModelProperty("商品价格")
    private BigDecimal price;
    @ApiModelProperty("商品数量")
    private Integer prodCount;
}
