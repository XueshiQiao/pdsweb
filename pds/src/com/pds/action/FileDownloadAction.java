/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import com.pds.core.BaseAction;
import com.pds.exception.FileNotFoundException;
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

	private int fileId;
	private String fileName;
	private String inputPath;// 指定要被下载的文件路径
	private FileUD file ;

	public InputStream getInputStream() throws Exception {
		FileUD  file = service.findById(fileId);
		InputStream stream ;
		if(file != null){
//			stream = ServletActionContext.getServletContext().getResourceAsStream("/"+inputPath + file.getFileName());			
			stream = ServletActionContext.getServletContext().getResourceAsStream("/"+file.getLocation());
			if(stream == null){
				throw new FileNotFoundException();
			}
			int count = file.getDownloadTimes();
			file.setDownloadTimes(count>0?count+1:1);
			service.update(file);
		}else{
			throw new FileNotFoundException();
		}
		return stream ;
		
//		System.out.println(this.request.getParameter("fileName"));
//		 通过 ServletContext，也就是application 来读取数据
//		System.out.println(fileName);
//		System.out.println(URLDecoder.decode(fileName));
//		System.out.println("inputPath="+inputPath+fileName);
//		System.out.println("/"+inputPath + fileName);
//		String s;
//		System.out.println(s = ServletActionContext.getServletContext().getRealPath("/"+inputPath + fileName));
//		System.out.println(s = ServletActionContext.getServletContext().getRealPath("/uploads/"+"abc.txt"));
//		InputStream stream = ServletActionContext.getServletContext().getResourceAsStream("/uploads/"+"abc.txt");
	}
	public String execute() throws Exception {
		/*FileUD  file = service.findById(fileId);
		if(file == null){
			return "fileNotFound";
		}
		File f = new File(ServletActionContext.getServletContext().getRealPath(file.getLocation()));
		if(!f.exists()){
			return "fileNotFound";
		}*/
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
		file = service.findById(fileId);
		String downFileName = file.getFileName();
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
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public String getInputPath() {
		return inputPath;
	}
	public FileUD getFile() {
		return file;
	}
	public void setFile(FileUD file) {
		this.file = file;
	}
	
}
