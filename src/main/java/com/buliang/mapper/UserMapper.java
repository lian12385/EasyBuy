package com.buliang.mapper;

import com.buliang.pojo.User;

public interface UserMapper {
    public User getUser(Integer id);
    public int addUser(User user);
    public User queryById(Integer id);
    public User login(String name);
}
