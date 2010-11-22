/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.pds.common.utils.UUIDGenerator;
import com.pds.core.BaseAction;
import com.pds.model.FileUD;
import com.pds.service.FileService;

/**
 * @author qiaoxueshi
 *
 */
@Controller
public class FileUploadAction extends BaseAction {
	private static final long serialVersionUID = 5495728211877266147L;
	
	@Resource
	private FileService service;
	
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String realUploadPath;//实际存放的路径
	public static final String SAVE_PATH = "/uploads"; //上传路径当是upload时，存到webapps\pds\ uploads\网站策划案.doc
	public static final int BUFFER_SIZE = 1024; //上传时buffer的大小
	public static final String FILE_SEPARATE = "\\"; //文件分割符
	
	
	
	public String index(){
		return "index";
	}

	public String upload() throws Exception {
		String fileSuffix = uploadFileName.substring(uploadFileName.lastIndexOf(".")); //获得文件的后缀名
		String uuidFileName = UUIDGenerator.getUUID()+fileSuffix; //用uuid构造的名字
		String filePath = ServletActionContext.getServletContext().getRealPath(SAVE_PATH) + FILE_SEPARATE + uuidFileName;
		realUploadPath = filePath;
		
		//如果文件夹不存在就创建一个
		File _file  =new File(ServletActionContext.getServletContext().getRealPath(SAVE_PATH));
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
		
		//TODO 修改这里的上传用户为当前登录用户
		FileUD uploadFile = new FileUD(this.uploadFileName,this.upload.length()/1024,(SAVE_PATH+FILE_SEPARATE + uuidFileName),this.title,
							this.uploadContentType,filePath,1,""); 
		this.service.save(uploadFile);
		System.out.println(uploadFile);
		return "uploadSuccess";
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

	
	
	@Override
	public String toString() {
		return "FileUploadAction [realUploadPath=" + realUploadPath
				+ ", title=" + title + ", upload=" + upload
				+ ", uploadContentType=" + uploadContentType
				+ ", uploadFileName=" + uploadFileName + "]";
	}
	
}
