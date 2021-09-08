package com.buliang.mapper;

import com.buliang.pojo.Product;
import com.buliang.service.AdminOrderService;
import com.buliang.service.impl.AdminOrderServiceImpl;
import com.buliang.util.Cart;
import com.buliang.util.CartItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:applicationContext.xml")
public class OrderDetailMapperTest {

    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Autowired
    AdminOrderService adminOrderService;
    @Test
    public void batchAdd() {

    }
}