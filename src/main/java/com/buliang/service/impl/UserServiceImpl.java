package com.buliang.service.impl;

import com.buliang.mapper.UserMapper;
import com.buliang.pojo.User;
import com.buliang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(int id) {
        return userMapper.queryById(id);
    }

    @Override
    public int addUser(User user) {
        int result = userMapper.addUser(user);
        return result;
    }
}
