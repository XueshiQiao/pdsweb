/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pds.core.BaseAction;
import com.pds.model.BackgroundUser;
import com.pds.model.Departments;
import com.pds.service.DepartmentsService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
@Scope(value="prototype")
public class DepartmentsAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;
	
	//ID
	private int id;
	//model
	private Departments model;
	
	public String toAdd(){
		return "toAdd";
	}
	
	public String update(){
		BackgroundUser user = (BackgroundUser)session.get(BackgroundUserAction.USER_LOGIN_KEY);
		if(user != null){
			this.model.setAuthor(user.getUsername());
		}else{
			//TODO 没有登录的情况
		}
		this.model.setDate(new Date());
		//this.model.setVisitedCount(0);
		service.saveOrUpdate(this.model);
		return "updateSuccess";
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
	
//	public String update(){
//		model.setDate(new Date());
//		service.update(model);
//		return "updateSuccess";
//	}
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Departments getModel() {
		return model;
	}

	public void setModel(Departments model) {
		this.model = model;
	}
}
