package com.lyh.ps.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyh.ps.system.entity.SysRoleEntity;

import java.util.List;

public interface SysRoleService extends IService<SysRoleEntity> {

    /**
     * 通过用户id查询角色集合
     * @param userId
     * @return
     */
    List<SysRoleEntity> selectSysRoleByUserId(Long userId);
}
