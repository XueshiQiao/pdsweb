/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.pds.common.page.Paginable;
import com.pds.core.BaseAction;
import com.pds.model.BackgroundUser;
import com.pds.model.Link;
import com.pds.service.LinkService;
import com.pds.service.NewsService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
@Scope(value="prototype")
public class LinkAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private LinkService service ;
	
	//ID
	private int id;
	//model
	private List<Link> list = new ArrayList<Link>();
	private Link model;
	private List<Link> models;
	//page
	private Paginable<Link> page;
	private int pageNo = 0;
	private int pageSize;
	
	
	public String toAdd(){
		return "toAdd";
	}
	public String show(){
		if(id<=0){
			return "showError";
		}
		model = service.load(id);
		if(model == null){
			return "showError";
		}
		return "show";
	}
	
	public String add(){
		service.save(this.model);
		return "addsuccess";
	}
	
	public String delete(){
		if(id<=0){
			return "deleteError";
		}
		model = service.load(id);
		if(model == null){
			return "deleteError";
		}
		service.delete(model);
		return "deleteSuccess";
	}
	
	public String update(){
		service.update(model);
		return "updateSuccess";
	}
	
	public String edit(){
		if(id<=0){
			return "editError";
		}
		
		model = service.load(id);
		if(model == null){
			return "toEditError";
		}
		
		return "toEdit";
	}
	
	public String get(){
		model = service.findById(id);
		return SUCCESS;
	}
	
	public String findAll(){
		this.models =  service.findAll();
		return SUCCESS;
	}
	
	public String list(){
		if(pageNo == 0||pageNo < 1 ){
			pageNo = 1;
		}
		page =  service.findPageByHql(pageNo,15);
		return SUCCESS;
	}
	
	public LinkService getService() {
		return service;
	}
	public void setService(LinkService service) {
		this.service = service;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Link> getList() {
		return list;
	}
	public void setList(List<Link> list) {
		this.list = list;
	}
	public Link getModel() {
		return model;
	}
	public void setModel(Link model) {
		this.model = model;
	}
	public List<Link> getModels() {
		return models;
	}
	public void setModels(List<Link> models) {
		this.models = models;
	}
	public Paginable<Link> getPage() {
		return page;
	}
	public void setPage(Paginable<Link> page) {
		this.page = page;
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
}
