package com.buliang.service.impl;

import com.buliang.exc.EBuyExc;
import com.buliang.mapper.UserAddressMapper;
import com.buliang.pojo.User;
import com.buliang.pojo.UserAddress;
import com.buliang.service.UserAddressService;
import com.buliang.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    UserAddressMapper userAddressMapper;

    public List<UserAddress> queryByUserId() throws EBuyExc {
        User user = SessionUtil.getCurrentUser();
        if (user != null){
            return userAddressMapper.queryById(user.getId());
        }
        throw new EBuyExc("未登录,请登录");
    }
}
