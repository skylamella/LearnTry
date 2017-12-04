package cn.skyln.pojo;

public class Mail {
	private Integer Mail_id;
	private String Mail_title;
	private String Mail_text;
	private String Mail_chk;

	private Integer Mail_createUser;
	private Integer Mail_toUser;
	
	public Integer getMail_id() {
		return Mail_id;
	}
	public void setMail_id(Integer mail_id) {
		Mail_id = mail_id;
	}
	public String getMail_title() {
		return Mail_title;
	}
	public void setMail_title(String mail_title) {
		Mail_title = mail_title;
	}
	public String getMail_text() {
		return Mail_text;
	}
	public void setMail_text(String mail_text) {
		Mail_text = mail_text;
	}
	public String getMail_chk() {
		return Mail_chk;
	}
	public void setMail_chk(String mail_chk) {
		Mail_chk = mail_chk;
	}
	public Integer getMail_createUser() {
		return Mail_createUser;
	}
	public void setMail_createUser(Integer mail_createUser) {
		Mail_createUser = mail_createUser;
	}
	public Integer getMail_toUser() {
		return Mail_toUser;
	}
	public void setMail_toUser(Integer mail_toUser) {
		Mail_toUser = mail_toUser;
	}

}
