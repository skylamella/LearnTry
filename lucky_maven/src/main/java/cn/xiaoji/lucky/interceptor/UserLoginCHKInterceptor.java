package cn.xiaoji.lucky.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class UserLoginCHKInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if(ActionContext.getContext().getSession().get("user") == null){
			return "login";
		}else{
			return invocation.invoke();
		}
	}
	
}
