/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.core;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 提供一些公用的方法
 * @author qiaoxueshi
 *
 */
public class BaseAction extends ActionSupport implements 
						ServletRequestAware,
						ServletResponseAware,
						SessionAware
{
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String,Object> session;

	
	//Actions
	
	public String index(){
		return "index";
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}