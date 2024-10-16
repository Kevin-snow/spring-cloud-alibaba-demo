package com.daliantwop.cloud.daliantwopuser.service;

import com.daliantwop.cloud.daliantwopuser.entity.User;
import com.daliantwop.cloud.daliantwopuser.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Kevin
 * @date 2024/10/16 18:53
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;


    public User getUser() {
        return userMapper.selectUser();
    }
}
