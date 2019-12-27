package com.lyh.ps.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.ps.system.entity.SysMenuEntity;
import com.lyh.ps.system.mapper.SysMenuMapper;
import com.lyh.ps.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 根据角色查询用户权限
     * @param roleId
     * @return
     */
    @Override
    public List<SysMenuEntity> selectSysMenuByRoleId(Long roleId) {
        return sysMenuMapper.selectSysMenuByRoleId(roleId);
    }
}
