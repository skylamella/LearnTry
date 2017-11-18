package cn.xiaoji.lucky.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserLoginCHKInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if(ActionContext.getContext().getSession().get("user") == null){
			ActionContext.getContext().getSession().put("userErrorCode", "请登陆后再进行操作");
			return "home";
		}else{
			return invocation.invoke();
		}
	}
	
}
