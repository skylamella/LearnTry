package cn.xiaoji.lucky.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import cn.xiaoji.lucky.entity.User;
import cn.xiaoji.lucky.utils.CommonUse;
import cn.xiaoji.lucky.service.UserService;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class DetailAction extends ActionSupport {
	// 方法依赖字段
	private User user;
	private String email;
	// Service层动态代理
	@Resource(name = "userService")
	private UserService userService;

	public String forgetpass() {
		User u = userService.checkEmail(email);
		u.setUser_pwd(CommonUse.MD5Password(user.getUser_pwd()));
		try {
			userService.update(u);
		} catch (Exception e) {

		}
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
