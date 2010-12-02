package com.pds.action;
/**
 * BY qiaoxueshi at pingdingshan university
 */

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pds.core.BaseAction;
import com.pds.model.BackgroundUser;
import com.pds.model.Message;
import com.pds.model.Reply;
import com.pds.service.MessageService;
import com.pds.service.ReplyService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class ReplyAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private ReplyService service ;
	@Resource
	private MessageService messageService;
	
	private int id;
	private int mId; //父ID，即所属的Message的Id
	
	private Reply model;
	private List<Reply> models;
	
	
	public String toAdd(){
		return "toAdd";
	}
	
	/**
	 * 需要传递过来mId参数 作为message的ID
	 * @return
	 */
	public String add(){
		if(mId>0 && model!=null){
			Message message = messageService.findById(mId);
			model.setMessage(message);
			BackgroundUser user = (BackgroundUser)this.session.get(BackgroundUserAction.USER_LOGIN_KEY);
			if(user != null){
				model.setReplyer(user.getUsername());
			}else{
				model.setReplyer("匿名"); //TODO 应该得到当前登录用户
			}
			this.model.setDate(new Date());
			service.save(this.model);
			return "addsuccess";
		}
		return "addError";
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
	
	public ReplyService getService() {
		return service;
	}
	public void setService(ReplyService service) {
		this.service = service;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public Reply getModel() {
		return model;
	}
	public void setModel(Reply model) {
		this.model = model;
	}
	public List<Reply> getModels() {
		return models;
	}
	public void setModels(List<Reply> models) {
		this.models = models;
	}
}
