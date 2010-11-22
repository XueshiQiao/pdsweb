package com.pds.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.pds.common.page.Paginable;
import com.pds.core.BaseAction;
import com.pds.model.AboutUs;
import com.pds.service.AboutUsService;

@Controller
@Scope(value="prototype")   //TODO 设置为prototype
public class AboutUsAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;
	
	@Resource
	private AboutUsService service ;
	
	private int id = 100; //TODO DELETE 100
	private AboutUs aboutUs;
	private List<AboutUs> aboutUses;
	private Paginable<AboutUs> page;
	private int pageNo = 0;
	private int pageSize;
	
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
	
	
	public String test(){

		return Action.SUCCESS;
	}
	
//	public 
	
	
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

}
