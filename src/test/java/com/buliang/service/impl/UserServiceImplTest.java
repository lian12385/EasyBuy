package com.buliang.service.impl;

import com.buliang.pojo.User;
import com.buliang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setLoginName("buliang");
        user.setUserName("buliang");
        user.setPassword("123");
        user.setSex(1);
        user.setEmail("wangwu@163.com");
        user.setMobile("12345678901");
        user.setIdentityCode("3271894891234");
        userService.addUser(user);
    }
}