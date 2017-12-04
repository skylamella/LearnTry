package cn.skyln.pojo;

import java.util.Date;

public class User {
	private Integer User_id;
	private String User_name;
	private String User_pwd;
	private String User_email;
	private String User_phone;
	private String User_icon;
	private Date User_create;
	
	public Integer getUser_id() {
		return User_id;
	}
	public void setUser_id(Integer user_id) {
		User_id = user_id;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getUser_pwd() {
		return User_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		User_pwd = user_pwd;
	}
	public String getUser_email() {
		return User_email;
	}
	public void setUser_email(String user_email) {
		User_email = user_email;
	}
	public String getUser_phone() {
		return User_phone;
	}
	public void setUser_phone(String user_phone) {
		User_phone = user_phone;
	}
	public String getUser_icon() {
		return User_icon;
	}
	public void setUser_icon(String user_icon) {
		User_icon = user_icon;
	}
	public Date getUser_create() {
		return User_create;
	}
	public void setUser_create(Date user_create) {
		User_create = user_create;
	}

}
