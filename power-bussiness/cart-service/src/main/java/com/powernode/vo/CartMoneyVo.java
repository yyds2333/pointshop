package com.powernode.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("购物车金额实体类")
public class CartMoneyVo {
    @ApiModelProperty("最终金额")
    private BigDecimal finalMoney;
    @ApiModelProperty("总金额")
    private BigDecimal totalMoney;
    @ApiModelProperty("优惠金额")
    private BigDecimal subtractMoney;
    @ApiModelProperty("运费")
    private BigDecimal transMoney;
}
