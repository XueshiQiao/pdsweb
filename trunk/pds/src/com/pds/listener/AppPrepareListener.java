/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author qiaoxueshi
 *
 */
public class AppPrepareListener implements ServletContextListener {


	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("所有的准备工作");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("销毁context");
	}
}
