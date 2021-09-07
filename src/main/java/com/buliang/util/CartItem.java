package com.buliang.util;

import com.buliang.pojo.Product;
import lombok.Data;

@Data
public class CartItem {
    private Product product;
    private Integer quantity;
    //private Double count;

    public double getCost() {
        if (product == null || quantity == null) {
            return 0.;
        }
        return quantity * product.getPrice();
    }
}
