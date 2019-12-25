package com.lyh.ps.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.ps.system.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    User queryByUsername(String username);

    int addUser(User user);
}
