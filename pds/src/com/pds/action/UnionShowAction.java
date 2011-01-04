/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pds.common.page.Paginable;
import com.pds.core.BaseAction;
import com.pds.model.UnionShow;
import com.pds.service.UnionShowService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
@Scope(value="prototype")
public class UnionShowAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private UnionShowService service ;
	
	//ID
	private int id;
	//model
	private List<UnionShow> list = new ArrayList<UnionShow>();
	private UnionShow model;
	private List<UnionShow> models;
	//page
	private Paginable<UnionShow> page;
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<UnionShow> getList() {
		return list;
	}
	public void setList(List<UnionShow> list) {
		this.list = list;
	}
	public UnionShow getModel() {
		return model;
	}
	public void setModel(UnionShow model) {
		this.model = model;
	}
	public List<UnionShow> getModels() {
		return models;
	}
	public void setModels(List<UnionShow> models) {
		this.models = models;
	}
	public Paginable<UnionShow> getPage() {
		return page;
	}
	public void setPage(Paginable<UnionShow> page) {
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
	
	public UnionShowService getService() {
		return service;
	}
	public void setService(UnionShowService service) {
		this.service = service;
	}
	
}
