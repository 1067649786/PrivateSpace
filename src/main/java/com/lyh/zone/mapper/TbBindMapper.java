package com.lyh.zone.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lyh.zone.entity.TbBind;
import com.lyh.zone.entity.TbUser;

/**
 * 项目名称：zone
 * 类名称：TbBindMapper
 * 类描述：
 */
public interface TbBindMapper extends BaseMapper<TbBind> {

    /**
     * 插入绑定账号信息
     * @param bind
     * @return
     */
    int insertBindInfo(TbBind bind);

    TbBind selectBindByUser(TbUser user);
}
