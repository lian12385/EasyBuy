package com.buliang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable{
	private Integer id;//ID
	private String name;//商品名
	private String description;//描述
	private Float price;//单价
	private Integer stock;//数量
	private Integer categoryLevel1Id;//一级分类
	private Integer categoryLevel2Id;//二级分类
	private Integer categoryLevel3Id;//三级分类
	private String fileName;//图片名称

}