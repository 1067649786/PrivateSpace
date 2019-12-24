package com.lyh.ps.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.ps.common.entity.ResultEntity;
import com.lyh.ps.common.utils.ResultUtils;
import com.lyh.ps.system.mapper.UserMapper;
import com.lyh.ps.system.entity.User;
import com.lyh.ps.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultEntity userLogin(String account, String password) {
        String msg = "用户名错误";
        User user = userMapper.queryByAccount(account);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return ResultUtils.createSuccessResultEntity("", user);
            } else {
                msg = "密码错误";
                return ResultUtils.createFailResultEntity(msg);
            }
        }
        return ResultUtils.createFailResultEntity(msg);
    }
}
