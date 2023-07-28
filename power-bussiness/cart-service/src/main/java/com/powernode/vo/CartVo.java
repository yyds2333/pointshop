package com.powernode.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("店铺实体类")
public class CartVo{

    @ApiModelProperty("店铺集合")
    private List<ShopCart> shopCarts;
}
