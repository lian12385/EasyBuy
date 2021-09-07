package com.buliang.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private Double sum;

    public Double getSum() {
        return items.stream().map(i->i.getCost()).reduce(0.0,(cost,sum)-> sum += cost);
    }
}
