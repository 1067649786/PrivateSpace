package com.lyh.zone.service;

import com.baomidou.mybatisplus.service.IService;
import com.lyh.zone.entity.TbBind;
import com.lyh.zone.entity.TbUser;

/**
 * 项目名称：zone
 * 类名称：TbBindService
 * 类描述：
 */
public interface TbBindService extends IService<TbBind> {

    /**
     * 插入绑定账号信息
     * @param bind
     * @return
     */
    int insertBindInfo(TbBind bind);

    /**
     * 查找绑定关系
     * @param user
     * @return
     */
    TbBind selectBindByUser(TbUser user);
}
