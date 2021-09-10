package com.buliang.service.impl;

import com.buliang.bo.UserBo;
import com.buliang.mapper.UserMapper;
import com.buliang.pojo.News;
import com.buliang.pojo.User;
import com.buliang.service.UserService;
import com.buliang.util.Constant;
import com.buliang.util.Pages;
import com.buliang.util.PasswordUtils;
import com.buliang.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(int id) {
        return userMapper.queryById(id);
    }

    @Override
    public boolean addUser(User user) {
        User user1 = userMapper.login(user.getLoginName());
        if(user1 ==null) {
            user.setType(Constant.USER_TYP_NORMAL);
            user.setPassword(PasswordUtils.generate(user.getPassword()));
            if(userMapper.addUser(user)>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public Pages<User> queryUserByPage(UserBo userBo) {
        Pages<User> userPages = new Pages<>();
        if (userBo == null) {
            return null;
        }
        userPages.setPageIndex(userBo.getPageIndex());
        userPages.setPageSize(userBo.getPageSize());
        userPages.setTotalCount(userMapper.queryTotalCountUsers(userBo));
        List<User> users = userMapper.queryUsers(userBo);
        userPages.setRecords(users);
        return userPages;
    }

    @Override
    public boolean queryByNameAndPassword(String loginName, String password) {
        User user = userMapper.login(loginName);
        if(user != null){
            if(PasswordUtils.verify(password,user.getPassword())){
                SessionUtil.setUserInSession(user);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean logicDelete(Integer id) {
        if (userMapper.delete(id) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        if ( userMapper.update(user) > 0){
            return true;
        }
        return false;
    }
}
