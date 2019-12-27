package com.lyh.ps.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyh.ps.system.entity.SysMenuEntity;

import java.util.List;

public interface SysMenuService extends IService<SysMenuEntity> {

    /**
     * 根据角色查询用户权限
     * @param roleId
     * @return
     */
    List<SysMenuEntity> selectSysMenuByRoleId(Long roleId);
}
