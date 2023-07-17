package com.powernode.vo;


import com.powernode.domain.SysMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("前端所需的 菜单 及 权限集合 对应的实体类")
public class MenuAndAuthVo {

    // 菜单集合
    @ApiModelProperty("菜单集合")
    private List<SysMenu> menuList;

    // 权限集合
    @ApiModelProperty("权限集合")
    private List<String> authorities;


}
