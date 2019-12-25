package com.lyh.ps.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.ps.common.entity.ResultEntity;
import com.lyh.ps.common.utils.ResultUtils;
import com.lyh.ps.common.utils.UUIDUtils;
import com.lyh.ps.system.mapper.UserMapper;
import com.lyh.ps.system.entity.User;
import com.lyh.ps.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //account长度
    private final int LEN = 8;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultEntity userLogin(String username, String password) {
        String msg = "用户名错误";
        User user = userMapper.queryByUsername(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return ResultUtils.createSuccessResultEntity("登录成功", user);
            } else {
                msg = "密码错误";
                return ResultUtils.createFailResultEntity(msg);
            }
        }
        return ResultUtils.createFailResultEntity(msg);
    }

    @Override
    public ResultEntity userRegister(User user) {
        User user1=userMapper.queryByUsername(user.getUsername());
        if(user1 != null){
            return ResultUtils.createFailResultEntity("用户名已存在!");
        }
        user.setAccount(UUIDUtils.getUUID(LEN));
        user.setId(UUIDUtils.getUUID());
        if(userMapper.addUser(user) < 1){
            return ResultUtils.createFailResultEntity("注册失败!");
        }
        return ResultUtils.createSuccessResultEntity("注册成功",user);
    }
}
