package com.pds.action;
/**
 * BY qiaoxueshi at pingdingshan university
 */

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pds.core.BaseAction;
import com.pds.model.BackgroundUser;
import com.pds.service.BackgroundUserService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class BackgroundUserAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

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
	
	public BackgroundUserService getService() {
		return service;
	}
	public void setService(BackgroundUserService service) {
		this.service = service;
	}
	
}
