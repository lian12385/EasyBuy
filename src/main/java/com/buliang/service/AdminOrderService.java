package com.buliang.service;

import com.buliang.pojo.Order;
import com.buliang.pojo.User;
import com.buliang.util.Cart;

public interface AdminOrderService {
    boolean createUserAddress(Integer addressId,String newAddress, String newRemark);
    Order createOrder(User user, String newAddress, double sum);
    boolean createOrderDetail(Cart cart,Integer orderId);
}
