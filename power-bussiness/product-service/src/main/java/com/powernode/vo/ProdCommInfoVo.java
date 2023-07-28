package com.powernode.vo;

import com.powernode.domain.ProdComm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("评论详情")
public class ProdCommInfoVo extends ProdComm {


    @ApiModelProperty("头像")
    private String pic;


    @ApiModelProperty("昵称")
    private String nickName;

}
