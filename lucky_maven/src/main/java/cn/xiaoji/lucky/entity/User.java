package cn.xiaoji.lucky.entity;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private Integer user_id;
	private String user_name;
	private String user_pwd;
	private String user_icon;
	private String user_email;
	private int user_chk;
	private String user_chk_text;
	private int user_admin;
	private String user_admin_text;
	
	@JSONField(serialize=false)
	private Set<Lucky> lucky = new HashSet<Lucky>();
	@JSONField(serialize=false)
	private Set<Result> result = new HashSet<Result>();

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_icon() {
		return user_icon;
	}

	public void setUser_icon(String user_icon) {
		this.user_icon = user_icon;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getUser_chk() {
		return user_chk;
	}

	public void setUser_chk(int user_chk) {
		this.user_chk = user_chk;
		if(user_chk == 1){
			setUser_chk_text("正常账号");
		}else{
			setUser_chk_text("锁定（冻结）账号");
		}
	}

	public int getUser_admin() {
		return user_admin;
	}

	public void setUser_admin(int user_admin) {
		this.user_admin = user_admin;
		if(user_admin == 1){
			setUser_admin_text("有管理员权限");
		}else{
			setUser_admin_text("无管理员权限");
		}
	}

	public Set<Lucky> getLucky() {
		return lucky;
	}

	public void setLucky(Set<Lucky> lucky) {
		this.lucky = lucky;
	}

	public Set<Result> getResult() {
		return result;
	}

	public void setResult(Set<Result> result) {
		this.result = result;
	}

	public String getUser_chk_text() {
		return user_chk_text;
	}

	public void setUser_chk_text(String user_chk_text) {
		this.user_chk_text = user_chk_text;
	}

	public String getUser_admin_text() {
		return user_admin_text;
	}

	public void setUser_admin_text(String user_admin_text) {
		this.user_admin_text = user_admin_text;
	}
	
}
