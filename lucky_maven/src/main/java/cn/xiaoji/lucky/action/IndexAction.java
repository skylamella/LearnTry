package cn.xiaoji.lucky.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class IndexAction extends ActionSupport {
	public String index() {
		return SUCCESS;
	}

	public String login() {
		return SUCCESS;
	}

	public String forgetpwd() {
		return SUCCESS;
	}
}