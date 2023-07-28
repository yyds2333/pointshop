package com.powernode.service;

import com.powernode.domain.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SysUserRoleService extends IService<SysUserRole>{


    List<Long> getbyUserId(Long sysUserId);
}
