package com.powernode.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("短信发送实体类")
public class AliSmsModel {

    @ApiModelProperty("手机号码")
    private String phoneNumber;

    @ApiModelProperty("短信签名")
    private String signName;

    @ApiModelProperty("模板代码")
    private String templateCode;

    @ApiModelProperty("模板参数")
    private String templateParam;

    @ApiModelProperty("openId")
    private String openId;
}
