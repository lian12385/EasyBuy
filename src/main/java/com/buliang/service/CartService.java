package com.buliang.service;

import com.buliang.exc.AddToCartExc;

public interface CartService {
    boolean addToCart(Integer entityId,Integer quantity) throws AddToCartExc;
}
