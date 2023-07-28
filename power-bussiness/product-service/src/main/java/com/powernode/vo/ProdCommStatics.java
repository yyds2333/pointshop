package com.powernode.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("统计商品评价的实体类")
public class ProdCommStatics {
    @ApiModelProperty("商品ID")
    private Long prodId;
    @ApiModelProperty("总评数")
    private Integer allCount;
    @ApiModelProperty("好评数")
    private Integer goodCount;
}
