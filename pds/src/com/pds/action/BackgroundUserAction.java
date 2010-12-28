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
import com.pds.service.RoleService;

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
	public static final String USER_ROLE = "user_role";
	private BackgroundUser user;
	private String username;
	private String password;
	private String result;

	@Resource
	private BackgroundUserService service ;
	@Resource
	private RoleService roleService;
	
	public String index(){
		if(this.session.get(USER_LOGIN_KEY) == null){
			return "login";
		}
		
		return SUCCESS;
	}
	
	public String login(){
		// TODO 用户登录action 登录成功之后要把用户的信息保存到Session中
//		this.session.put(BackgroundUserAction.USER_LOGIN_KEY, new BackgroundUser());
		if(username == null || username.trim().length()<1 ||
				password ==null || this.getPassword().trim().length()<1){
			result="isNull";
//			return "npIsNull"; 
		}
		BackgroundUser u = service.login(username,password);
		if(u==null){
			result="fail";
			return SUCCESS;
//			return "fail";
		}
		
		this.session.put(USER_LOGIN_KEY, u);
		this.session.put(USER_ROLE,roleService.findById(u.getRole()));
		result="success";
		return SUCCESS;
	}
	
	public String logout(){
		this.session.clear();
		System.out.println(this.session.get(USER_LOGIN_KEY) == null);
		return "login";
	}
	
	public BackgroundUserService getService() {
		return service;
	}
	public void setService(BackgroundUserService service) {
		this.service = service;
	}

	public BackgroundUser getUser() {
		return user;
	}

	public void setUser(BackgroundUser user) {
		this.user = user;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
