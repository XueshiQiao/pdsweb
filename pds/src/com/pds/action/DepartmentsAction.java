/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pds.core.BaseAction;
import com.pds.model.Departments;
import com.pds.service.DepartmentsService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class DepartmentsAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;
	
	//ID
	private int id;
	//model
	private Departments model;
	
	public String toAdd(){
		return "toAdd";
	}
	
	public String add(){
		this.model.setDate(new Date());
		service.save(this.model);
		return "addsuccess";
	}
	
//	public String delete(){
//		if(id<=0){ucc
//			return "deleteError";
//		}
//		model = service.load(id);
//		if(model == null){
//			return "deleteError";
//		}
//		service.delete(model);
//		return "deleteSess";
//	}
	
	public String update(){
		model.setDate(new Date());
		service.update(model);
		return "updateSuccess";
	}
	public String edit(){
		model = service.getRecentDepartment();
		if(model == null){
			model = new Departments();
			service.save(model);
			return "toEditError";
		}
		return "toEdit";
	}
	
	public String findById(){
		model = service.findById(id);
		return SUCCESS;
	}
	
	@Resource
	private DepartmentsService service ;
	
	public DepartmentsService getService() {
		return service;
	}
	public void setService(DepartmentsService service) {
		this.service = service;
	}
	
}
