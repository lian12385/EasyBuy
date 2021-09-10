package com.buliang.mapper;

import com.buliang.bo.OrderBo;
import com.buliang.bo.UserBo;
import com.buliang.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int add(Order order);
    Long queryOrderCount(@Param("orderBo") OrderBo orderBo);
    List<Order> queryOrder(@Param("orderBo") OrderBo orderBo);
}
