package cn.xiaoji.lucky.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class LuckyInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		String actionname = invocation.getProxy().getActionName();
		if(actionname.substring(0,5).equals("lucky")){
			
		}else{
			
		}
		return invocation.invoke();
	}
	
}
