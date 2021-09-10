package com.buliang.service;

import com.buliang.bo.OrderBo;
import com.buliang.pojo.Order;
import com.buliang.util.Pages;

import java.util.List;

public interface AdminOrderService {
    Pages<Order> queryOrderPagesByUid(OrderBo orderBo);
}
