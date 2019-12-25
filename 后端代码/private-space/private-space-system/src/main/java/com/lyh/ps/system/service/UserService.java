package com.lyh.ps.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyh.ps.common.entity.ResultEntity;
import com.lyh.ps.system.entity.User;

public interface UserService extends IService<User> {

    ResultEntity userLogin(String username,String password);

    ResultEntity userRegister(User user);
}
