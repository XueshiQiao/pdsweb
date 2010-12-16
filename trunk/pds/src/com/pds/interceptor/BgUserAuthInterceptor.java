/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.interceptor;

import java.util.Map;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.pds.action.BackgroundUserAction;
import com.pds.model.BackgroundUser;
import com.pds.model.Role;

/**
 * @author qiaoxueshi
 *
 */
public class BgUserAuthInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 5881640192986836008L;
	
	//拦截器的名称
	private String name;
	//受权限控制的方法
	private String includedMethods="";
	
	//得到session
	private Map<String,Object> session;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		session = invocation.getInvocationContext().getSession();
		ActionInvocation ai = invocation; //(ActionInvocation) ActionContext.getContext().get(ActionContext.ACTION_INVOCATION);
		ActionProxy proxy = ai.getProxy();
		final String action = proxy.getActionName();
		final String method= proxy.getMethod();
		final String namespace = proxy.getNamespace();
		
		//TODO DELETE
		{
			session.get("abc");//出发创建sesion
			session.put("1", "12");
		}
		if(includedMethods != null &&
				!includedMethods.trim().equals("") && 
				includedMethods.contains(method)){//如果设置了includedMethods，且请求的方法在其中，则执行权限验证。
			Object oUser = this.getCurrentUser();
			if(oUser == null){
				return "login";
			}
			//得到当前用户
			BackgroundUser user = (BackgroundUser)oUser;
			Object o = this.getUserRole();
			if(o == null){
				return "login";
			}
			//得到当前用户的组，来获得权限
			Role currentUserRole = (Role)o;
			String rights = currentUserRole.getRights();
			if(rights != null && rights.contains(namespace)){ //验证访问的是否是允许的namespace下的action
				String result = invocation.invoke();
				return result;
			}
			return "forbidden";
		}else{ //如果includedMethods不包含请求的方法，那么略去权限验证，允许访问
			String result = invocation.invoke();
			return result;
		}
	}
	
	private Object getUserRole(){
		return session.get(BackgroundUserAction.USER_ROLE);
	}
	private Object getCurrentUser(){
		return session.get(BackgroundUserAction.USER_LOGIN_KEY);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getIncludedMethods() {
		return includedMethods;
	}

	public void setIncludedMethods(String includedMethods) {
		this.includedMethods = includedMethods;
	}
}
