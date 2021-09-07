package com.buliang.service;

import com.buliang.pojo.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    boolean updateUser(User user);
    User queryById(int id);
    boolean queryByNameAndPassword(String name,String password);
    List<User> AdminQueryAllUser();
    boolean logicDelete(Integer id);
}
