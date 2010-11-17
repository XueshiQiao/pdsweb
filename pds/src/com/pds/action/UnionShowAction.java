/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.pds.core.BaseAction;
import com.pds.service.UnionShowService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class UnionShowAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private UnionShowService service ;
	
	public UnionShowService getService() {
		return service;
	}
	public void setService(UnionShowService service) {
		this.service = service;
	}
	
}
