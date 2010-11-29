package com.pds.action;
/**
 * BY qiaoxueshi at pingdingshan university
 */

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pds.core.BaseAction;
import com.pds.model.BackgroundUser;
import com.pds.service.BackgroundUserService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
@Scope(value="prototype")
public class BackgroundUserAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;
	//保存用户登录信息到Session中的key.
	public static final String USER_LOGIN_KEY = "user_login";

	@Resource
	private BackgroundUserService service ;
	
	public String test(){
		BackgroundUser user = new BackgroundUser();
		user.setUsername("xueshishash");
		user.setPassword("hello world");
		user.setRole(1);
		service.save(user);
		
		return SUCCESS;
	}
	
	public String login(){
		
		// TODO 用户登录action 登录成功之后要把用户的信息保存到Session中
		//this.session.put(BackgroundUserAction.USER_LOGIN_KEY, new BackgroundUser());
		return null;
	}
	
	public BackgroundUserService getService() {
		return service;
	}
	public void setService(BackgroundUserService service) {
		this.service = service;
	}
	
}
