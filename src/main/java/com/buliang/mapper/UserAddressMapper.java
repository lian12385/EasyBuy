package com.buliang.mapper;

import com.buliang.pojo.UserAddress;

import java.util.List;

public interface UserAddressMapper {
    List<UserAddress> queryById(Integer id);
    int addAddress(UserAddress userAddress);
}
