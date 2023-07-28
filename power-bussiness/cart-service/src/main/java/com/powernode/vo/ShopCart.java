package com.powernode.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("店铺购物车")
public class ShopCart {

    @ApiModelProperty("店铺id")
    private Long shopId;

    @ApiModelProperty("店铺商品列表s")
    private List<CartIem> shopCartItem;
}
