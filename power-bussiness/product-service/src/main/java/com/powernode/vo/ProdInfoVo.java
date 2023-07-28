package com.powernode.vo;

import com.powernode.domain.Prod;
import com.powernode.domain.Sku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("商品详情扩展")
public class ProdInfoVo extends Prod {
    @ApiModelProperty("SkuList集合")
    private List<Sku> skuList;
}
