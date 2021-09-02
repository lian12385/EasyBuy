package com.buliang.service.impl;

import com.buliang.mapper.UserMapper;
import com.buliang.pojo.User;
import com.buliang.service.UserService;
import com.buliang.util.PasswordUtils;
import com.buliang.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(int id) {
        return userMapper.queryById(id);
    }

    @Override
    public int addUser(User user) {
        int result = userMapper.addUser(user);
        return result;
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
}
