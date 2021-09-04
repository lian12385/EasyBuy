package com.buliang.mapper;

import com.buliang.pojo.User;

public interface UserMapper {
    User getUser(Integer id);
    int addUser(User user);
    User queryById(Integer id);
    User login(String name);
}
