package com.lyh.ps.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyh.ps.system.entity.SysUserEntity;

public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 根据用户名查询实体
     * @param username
     * @return
     */
    SysUserEntity selectUserByName(String username);
}
