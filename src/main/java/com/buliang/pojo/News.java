package com.buliang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News implements Serializable{
	private Integer id;//ID
	private String title;//标题
	private String content;//内容
	private Date createTime;//创建时间

}
