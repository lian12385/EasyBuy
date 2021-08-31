package com.buliang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory implements Serializable{
	private Integer id;//ID
	private String name;//名称
	private Integer parentId;//父级ID
	private Integer type;//分类级别
	private String iconClass;
	private String parentName;//父级分类名
}
