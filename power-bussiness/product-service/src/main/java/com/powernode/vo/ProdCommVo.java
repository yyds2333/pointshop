package com.powernode.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("评论总览实体类")
public class ProdCommVo {

    private BigDecimal positiveRating = BigDecimal.ZERO;
    private Integer number;
    private Integer praiseNumber;
    private Integer secondaryNumber;
    private Integer negativeNumber;
    private Integer picNumber;

}