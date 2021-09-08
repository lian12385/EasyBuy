package com.buliang.service.impl;

import com.buliang.pojo.Product;
import com.buliang.pojo.UserAddress;
import com.buliang.service.AdminOrderService;
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
public class AdminOrderServiceImplTest {

    @Autowired
    AdminOrderService adminOrderService;

    @Test
    public void createUserAddress() {

    }

    @Test
    public void createOrder() {
    }

    @Test
    public void createOrderDetail() {
        Cart cart = new Cart();
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(4);

        Product product = new Product();
        product.setId(544);
        cartItem.setProduct(product);
        cartItems.add(cartItem);

        CartItem cartItem1 = new CartItem();
        cartItem1.setQuantity(4);

        Product product1 = new Product();
        product1.setId(555);
        cartItem1.setProduct(product1);
        cartItems.add(cartItem1);

        cart.setItems(cartItems);
        adminOrderService.createOrderDetail(cart,4);

    }
}