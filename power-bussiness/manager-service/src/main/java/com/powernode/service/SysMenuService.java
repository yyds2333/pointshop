package com.powernode.service;

import com.powernode.domain.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.powernode.vo.MenuAndAuthVo;

import java.util.List;

public interface SysMenuService extends IService<SysMenu>{

    List<SysMenu> getMenuByUserId(Long userId);

}
