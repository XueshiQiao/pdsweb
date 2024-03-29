package com.pds.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pds.common.page.Paginable;
import com.pds.core.BaseAction;
import com.pds.model.AboutUs;
import com.pds.model.Departments;
import com.pds.service.AboutUsService;
import com.pds.service.DepartmentsService;

@Controller
@Scope(value="prototype")
public class AboutUsAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;
	
	@Resource
	private AboutUsService service ;
	@Resource
	private DepartmentsService depService;
	
	private int id = 0; 
	private AboutUs aboutUs;
	private List<AboutUs> aboutUses;
	private Paginable<AboutUs> page;
	private int pageNo = 0;
	private int pageSize;
	private Departments dep;// TODO 部门设置  和关于我们一起显示 以后要修改这里 
	
	public String toAdd(){
		return "toAdd";
	}
	
	public String add(){
		service.save(this.aboutUs);
		return "addsuccess";
	}
	
	public String delete(){
		if(id<=0){
			return "deleteError";
		}
		aboutUs = service.load(id);
		if(aboutUs == null){
			return "deleteError";
		}
		service.delete(aboutUs);
		return "deleteSuccess";
	}
	
	public String update(){
		service.update(aboutUs);
		return "updateSuccess";
	}
	public String edit(){
		if(id<=0){
			return "editError";
		}
		
		aboutUs = service.load(id);
		if(aboutUs == null){
			return "editError";
		}
		
		return "editSuccess";
	}
	
	public String get(){
		aboutUs = service.findById(id);
		return SUCCESS;
	}
	
	public String list(){
		if(pageNo == 0||pageNo < 1 ){
			pageNo = 1;
		}
		page =  service.findPageByHql(pageNo,15);
		return SUCCESS;
	}
	
	/**
	 * 得到最新的关于我们的信息，在自律委简介中显示
	 * @return
	 */
	public String aboutus(){
		aboutUs = service.getRecentAboutUs();
		dep = depService.getRecentDepartment();
		return "toAboutUsPage";
	}
	
	
	public AboutUsService getService() {
		return service;
	}
	public void setService(AboutUsService service) {
		this.service = service;
	}

	public AboutUs getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(AboutUs aboutUs) {
		this.aboutUs = aboutUs;
	}

	public List<AboutUs> getAboutUses() {
		return aboutUses;
	}

	public void setAboutUses(List<AboutUs> aboutUses) {
		this.aboutUses = aboutUses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Paginable<AboutUs> getPage() {
		return page;
	}

	public void setPage(Paginable<AboutUs> page) {
		this.page = page;
	}

	public DepartmentsService getDepService() {
		return depService;
	}

	public void setDepService(DepartmentsService depService) {
		this.depService = depService;
	}

	public Departments getDep() {
		return dep;
	}

	public void setDep(Departments dep) {
		this.dep = dep;
	}
	
	
}
