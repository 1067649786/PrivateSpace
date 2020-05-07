package com.lyh.zone.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lyh.zone.entity.TbBind;
import com.lyh.zone.entity.TbUser;
import com.lyh.zone.mapper.TbBindMapper;
import com.lyh.zone.service.TbBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目名称：zone
 * 类名称：TbBindServiceImpl
 * 类描述：
 */
@Service
public class TbBindServiceImpl extends ServiceImpl<TbBindMapper, TbBind> implements TbBindService {

    @Autowired
    private TbBindMapper bindMapper;

    @Override
    public int insertBindInfo(TbBind bind) {
        return bindMapper.insertBindInfo(bind);
    }

    @Override
    public TbBind selectBindByUser(TbUser user) {
        return bindMapper.selectBindByUser(user);
    }
}
