package cn.xiaoji.lucky.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoji.lucky.entity.User;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class FrameAction extends ActionSupport {

	private String url;

	public String index() {
		return SUCCESS;
	}
	
	public String userinfo() {
		return SUCCESS;
	}
	
	public String userprize() {
		return SUCCESS;
	}
	
	public String useradchk() {
		User u = (User) ActionContext.getContext().getSession().get("user");
		if(u.getUser_admin() == 1){
			return url;
		}else{
			return "false";
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
