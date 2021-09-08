package com.buliang.mapper;

import com.buliang.pojo.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailMapper {
    boolean batchAdd(@Param("orderDetails") List<OrderDetail> orderDetails);
}
