/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action.ajax;

import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pds.core.BaseAction;
import com.pds.model.AboutUs;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class AjaxActionTest extends ActionSupport {
	
	private static final long serialVersionUID = 438643146632869067L;
	private String name ="Hllo";
	private AboutUs au = new AboutUs();
	// 用户Ajax返回数据
	private String result;

	private Date date = new Date();
	
	public String test(){
		au.setIntroduction("introduction");
		au.setCompetency("competecy");
		au.setContact("contact");
		au.setHistory("history");
		System.out.println("name="+name);
		//this.result = JSONObject.fromObject(au).toString();
		System.out.println(result);
		return SUCCESS;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AboutUs getAu() {
		return au;
	}

	public void setAu(AboutUs au) {
		this.au = au;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	//格式化日期
	@JSON(format="yyyy-MM-dd hh-mm-ss")
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
