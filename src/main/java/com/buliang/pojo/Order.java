package com.buliang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
	private Integer id;//ID
	private String serialNumber;//订单号
	private Integer userId;//用户id
	private String userAddress;//收货地址
	private Date createTime;//创建时间
	private Float cost;//订单总计价格
	private String loginName;//登录名称
	private List<OrderDetail> orderDetailList;//订单明细列表

}
