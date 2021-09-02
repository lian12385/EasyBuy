package com.buliang.service;

import com.buliang.pojo.User;

public interface UserService {
    public boolean addUser(User user);
    public User queryById(int id);
    public boolean queryByNameAndPassword(String name,String password);
}
