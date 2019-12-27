package com.lyh.ps.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.ps.system.entity.SysMenuEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {

    /**
     * 根据角色查询用户权限
     * @param roleId
     * @return
     */
    List<SysMenuEntity> selectSysMenuByRoleId(Long roleId);
}
