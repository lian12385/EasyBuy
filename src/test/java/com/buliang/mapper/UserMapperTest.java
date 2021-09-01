package com.buliang.mapper;

import com.buliang.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void queryById(){
        System.out.println(userMapper.queryById(2));
    }

    @Test
    public void addUser(){
        User user = new User();
        //user.set
        userMapper.addUser(user);
    }

}