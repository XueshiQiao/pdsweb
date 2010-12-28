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
import com.pds.common.page.Paginable;
import com.pds.core.BaseAction;
import com.pds.core.BaseService;
import com.pds.model.BackgroundUser;
import com.pds.model.FileUD;
import com.pds.service.FileService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
@Scope(value="prototype")
public class FileAction extends BaseAction {
	@Resource
	private FileService service;
	
	private static final long serialVersionUID = 5495728211877266147L;

	//ID
	private int id;
	//model
	private List<FileUD> list = new ArrayList<FileUD>();
	private FileUD model;
	private List<FileUD> models;
	//page
	private Paginable<FileUD> page;
	private int pageNo = 0;
	private int pageSize;
	
	public String toAdd(){
		return "toAdd";
	}
	
	public String add(){
		model.setDate(new Date());
		model.setDownloadTimes(0);
		
		try{
			model.setUploader(((BackgroundUser)super.getCurrentUser()).getUsername()); //TODO 设置为当前登录用户
		}catch(NullPointerException e){
			model.setUploader("匿名");
			//......
		}
		
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
		model.setDate(new Date());
		try{
			model.setUploader(((BackgroundUser)super.getCurrentUser()).getUsername()); //TODO 设置登录用户
		}catch(NullPointerException e){
			//......
		}
		service.update(model);
		return "updateSuccess";
	}
	public String edit(){
		if(id<=0){
			return "toEditError";
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
	
	public String list(){
		if(pageNo == 0||pageNo < 1 ){
			pageNo = 1;
		}
		page =  service.findPageByHql(pageNo,15);
		return SUCCESS;
	}
	
	public String index(){
		return "index";
	}

	public void setService(FileService service) {
		this.service = service;
	}
	
	public BaseService<FileUD> getService() {
		return this.service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<FileUD> getList() {
		return list;
	}

	public void setList(List<FileUD> list) {
		this.list = list;
	}

	public FileUD getModel() {
		return model;
	}

	public void setModel(FileUD model) {
		this.model = model;
	}

	public List<FileUD> getModels() {
		return models;
	}

	public void setModels(List<FileUD> models) {
		this.models = models;
	}

	public Paginable<FileUD> getPage() {
		return page;
	}

	public void setPage(Paginable<FileUD> page) {
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
