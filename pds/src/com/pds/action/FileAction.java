/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.pds.core.BaseAction;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class FileAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;
	
	
	
	public String index(){
		return "index";
	}
	public String test(){
		if(this.request == null){
			System.out.println("request == null");
		}
		if(this.response == null){
			System.out.println("response == null");
		}
		if(this.session == null){
			System.out.println("session == null");
		}else{
			System.out.println("all of these three objects are NOT NULL");
		}
		return Action.SUCCESS;
	}

}
