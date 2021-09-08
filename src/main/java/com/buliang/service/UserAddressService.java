package com.buliang.service;

import com.buliang.exc.AddToCartExc;
import com.buliang.pojo.UserAddress;

import java.util.List;

public interface UserAddressService {
    List<UserAddress> queryByUserId() throws AddToCartExc;
}
