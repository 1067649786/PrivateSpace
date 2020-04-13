package com.lyh.zone.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lyh.zone.entity.TbUser;
import com.lyh.zone.mapper.TbUserMapper;
import com.lyh.zone.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * 项目名称：zone
 * 类名称：TbUserServiceImpl
 * 类描述：
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

    @Autowired
    private TbUserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(TbUserServiceImpl.class);

    @Override
    public TbUser login(String username, String password) {

        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return null;
        }
        TbUser tbUser=new TbUser();
        tbUser.setUsername(username);
        tbUser.setPassword(password);

        TbUser user=userMapper.selectOne(tbUser);
        if(user!=null){
            this.setUserOnline(user.getId());
            logger.info("用户："+user.getUsername()+"登录成功，登录时间:"+user.getOnlieTime());
            return user;
        }
        return null;
    }

    @Override
    public int register(TbUser tbUser) {
        if(tbUser != null){
            tbUser.setCreated(new Date());
            tbUser.setOnlieTime(new Date());
            tbUser.setBindCode(UUID.randomUUID().toString().substring(0,7));
            tbUser.setIsBind(0);
            return userMapper.insert(tbUser);
        }
        return 0;
    }

    @Override
    public TbUser selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public TbUser selectByBindCode(String bindCode) {
        return userMapper.selectByBindCode(bindCode);
    }

    @Override
    public void setUserOnline(Integer userid) {
        TbUser user=userMapper.selectById(userid);
        user.setOnlieTime(new Date());
        userMapper.updateById(user);
    }

    @Override
    public TbUser findByUserIdAndUserPwd(Integer userId, String formerlyPwd) throws Exception {
        return userMapper.findByUserIdAndUserPwd(userId, formerlyPwd);
    }
}
