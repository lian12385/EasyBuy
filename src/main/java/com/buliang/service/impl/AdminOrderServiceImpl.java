package com.buliang.service.impl;

import com.buliang.bo.OrderBo;
import com.buliang.mapper.OrderDetailMapper;
import com.buliang.mapper.OrderMapper;
import com.buliang.mapper.ProductMapper;
import com.buliang.mapper.UserAddressMapper;
import com.buliang.pojo.News;
import com.buliang.pojo.Order;
import com.buliang.pojo.OrderDetail;
import com.buliang.pojo.Product;
import com.buliang.service.AdminOrderService;
import com.buliang.util.Pages;
import com.buliang.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    UserAddressMapper userAddressMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductMapper productMapper;

    @Override
    public Pages<Order> queryOrderPagesByUid(OrderBo orderBo) {

        Pages<Order> orderPages = new Pages<>();
        if (orderBo == null) {
            return null;
        }
        orderPages.setPageIndex(orderBo.getPageIndex());
        orderPages.setPageSize(orderBo.getPageSize());
        //orderPages.setTotalCount(orderMapper.queryOrderCount(orderBo.getUserId()));
        orderPages.setTotalCount(orderMapper.queryOrderCount(orderBo));
        List<Order> orders = orderMapper.queryOrder(orderBo);
        for (Order order : orders) {
            for (OrderDetail orderDetail : order.getOrderDetailList()) {
                Product product = productMapper.queryById(orderDetail.getProductId());
                orderDetail.setProduct(product);
            }
            //orderDetailMapper.queryAssByorderId(order.getId());
        }
        orderPages.setRecords(orders);
        return orderPages;


        //找出订单集合,单人所有订单
        //List<Order> orderList = orderMapper.queryOrderById(orderBo.getOrder().getId());
        //for (Order order : orderList) {
        //    order.setOrderDetailList(orderDetailMapper.queryOrderDetailByOrderId(order.getId()));
        //}
        //return orderList;
    }

}
