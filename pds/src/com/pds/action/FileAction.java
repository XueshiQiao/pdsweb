/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;


import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.pds.core.BaseAction;
import com.pds.core.BaseService;
import com.pds.model.FileUD;
import com.pds.service.FileService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class FileAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;
	private FileService service;
	
	
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

	public void setService(FileService service) {
		this.service = service;
	}
	
	public BaseService<FileUD> getService() {
		return this.service;
	}
	
	
}
