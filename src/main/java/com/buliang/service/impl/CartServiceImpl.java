package com.buliang.service.impl;

import com.buliang.exc.EBuyExc;
import com.buliang.mapper.*;
import com.buliang.pojo.*;
import com.buliang.service.CartService;
import com.buliang.service.ProductService;
import com.buliang.util.Cart;
import com.buliang.util.CartItem;
import com.buliang.util.SessionUtil;
import com.buliang.vo.ResultVo;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Override
    public boolean addToCart(Integer entityId,Integer quantity) throws EBuyExc {
        Cart cart = SessionUtil.getCurrentCart() ;
        if(cart == null){
            cart = new Cart();
            //把购物车添加到session
            SessionUtil.setCart(cart);
        }
        Product product = productService.queryById(entityId);
        if ( quantity > product.getStock() )
        {
            throw new EBuyExc("商品数量不足");
        }
        List<CartItem> cartItems = cart.getItems();
        if(!cartItems.isEmpty()){
            for (CartItem cartItem : cartItems) {
                if (cartItem.getProduct().getId().intValue() == entityId.intValue()){
                    if( cartItem.getQuantity() + quantity > product.getStock() ){
                        throw new EBuyExc("库存不足");
                    }
                    else{
                        cartItem.setQuantity(cartItem.getQuantity() + quantity);
                        return true;
                    }
                }
                //else为什么不可，万一第二个是呢？
            }

        }
        CartItem productCartItem = new CartItem();
        productCartItem.setProduct(product);
        productCartItem.setQuantity(quantity);
        cartItems.add(productCartItem);
        return true;
    }

    @Override
    public boolean modifyCart(Integer entityId, Integer quantity) throws EBuyExc {
        Cart cart = SessionUtil.getCurrentCart() ;
        if(cart == null){
            cart = new Cart();
            //把购物车添加到session
            SessionUtil.setCart(cart);
        }
        Product product = productService.queryById(entityId);
        if ( quantity > product.getStock() )
        {
            throw new EBuyExc("商品数量不足");
        }
        for (CartItem cartItem : cart.getItems()) {
            if (cartItem.getProduct().getId().intValue() == entityId.intValue()){
                if (quantity > 0) {
                    cartItem.setQuantity(quantity);
                }
                else if(quantity ==0 ){
                    cart.getItems().remove(cartItem);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean modCart(Integer entityId) {
        Cart cart = SessionUtil.getCurrentCart() ;
        if(cart == null){
            cart = new Cart();
            //把购物车添加到session
            SessionUtil.setCart(cart);
        }
        Product product = productService.queryById(entityId);

        cart.getItems().removeIf(ele-> (ele.getProduct().getId()).intValue() == entityId.intValue() );
        return true;
    }

    @Override
    public Order settlementCart(Integer addressId, String newAddress, String newRemark) throws EBuyExc {
        Cart cart = SessionUtil.getCurrentCart();
        User user = SessionUtil.getCurrentUser();
        if (checkOutQuantity(cart)){
            throw new EBuyExc("库存数量不足！");
        }

        UserAddress userAddress = new UserAddress();
        if ( addressId.intValue() == -1){
            if (newAddress == null && newAddress.trim().isEmpty()){
                throw new EBuyExc("请有效输入地址");
            }
            userAddress.setAddress(newAddress);
            userAddress.setRemark(newRemark);
            userAddress.setUserId(user.getId());
            userAddress.setIsDefault(1);
            //其他默认地址改为0
            userAddressMapper.addAddress(userAddress);
        }
        else{
          userAddress = userAddressMapper.query(addressId);
        }

        Order order = new Order();
        order.setLoginName(user.getLoginName());
        order.setUserAddress(userAddress.getAddress());
        order.setUserId(user.getId());
        order.setCost(cart.getSum());
        order.setCreateTime(new Date());
//        order.setPayStatus(0);
        String randomNum = UUID.randomUUID().toString().toUpperCase().replaceAll("\\-","");
        order.setSerialNumber(randomNum);
        if (orderMapper.add(order) < 0) {
            throw new EBuyExc("创建订单失败!");
        }


        List<CartItem> cartItems =cart.getItems();
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (CartItem item : cartItems) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setProductId(item.getProduct().getId());
            orderDetail.setCost(item.getCost());
            //test success
            //orderDetail.setCost(555.5);
            orderDetails.add(orderDetail);

            //减库存
            productMapper.subStock(item.getProduct().getId(),item.getProduct().getStock() - item.getQuantity());

        }
        //插入订单详情
        orderDetailMapper.batchAdd(orderDetails);

        //cart Session clear
        SessionUtil.clearCart(cart);

        return order;
    }
    public boolean checkOutQuantity(Cart cart) {
        boolean loop = true;
        if (cart != null) {
            for (CartItem cartItem : cart.getItems()) {
                while (loop) {
                    loop = cartItem.getQuantity() > cartItem.getProduct().getStock();
                }
                break;
            }
            return false;
        }
        return true;
    }
}
