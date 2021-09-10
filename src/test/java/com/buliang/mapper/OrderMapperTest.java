package com.buliang.mapper;

import com.buliang.bo.OrderBo;
import com.buliang.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:applicationContext.xml")
public class OrderMapperTest {

    @Autowired
    OrderMapper orderMapper;
    @Test
    public void queryOrder() {
        OrderBo orderBo = new OrderBo();
        orderBo.setUserId(18);
        orderBo.setPage(true);
        orderBo.setPageIndex(1);
        orderBo.setPageSize(5);
        orderBo.setStartIndex(orderBo.getStartIndex());
        List<Order> orders = orderMapper.queryOrder(orderBo);
        System.out.println(orders);
    }
}