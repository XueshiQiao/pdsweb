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
import com.pds.model.Message;
import com.pds.model.Message;
import com.pds.model.Reply;
import com.pds.service.MessageService;
import com.pds.service.ReplyService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
@Scope(value="prototype")
public class MessageAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private MessageService service ;
	@Resource 
	private ReplyService replyService;
	
	//ID
	private int id;
	//model
	private List<Message> list = new ArrayList<Message>();
	private Message model;
	private List<Message> models;
	//page
	private Paginable<Message> page;
	private int pageNo = 0;
	private int pageSize;
	
	
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

	
	//////////////////////////////////// GETTER AND SETTER/////////////////////////////////////////////////
	
	
	public MessageService getService() {
		return service;
	}

	public ReplyService getReplyService() {
		return replyService;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	public void setService(MessageService service) {
		this.service = service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Message> getList() {
		return list;
	}

	public void setList(List<Message> list) {
		this.list = list;
	}

	public Message getModel() {
		return model;
	}

	public void setModel(Message model) {
		this.model = model;
	}

	public List<Message> getModels() {
		return models;
	}

	public void setModels(List<Message> models) {
		this.models = models;
	}

	public Paginable<Message> getPage() {
		return page;
	}

	public void setPage(Paginable<Message> page) {
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
