package cn.xiaoji.lucky.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class IndexAction extends ActionSupport {
	public String index() {
		return "index";
	}

	public String login() {
		return "login";
	}

	public String forgetpwd() {
		return "forgetpwd";
	}
}
