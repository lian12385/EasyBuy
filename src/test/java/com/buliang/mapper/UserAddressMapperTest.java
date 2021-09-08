package com.buliang.mapper;

import com.buliang.pojo.UserAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:applicationContext.xml")
public class UserAddressMapperTest {

    @Autowired
    UserAddressMapper userAddressMapper;

    @Test
    public void addAddress() {
        UserAddress userAddress = new UserAddress();

        //UserAddress userAddress = new UserAddress();
        userAddress.setAddress("143");
        userAddress.setRemark("3443");
        userAddress.setUserId(27);
        userAddress.setIsDefault(1);
        userAddressMapper.addAddress(userAddress);
    }
}