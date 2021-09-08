package com.buliang.service;

import com.buliang.exc.EBuyExc;

public interface CartService {
    boolean addToCart(Integer entityId,Integer quantity) throws EBuyExc;
    boolean modifyCart(Integer entityId,Integer quantity) throws EBuyExc;
    boolean modCart(Integer entityId);
}
