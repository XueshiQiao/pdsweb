/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.pds.action.BackgroundUserAction;
import com.pds.model.BackgroundUser;
import com.pds.model.Role;

/**
 * @author qiaoxueshi
 *
 */

@SuppressWarnings("serial")
public class PrepareDateForAppServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		
		System.out.println("=================================================================");
		System.out.println("prepareData启动成功！");
		
		BackgroundUser user = new BackgroundUser();
		user.setId(12);
		user.setUsername("admin");
		user.setPassword("admin");
		user.setRole(1);
		super.getServletContext().setAttribute(BackgroundUserAction.USER_LOGIN_KEY,user );
		
		Role role = new Role();
		role.setId(1);
		role.setName("管理员");
		role.setRights("/aboutus,/tongbao");
		
		super.getServletContext().setAttribute(BackgroundUserAction.USER_ROLE, role);
		
	}
	
}
