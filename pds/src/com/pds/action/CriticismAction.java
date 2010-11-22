/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pds.common.page.Paginable;
import com.pds.core.BaseAction;
import com.pds.model.AboutUs;
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
	
	public CriticismService getService() {
		return service;
	}
	public void setService(CriticismService service) {
		this.service = service;
	}
	
}
