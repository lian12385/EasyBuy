package com.buliang.mapper;

import com.buliang.pojo.User;

public interface OrderDetailMapper {
    public User getUser(Integer id);
    public User addUser(User user);
    public User queryById(Integer id);
}
