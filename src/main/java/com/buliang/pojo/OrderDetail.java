package com.buliang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable{
	private Integer id;//ID
	private Integer orderId;//订单ID
	private Integer quantity;//数量
	private Double cost;//单价
	private Integer productId;//商品id

	private Product product;//商品

}
