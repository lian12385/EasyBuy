package com.buliang.mapper;

import com.buliang.pojo.User;

import java.util.List;

public interface UserMapper {
    User getUser(Integer id);
    int addUser(User user);
    User queryById(Integer id);
    User login(String name);
    List<User> queryAll();
}
