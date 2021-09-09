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
import com.buliang.util.CartItem;
import com.buliang.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        User user = SessionUtil.getCurrentUser();
        if ( addressId == -1){
            UserAddress userAddress = new UserAddress();
            userAddress.setAddress(newAddress);
            userAddress.setRemark(newRemark);
            userAddress.setUserId(user.getId());
            userAddress.setIsDefault(1);
            if (userAddressMapper.addAddress(userAddress) > 0)
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
//        order.setPayStatus(0);
        String randomNum = UUID.randomUUID().toString().toUpperCase().replaceAll("\\-","");
        order.setSerialNumber(randomNum);
        if(orderMapper.add(order)>0){
            return order;
        }
        return null;
    }

    @Override
    public boolean createOrderDetail(Cart cart, Integer orderId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setProductId(item.getProduct().getId());
            orderDetail.setCost(item.getCost());
            //test success
            //orderDetail.setCost(555.5);
            orderDetails.add(orderDetail);
        }
        orderDetailMapper.batchAdd(orderDetails);
        return true;
    }
}
