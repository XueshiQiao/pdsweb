/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.pds.core.BaseAction;
import com.pds.model.FileUD;
import com.pds.service.FileService;

/**
 * @author qiaoxueshi
 * 
 */
@Controller
public class FileDownloadAction extends BaseAction{
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private FileService service;

	private String fileName;// 初始的通过param指定的文件名属性

	private String inputPath;// 指定要被下载的文件路径

	public InputStream getInputStream() throws Exception {

		System.out.println(this.request.getParameter("fileName"));
		// 通过 ServletContext，也就是application 来读取数据
		System.out.println(fileName);
		System.out.println(URLDecoder.decode(fileName));
		System.out.println("inputPath="+inputPath+fileName);
		System.out.println("/"+inputPath + fileName);
		String s;
		System.out.println(s = ServletActionContext.getServletContext().getRealPath("/"+inputPath + fileName));
		InputStream stream = ServletActionContext.getServletContext().getResourceAsStream(
				ServletActionContext.getServletContext().getRealPath("/"+inputPath + fileName));
		
		System.out.println(stream == null);
		return stream ;
	}
	public String execute() throws Exception {
		return SUCCESS;
	}
	public void setInputPath(String value) {
		inputPath = value;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/** 提供转换编码后的供下载用的文件名 */

	public String getDownloadFileName() {
		String downFileName = fileName;
		try {
			downFileName = new String(downFileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return downFileName;
	}
	
	public FileService getService() {
		return service;
	}
	public void setService(FileService service) {
		this.service = service;
	}
	
	
}
