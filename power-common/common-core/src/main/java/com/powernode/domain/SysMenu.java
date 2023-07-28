package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
    * 菜单管理
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "sys_menu")
public class SysMenu  implements Serializable {
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    /**
     * 父菜单ID，一级菜单为0
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 菜单名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 菜单URL
     */
    @TableField(value = "url")
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    @TableField(value = "perms")
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    @TableField(value = "`type`")
    private Integer type;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 子集合
     */
    @TableField(exist = false)
    private List<SysMenu> list;

//    public static final String COL_MENU_ID = "menu_id";
//
//    public static final String COL_PARENT_ID = "parent_id";
//
//    public static final String COL_NAME = "name";
//
//    public static final String COL_URL = "url";
//
//    public static final String COL_PERMS = "perms";
//
//    public static final String COL_TYPE = "type";
//
//    public static final String COL_ICON = "icon";
//
//    public static final String COL_ORDER_NUM = "order_num";
//
//    /**
//     * @return menu_id
//     */
//    public Long getMenuId() {
//        return menuId;
//    }
//
//    /**
//     * @param menuId
//     */
//    public void setMenuId(Long menuId) {
//        this.menuId = menuId;
//    }
//
//    /**
//     * 获取父菜单ID，一级菜单为0
//     *
//     * @return parent_id - 父菜单ID，一级菜单为0
//     */
//    public Long getParentId() {
//        return parentId;
//    }
//
//    /**
//     * 设置父菜单ID，一级菜单为0
//     *
//     * @param parentId 父菜单ID，一级菜单为0
//     */
//    public void setParentId(Long parentId) {
//        this.parentId = parentId;
//    }
//
//    /**
//     * 获取菜单名称
//     *
//     * @return name - 菜单名称
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * 设置菜单名称
//     *
//     * @param name 菜单名称
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /**
//     * 获取菜单URL
//     *
//     * @return url - 菜单URL
//     */
//    public String getUrl() {
//        return url;
//    }
//
//    /**
//     * 设置菜单URL
//     *
//     * @param url 菜单URL
//     */
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    /**
//     * 获取授权(多个用逗号分隔，如：user:list,user:create)
//     *
//     * @return perms - 授权(多个用逗号分隔，如：user:list,user:create)
//     */
//    public String getPerms() {
//        return perms;
//    }
//
//    /**
//     * 设置授权(多个用逗号分隔，如：user:list,user:create)
//     *
//     * @param perms 授权(多个用逗号分隔，如：user:list,user:create)
//     */
//    public void setPerms(String perms) {
//        this.perms = perms;
//    }
//
//    /**
//     * 获取类型   0：目录   1：菜单   2：按钮
//     *
//     * @return type - 类型   0：目录   1：菜单   2：按钮
//     */
//    public Integer getType() {
//        return type;
//    }
//
//    /**
//     * 设置类型   0：目录   1：菜单   2：按钮
//     *
//     * @param type 类型   0：目录   1：菜单   2：按钮
//     */
//    public void setType(Integer type) {
//        this.type = type;
//    }
//
//    /**
//     * 获取菜单图标
//     *
//     * @return icon - 菜单图标
//     */
//    public String getIcon() {
//        return icon;
//    }
//
//    /**
//     * 设置菜单图标
//     *
//     * @param icon 菜单图标
//     */
//    public void setIcon(String icon) {
//        this.icon = icon;
//    }
//
//    /**
//     * 获取排序
//     *
//     * @return order_num - 排序
//     */
//    public Integer getOrderNum() {
//        return orderNum;
//    }
//
//    /**
//     * 设置排序
//     *
//     * @param orderNum 排序
//     */
//    public void setOrderNum(Integer orderNum) {
//        this.orderNum = orderNum;
//    }
}