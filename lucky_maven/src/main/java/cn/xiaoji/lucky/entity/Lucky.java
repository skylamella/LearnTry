package cn.xiaoji.lucky.entity;

import java.util.Date;

public class Lucky {
	private Integer lucky_id;
	private String lucky_title;
	private Date lucky_create;
	private int lucky_chk;
	private Integer user_id;
	private String lucky_pwd;

	public Integer getLucky_id() {
		return lucky_id;
	}

	public void setLucky_id(Integer lucky_id) {
		this.lucky_id = lucky_id;
	}

	public String getLucky_title() {
		return lucky_title;
	}

	public void setLucky_title(String lucky_title) {
		this.lucky_title = lucky_title;
	}

	public Date getLucky_create() {
		return lucky_create;
	}

	public void setLucky_create(Date lucky_create) {
		this.lucky_create = lucky_create;
	}

	public int getLucky_chk() {
		return lucky_chk;
	}

	public void setLucky_chk(int lucky_chk) {
		this.lucky_chk = lucky_chk;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getLucky_pwd() {
		return lucky_pwd;
	}

	public void setLucky_pwd(String lucky_pwd) {
		this.lucky_pwd = lucky_pwd;
	}
}
