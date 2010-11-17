/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.pds.core.BaseAction;
import com.pds.service.CampusStyleService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class CampusStyleAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private CampusStyleService service ;
	
	public CampusStyleService getService() {
		return service;
	}
	public void setService(CampusStyleService service) {
		this.service = service;
	}
	
}
