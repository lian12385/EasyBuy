package com.buliang.service;

import com.buliang.bo.UserBo;
import com.buliang.pojo.News;
import com.buliang.pojo.User;
import com.buliang.util.Pages;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    boolean updateUser(User user);
    User queryById(int id);
    boolean queryByNameAndPassword(String name,String password);
    Pages<User> queryUserByPage(UserBo userBo);
    boolean logicDelete(Integer id);
}
