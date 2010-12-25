/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pds.common.page.Paginable;
import com.pds.core.BaseAction;
import com.pds.model.FileUD;
import com.pds.service.FileUDService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class FileUDAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;

	@Resource
	private FileUDService service ;
	
	protected static final int DEFAULT_PAGE_SIZE = 10;
	
	private int fileId; 	//请求的文章的id
	private int filePageNo;	//请求的页数
	private Paginable<FileUD> filePageModel;  //页面上的数据
	private FileUD file; 
	

	
	/**
	 * 需要传递artPageNo参数
	 * @return
	 */
	public String listFiles(){
		if(filePageNo < 1 ){
			filePageNo = 1; //默认载入第一页
		}
		try{
			filePageModel = service.findPageByHql(filePageNo,DEFAULT_PAGE_SIZE);
			if(filePageModel == null){
				return "pageNotFound";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "pageNotFound";
		}
		
		return "toListFilePage";
	}
	
	/**
	 * 需要传递artId参数 
	 * @return
	 */
	public String file(){
		if( fileId < 1 ){
			return "pageNotFound";
		}
		try{
			file = service.findById(fileId);
			if(file == null){
				return "pageNotFound";
			}
			service.saveOrUpdate(file);
		}catch(Exception e){
			e.printStackTrace();
			return "pageNotFound";
		}
		return "toFilePage";
	}
	
	
	public FileUDService getService() {
		return service;
	}
	public void setService(FileUDService service) {
		this.service = service;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getFilePageNo() {
		return filePageNo;
	}

	public void setFilePageNo(int filePageNo) {
		this.filePageNo = filePageNo;
	}

	public Paginable<FileUD> getFilePageModel() {
		return filePageModel;
	}

	public void setFilePageModel(Paginable<FileUD> filePageModel) {
		this.filePageModel = filePageModel;
	}

	public FileUD getFile() {
		return file;
	}

	public void setFile(FileUD file) {
		this.file = file;
	}
}
