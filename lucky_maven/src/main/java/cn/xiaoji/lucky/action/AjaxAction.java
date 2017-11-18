package cn.xiaoji.lucky.action;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import cn.xiaoji.lucky.entity.*;
import cn.xiaoji.lucky.service.*;
import cn.xiaoji.lucky.utils.CommonUse;
import cn.xiaoji.lucky.vo.Mail;

/***
 * AjaxAction 实现ajax前后端数据交互，返回json字符串，在前台需要进行格式化
 * 
 * 如果前台有需要提交的字段（form表单中）
 * 在方法依赖字段按照相应的类型创建private字段，然后生成get，set方法即可
 * 不需要通过request、response进行数据获取
 * 
 * 返回为String类型的字符串，在方法中创建hashmap，将相应字段放入hashmap中
 * 然后进行类型转换即可
 * 
 * 切记将转换完的数据赋值给jsonArray字段，该字段为系统自动读取并返回给前台的数据
 * @author lamella
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class AjaxAction extends ActionSupport {
	// 方法依赖字段
	private String email;
	private String jsonArray;
	private User user;

	// Service层动态代理
	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "mailService")
	private MailService mailService;

	public String emailCheck() {
		User u = userService.checkEmail(email);
		if (u.getUser_name() != null && u.getUser_name() != "") {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("code", "success");
			jsonArray = JSON.toJSONString(map);
		} else {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("code", "false");
			jsonArray = JSON.toJSONString(map);
		}
		return SUCCESS;
	}

	public String emailCreate() {
		User u = userService.checkEmail(email);
		String emailAccount = "admin@skyln.cn";
		Mail mail = CommonUse.createCheckEmail(emailAccount, email, u.getUser_name());
		try {
			mailService.sendMail(mail);
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("code", "success");
			map.put("CheckCode", mail.getCheckCode());
			jsonArray = JSON.toJSONString(map);
		} catch (Exception e) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("code", "false");
			jsonArray = JSON.toJSONString(map);
		}
		return SUCCESS;
	}

	public String forgetpwd() {
		System.out.println(user.getUser_pwd());
		HashMap<String, String> map = new HashMap<String, String>();
		if(user.getUser_pwd().equals("123456")){
			map.put("code", "success");
		}else{
			map.put("code", "false");
		}
		jsonArray = JSON.toJSONString(map);
		return SUCCESS;
	}

	/***
	 * get，set方法
	 */
	public String getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(String jsonArray) {
		this.jsonArray = jsonArray;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}