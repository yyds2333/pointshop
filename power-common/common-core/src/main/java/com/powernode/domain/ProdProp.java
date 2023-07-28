package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "prod_prop")
public class ProdProp  implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 属性id
     */
    @TableId(value = "prop_id", type = IdType.AUTO)
    private Long propId;

    /**
     * 属性名称
     */
    @TableField(value = "prop_name")
    private String propName;

    /**
     * ProdPropRule 1:销售属性(规格); 2:参数属性;
     */
    @TableField(value = "`rule`")
    private Byte rule;

    /**
     * 店铺id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    @TableField(exist = false)
    private List<ProdPropValue> prodPropValues = new ArrayList<>();

    public static final String COL_PROP_ID = "prop_id";

    public static final String COL_PROP_NAME = "prop_name";

    public static final String COL_RULE = "rule";

    public static final String COL_SHOP_ID = "shop_id";


}