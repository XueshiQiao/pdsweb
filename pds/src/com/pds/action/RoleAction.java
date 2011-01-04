/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import com.pds.core.BaseAction;
import com.pds.service.RoleService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class RoleAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private RoleService service ;
	
	public RoleService getService() {
		return service;
	}
	public void setService(RoleService service) {
		this.service = service;
	}
	
}
