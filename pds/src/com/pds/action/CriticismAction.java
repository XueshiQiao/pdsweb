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
import com.pds.model.Criticism;
import com.pds.service.CriticismService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class CriticismAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private CriticismService service ;
	
	//ID
	private int id;
	//model
	private List<Criticism> list = new ArrayList<Criticism>();
	private Criticism model;
	private List<Criticism> models;
	//page
	private Paginable<Criticism> page;
	private int pageNo = 0;
	private int pageSize;
	
	
	protected static final int DEFAULT_PAGE_SIZE = 10;
	
	private int tbId; 	//请求的文章的id
	private int tbPageNo;	//请求的页数
	private Paginable<Criticism> tbPageModel;  //页面上的数据
	private Criticism tongbao; 

	public String listTongbao(){
		if(tbPageNo < 1 ){
			tbPageNo = 1; //默认载入第一页
		}
		try{
			tbPageModel = getService().findPageByHql(tbPageNo,DEFAULT_PAGE_SIZE);
			if(tbPageModel == null){
				return "pageNotFound";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "pageNotFound";
		}
		return "toListPage";
	}
	

	public String tongbao(){
		if( tbId < 1 ){
			return "pageNotFound";
		}
		try{
			tongbao = getService().findById(tbId);
			if(tongbao == null){
				return "pageNotFound";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "pageNotFound";
		}
		return "toTongbaoPage";
	}
	
	
	public String toAdd(){
		return "toAdd";
	}
	
	public String add(){
		this.model.setDate(new Date());
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
		service.update(model);
		return "updateSuccess";
	}
	public String edit(){
		if(id<=0){
			return "editError";
		}
		
		model = service.load(id);
		if(model == null){
			return "editError";
		}
		
		return "editSuccess";
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
	
	
	public CriticismService getService() {
		return service;
	}
	public void setService(CriticismService service) {
		this.service = service;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Criticism> getList() {
		return list;
	}
	public void setList(List<Criticism> list) {
		this.list = list;
	}
	public Criticism getModel() {
		return model;
	}
	public void setModel(Criticism model) {
		this.model = model;
	}
	public List<Criticism> getModels() {
		return models;
	}
	public void setModels(List<Criticism> models) {
		this.models = models;
	}
	public Paginable<Criticism> getPage() {
		return page;
	}
	public void setPage(Paginable<Criticism> page) {
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


	public int getTbId() {
		return tbId;
	}


	public void setTbId(int tbId) {
		this.tbId = tbId;
	}


	public int getTbPageNo() {
		return tbPageNo;
	}


	public void setTbPageNo(int tbPageNo) {
		this.tbPageNo = tbPageNo;
	}


	public Paginable<Criticism> getTbPageModel() {
		return tbPageModel;
	}


	public void setTbPageModel(Paginable<Criticism> tbPageModel) {
		this.tbPageModel = tbPageModel;
	}


	public Criticism getTongbao() {
		return tongbao;
	}


	public void setTongbao(Criticism tongbao) {
		this.tongbao = tongbao;
	}
}
