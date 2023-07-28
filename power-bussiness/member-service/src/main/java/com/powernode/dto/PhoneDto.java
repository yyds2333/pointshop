package com.powernode.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("发送验证码实体类")
public class PhoneDto {

    @ApiModelProperty("前台接收的电话号码")
    private String phonenum;

    @ApiModelProperty("前台传过来的验证码")
    private String code;
}
