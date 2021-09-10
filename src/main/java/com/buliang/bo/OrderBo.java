package com.buliang.bo;

import com.buliang.pojo.Order;
import lombok.Data;

@Data
public class OrderBo extends BaseBo{
    private Integer userId;
    private Order order;
}
