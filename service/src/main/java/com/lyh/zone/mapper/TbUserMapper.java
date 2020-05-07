package com.lyh.zone.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lyh.zone.entity.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 项目名称：zone
 * 类名称：TbUserMapper
 * 类描述：
 */
@Repository
public interface TbUserMapper extends BaseMapper<TbUser> {
    TbUser selectByUsername(String username);

    /**
     * 通过绑定码查找用户
     * @param bindCode
     * @return
     */
    TbUser selectByBindCode(String bindCode);

    /**
     * 查询原密码是否存在
     * @param userId
     * @param formerlyPwd
     * @return
     */
    TbUser findByUserIdAndUserPwd(@Param("userId") Integer userId,@Param("formerlyPwd") String formerlyPwd);
}
