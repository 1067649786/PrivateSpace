package com.lyh.ps.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.ps.system.entity.SysRoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {

    /**
     * 通过用户id查询角色集合
     * @param userId
     * @return
     */
    List<SysRoleEntity> selectSysRoleByUserId(Long userId);
}
