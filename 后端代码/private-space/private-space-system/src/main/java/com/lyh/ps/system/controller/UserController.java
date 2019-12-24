package com.lyh.ps.system.controller;

import com.lyh.ps.common.entity.ResultEntity;
import com.lyh.ps.common.utils.ResultUtils;
import com.lyh.ps.system.entity.User;
import com.lyh.ps.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultEntity<?> login(@RequestBody User user){
        return userService.userLogin(user.getAccount(),user.getPassword());
    }
}
