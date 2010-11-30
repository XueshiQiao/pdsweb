package com.pds.action;
/**
 * BY qiaoxueshi at pingdingshan university
 */

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.pds.core.BaseAction;
import com.pds.service.ReplyService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class ReplyAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private ReplyService service ;
	
	public ReplyService getService() {
		return service;
	}
	public void setService(ReplyService service) {
		this.service = service;
	}
	
}
