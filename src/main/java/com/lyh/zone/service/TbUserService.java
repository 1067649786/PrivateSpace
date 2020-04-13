package com.lyh.zone.service;

import com.baomidou.mybatisplus.service.IService;
import com.lyh.zone.entity.TbUser;

/**
 * 项目名称：zone
 * 类名称：TbUserService
 * 类描述：
 */
public interface TbUserService extends IService<TbUser> {

    TbUser login(String username,String password);

    int register(TbUser tbUser);

    /**
     * 设置上线时间
     * @param userid
     */
    void setUserOnline(Integer userid);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
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
     * @throws Exception
     */
    TbUser findByUserIdAndUserPwd(Integer userId, String formerlyPwd) throws Exception;
}
