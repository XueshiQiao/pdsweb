/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import com.pds.common.page.Paginable;
import com.pds.core.BaseAction;
import com.pds.model.BackgroundUser;
import com.pds.model.Rules;
import com.pds.service.RulesService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class RulesAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private RulesService service ;
	
	//ID
	private int id;
	//model
	private List<Rules> list = new ArrayList<Rules>();
	private Rules model;
	private List<Rules> models;
	//page
	private Paginable<Rules> page;
	private int pageNo = 0;
	private int pageSize;
	
	public String toAdd(){
		return "toAdd";
	}
	
	public String add(){
		model.setDate(new Date());
		
		try{
			model.setAuthor(((BackgroundUser)super.getCurrentUser()).getUsername()); //TODO 设置登录用户
		}catch(NullPointerException e){
			//......
		}
		String content = model.getContent();
		if(content != null ){
			if(content.length()>1024){
				model.setBrief(content.substring(0, 1024));
			}else{
				model.setBrief(content);
			}
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
			model.setAuthor(((BackgroundUser)super.getCurrentUser()).getUsername()); //TODO 设置登录用户
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
		System.out.println(model);
		if(model == null){
			return "toEditError";
		}
		
		return "toEditSucc";
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
	
	public RulesService getService() {
		return service;
	}
	public void setService(RulesService service) {
		this.service = service;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Rules> getList() {
		return list;
	}
	public void setList(List<Rules> list) {
		this.list = list;
	}
	public Rules getModel() {
		return model;
	}
	public void setModel(Rules model) {
		this.model = model;
	}
	public List<Rules> getModels() {
		return models;
	}
	public void setModels(List<Rules> models) {
		this.models = models;
	}
	public Paginable<Rules> getPage() {
		return page;
	}
	public void setPage(Paginable<Rules> page) {
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
