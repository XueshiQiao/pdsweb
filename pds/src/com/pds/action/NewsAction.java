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
import com.pds.model.News;
import com.pds.service.HotArticleService;
import com.pds.service.NewsService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
@Scope(value="prototype")
public class NewsAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private NewsService service ;
	
	//ID
	private int id;
	//model
	private List<News> list = new ArrayList<News>();
	private News model;
	private List<News> models;
	//page
	private Paginable<News> page;
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
		this.model.setDate(new Date());
		try{
			BackgroundUser user = (BackgroundUser)this.session.get(BackgroundUserAction.USER_LOGIN_KEY);
			this.model.setAuthor(user.getUsername());
		}catch(Exception e){
			this.model.setAuthor("匿名");//TODO 如果获得当前用户失败就设置为匿名
		}
		String content = model.getContent();
		String brief ="";
		if(content != null && content.length() > 512){
			brief = content.substring(0,512);
		}else if (content != null){
			brief = content;
		}
		this.model.setBrief(brief);
		this.model.setVisitedCount(0);
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
		String content = model.getContent();
		String brief ="";
		if(content != null && content.length() > 512){
			brief = content.substring(0,512);
		}else if (content != null){
			brief = content;
		}
		model.setBrief(brief);
		model.setDate(new Date());
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
	
	public String list(){
		if(pageNo == 0||pageNo < 1 ){
			pageNo = 1;
		}
		page =  service.findPageByHql(pageNo,15);
		return SUCCESS;
	}
	
	
	public NewsService getService() {
		return service;
	}
	public void setService(NewsService service) {
		this.service = service;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<News> getList() {
		return list;
	}
	public void setList(List<News> list) {
		this.list = list;
	}
	public News getModel() {
		return model;
	}
	public void setModel(News model) {
		this.model = model;
	}
	public List<News> getModels() {
		return models;
	}
	public void setModels(List<News> models) {
		this.models = models;
	}
	public Paginable<News> getPage() {
		return page;
	}
	public void setPage(Paginable<News> page) {
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
