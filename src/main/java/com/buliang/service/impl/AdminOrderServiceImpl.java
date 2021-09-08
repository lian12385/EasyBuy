package com.buliang.service.impl;

import com.buliang.mapper.OrderDetailMapper;
import com.buliang.mapper.OrderMapper;
import com.buliang.mapper.UserAddressMapper;
import com.buliang.pojo.Order;
import com.buliang.pojo.OrderDetail;
import com.buliang.pojo.User;
import com.buliang.pojo.UserAddress;
import com.buliang.service.AdminOrderService;
import com.buliang.util.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    UserAddressMapper userAddressMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public boolean createUserAddress(Integer addressId, String newAddress, String newRemark) {
        if ( addressId == -1){
            UserAddress userAddress = new UserAddress();
            userAddress.setAddress(newAddress);
            userAddress.setRemark(newRemark);
            userAddressMapper.addAddress(userAddress);
            return true;
        }
        return false;
    }

    @Override
    public Order createOrder(User user, String newAddress,double sum) {
        Order order = new Order();
        order.setLoginName(user.getLoginName());
        order.setUserAddress(newAddress);
        order.setUserId(user.getId());
        order.setCost(sum);
        String randomNum = UUID.randomUUID().toString().toUpperCase().replaceAll("\\-","");
        order.setSerialNumber(randomNum);
        orderMapper.add(order);
        return order;
    }

    @Override
    public boolean createOrderDetail(Cart cart, Integer orderId) {
        return false;
    }
}
