package com.buliang.service.impl;

import com.buliang.exc.EBuyExc;
import com.buliang.pojo.Product;
import com.buliang.service.CartService;
import com.buliang.service.ProductService;
import com.buliang.util.Cart;
import com.buliang.util.CartItem;
import com.buliang.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductService productService;
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
}
