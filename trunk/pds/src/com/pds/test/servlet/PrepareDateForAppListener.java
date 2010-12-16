/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.test.servlet;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


import com.pds.action.BackgroundUserAction;
import com.pds.model.BackgroundUser;
import com.pds.model.Role;

/**
 * @author qiaoxueshi
 *
 */
public class PrepareDateForAppListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		
		HttpSession session = event.getSession();
		
		BackgroundUser user = new BackgroundUser();
		user.setId(12);
		user.setUsername("admin");
		user.setPassword("admin");
		user.setRole(1);
		session.setAttribute(BackgroundUserAction.USER_LOGIN_KEY,user );
		
		Role role = new Role();
		role.setId(1);
		role.setName("管理员");
		role.setRights("/autus,/tongbao");
		
		session.setAttribute(BackgroundUserAction.USER_ROLE, role);
		
		System.out.println("=================================================================");
		System.out.println("PrepareDateForAppListener 启动成功！");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

	}
	
	

}
