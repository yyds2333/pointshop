package com.powernode.dto;


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
@ApiModel("商品的传输对象类")
public class ProdDto extends Prod {

    /**
     * 商品每个规格的详情列表
     */
    @ApiModelProperty("商品的每个规格的详情集合sku")
    private List<Sku> skuList;

    /**
     * 商品标签的列表
     */
    @ApiModelProperty("商品参与活动的标签id列表")
    private List<Long> tagList;

    /**
     * 配送模式
     */
    @ApiModelProperty("配送模式")
    private DeliveryModeVo deliveryModeVo;


    /**
     * 内部类配送模式
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel("配送模式实体内部类")
    public  static  class DeliveryModeVo {
        @ApiModelProperty("商家配送")
        private boolean hasShopDelivery;


        @ApiModelProperty("用户自提")
        private boolean hasUserPicUp;

    }
}
