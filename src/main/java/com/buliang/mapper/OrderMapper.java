package com.buliang.mapper;

import com.buliang.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int add(@Param("order") Order order);
}
