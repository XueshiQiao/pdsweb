/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pds.common.utils.UUIDGenerator;
import com.pds.core.BaseAction;
import com.pds.model.BackgroundUser;
import com.pds.model.FileUD;
import com.pds.service.FileService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
@Scope(value="prototype")
public class FileUploadAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;
	
	@Resource
	private FileService service;
	
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String realUploadPath;//实际存放的路径
	private String savePath ="/uploads"; //默认值，可以在action中动态配置。上传路径当是upload时，存到webapps\pds\ uploads\网站策划案.doc
	public static final int BUFFER_SIZE = 1024; //上传时buffer的大小
	public static final String FILE_SEPARATE = "/"; //文件分割符

	
	//CKEDITOR上传图片用到
	private String CKEditorFuncNum;   
	private String CKEditor;
	
	private String  ajaxResult;
	
	public String index(){
		return "index";
	}

	public String upload() throws Exception {
		
		int dotPos = uploadFileName.lastIndexOf(".");
		String fileSuffix = ""; 
		if(dotPos > 0){
			 fileSuffix = uploadFileName.substring(dotPos); //获得文件的后缀名
		}
		String uuidFileName = UUIDGenerator.getUUID()+fileSuffix; //用uuid构造的名字
		String filePath = ServletActionContext.getServletContext().getRealPath(savePath) + FILE_SEPARATE + uuidFileName;
		realUploadPath = filePath;
		
		//如果文件夹不存在就创建一个
		File _file  =new File(ServletActionContext.getServletContext().getRealPath(savePath));
		if(!_file.exists()){
			_file.mkdir();
		}
		System.out.println(filePath);
		FileOutputStream fos = new FileOutputStream(filePath);
		FileInputStream fis = new FileInputStream(this.upload);
		byte[] buffer = new byte[BUFFER_SIZE];
		int len = 0;
		while((len= fis.read(buffer)) > 0){
			fos.write(buffer, 0, len);
		}
		//TODO DELETE
//		System.out.println(this);
		
		BackgroundUser user = (BackgroundUser)this.session.get(BackgroundUserAction.USER_LOGIN_KEY);
		//TODO 修改这里的上传用户为当前登录用户
		String username = user == null? "匿名":user.getUsername(); 
		FileUD uploadFile = new FileUD(this.uploadFileName,this.upload.length()/1024,(savePath+FILE_SEPARATE + uuidFileName),this.title,
							this.uploadContentType,filePath,username,"",new Date()); 
		this.service.save(uploadFile);
		System.out.println(uploadFile);
		return "uploadSuccess";
	}
	
	public String ckeditorUpload() throws Exception {
		try{
			int dotPos = uploadFileName.lastIndexOf(".");
			String fileSuffix = ""; 
			if(dotPos > 0){
				 fileSuffix = uploadFileName.substring(dotPos); //获得文件的后缀名
			}
			String uuidFileName = UUIDGenerator.getUUID()+fileSuffix; //用uuid构造的名字
			String filePath = ServletActionContext.getServletContext().getRealPath(savePath) + FILE_SEPARATE + uuidFileName;
			realUploadPath = filePath;
			
			//如果文件夹不存在就创建一个
			File _file  =new File(ServletActionContext.getServletContext().getRealPath(savePath));
			if(!_file.exists()){
				_file.mkdir();
			}
			System.out.println(filePath);
			FileOutputStream fos = new FileOutputStream(filePath);
			FileInputStream fis = new FileInputStream(this.upload);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while((len= fis.read(buffer)) > 0){
				fos.write(buffer, 0, len);
			}	
//			BackgroundUser user = (BackgroundUser)this.session.get(BackgroundUserAction.USER_LOGIN_KEY);
//			//TODO 修改这里的上传用户为当前登录用户
//			String username = user == null? "匿名":user.getUsername(); 
//			FileUD uploadFile = new FileUD(this.uploadFileName,this.upload.length()/1024,(savePath+FILE_SEPARATE + uuidFileName),this.title,
//								this.uploadContentType,filePath,username,"",new Date()); 
//			this.service.save(uploadFile);
			PrintWriter out = this.response.getWriter();   
			//返回给ckeditor   
			out.write("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("+this.CKEditorFuncNum+", '" + this.savePath + "/" + uuidFileName+"', '');</script>");   
			return NONE; 
		}catch(Exception e){
			return ERROR;
		}
		
		
	}
	
	/**
	 * 普通方式上传文件， 但是以json格式返回结果
	 * @return
	 * @throws Exception
	 */
	public String ajaxUpload() throws Exception {
		try{
			int dotPos = uploadFileName.lastIndexOf(".");
			String fileSuffix = ""; 
			if(dotPos > 0){
				fileSuffix = uploadFileName.substring(dotPos); //获得文件的后缀名
			}
			String uuidFileName = UUIDGenerator.getUUID()+fileSuffix; //用uuid构造的名字
			String filePath = ServletActionContext.getServletContext().getRealPath(savePath) + FILE_SEPARATE + uuidFileName;
			realUploadPath = filePath;
			
			//如果文件夹不存在就创建一个
			File _file  =new File(ServletActionContext.getServletContext().getRealPath(savePath));
			if(!_file.exists()){
				_file.mkdir();
			}
			System.out.println(filePath);
			FileOutputStream fos = new FileOutputStream(filePath);
			FileInputStream fis = new FileInputStream(this.upload);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while((len= fis.read(buffer)) > 0){
				fos.write(buffer, 0, len);
			}
			//TODO DELETE
			System.out.println(this);
			
			BackgroundUser user = (BackgroundUser)this.session.get(BackgroundUserAction.USER_LOGIN_KEY);
			//TODO 修改这里的上传用户为当前登录用户
			String username = user == null? "匿名":user.getUsername(); 
			FileUD uploadFile = new FileUD(this.uploadFileName,this.upload.length()/1024,(savePath+FILE_SEPARATE + uuidFileName),this.title,
					this.uploadContentType,filePath,username,"",new Date()); 
			this.service.save(uploadFile);
		}catch(Exception e){
			this.ajaxResult="error";
			return "error";
		}
		this.ajaxResult = "success";
		return "success";
	}

	public FileService getService() {
		return service;
	}

	public void setService(FileService service) {
		this.service = service;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getRealUploadPath() {
		return realUploadPath;
	}

	public void setRealUploadPath(String realUploadPath) {
		this.realUploadPath = realUploadPath;
	}
	
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	@Override
	public String toString() {
		return "FileUploadAction [realUploadPath=" + realUploadPath
				+ ", title=" + title + ", upload=" + upload
				+ ", uploadContentType=" + uploadContentType
				+ ", uploadFileName=" + uploadFileName + "]";
	}

	public String getAjaxResult() {
		return ajaxResult;
	}

	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}

	public String getCKEditorFuncNum() {
		return CKEditorFuncNum;
	}

	public void setCKEditorFuncNum(String cKEditorFuncNum) {
		CKEditorFuncNum = cKEditorFuncNum;
	}

	public String getCKEditor() {
		return CKEditor;
	}

	public void setCKEditor(String cKEditor) {
		CKEditor = cKEditor;
	}
}
