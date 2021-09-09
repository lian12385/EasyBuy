package com.buliang.service;

import com.buliang.exc.EBuyExc;
import com.buliang.pojo.Order;

public interface CartService {
    boolean addToCart(Integer entityId,Integer quantity) throws EBuyExc;
    boolean modifyCart(Integer entityId,Integer quantity) throws EBuyExc;
    boolean modCart(Integer entityId);
    Order settlementCart(Integer addressId, String newAddress, String newRemark) throws EBuyExc;
}
