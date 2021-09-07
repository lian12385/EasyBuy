package com.buliang.service;

import com.buliang.pojo.User;

import java.util.List;

public interface UserService {
    public boolean addUser(User user);
    public User queryById(int id);
    public boolean queryByNameAndPassword(String name,String password);
    List<User> AdminQueryAllUser();
}
