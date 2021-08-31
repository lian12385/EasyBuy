package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
	private Integer id;
	private String loginName;//登录名称
	private String userName;//用户名
	private String password;//密码
	private Integer sex;//性别
	private String identityCode;
	private String email;//电子邮箱
	private String mobile;//电话
	private Integer type;//用户类别
}
