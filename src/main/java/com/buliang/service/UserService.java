package com.buliang.service;

import com.buliang.pojo.User;

public interface UserService {
    public int addUser(User user);
    public User queryById(int id);
}
