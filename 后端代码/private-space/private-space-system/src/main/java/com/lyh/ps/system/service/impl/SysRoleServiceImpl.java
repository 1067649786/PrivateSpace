package com.lyh.ps.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.ps.system.entity.SysRoleEntity;
import com.lyh.ps.system.mapper.SysRoleMapper;
import com.lyh.ps.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 通过用户id查询角色集合
     * @param userId
     * @return
     */
    @Override
    public List<SysRoleEntity> selectSysRoleByUserId(Long userId) {
        return sysRoleMapper.selectSysRoleByUserId(userId);
    }
}
