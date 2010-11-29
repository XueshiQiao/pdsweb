/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文件上传下载
 * @author xueshishasha
 *
 */

@Entity
@Table(name="file")
public class FileUD {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String fileName; //原文件名
	private long size; //单位kb
	private String location; //存放在服务器上的位置，文件名是用uuid产生的
	private String remark; //备注
	
	private String title; //标题
	private String contentType; // contentType
	private String realUploadPath;//实际存放的路径,绝对路径  文件名是用uuid产生的
	private String uploader; //上传者id
	private Date date;//上传时间
	private int downloadTimes ;//下载次数
	
	
	
	/**
	 * @param fileName
	 * @param size
	 * @param type
	 * @param location
	 * @param remark
	 * @param title
	 * @param contentType
	 * @param realUploadPath
	 * @param uploader
	 */
	public FileUD(String fileName, long size, String location, String title, String contentType,
			String realUploadPath, String uploader,String remark,Date date) {
		this.fileName = fileName;
		this.size = size;
		this.location = location;
		this.remark = remark;
		this.title = title;
		this.contentType = contentType;
		this.realUploadPath = realUploadPath;
		this.uploader = uploader;
		this.date = date;
		this.downloadTimes = 0;
	}
	
	
	public FileUD() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getUploader() {
		return this.uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getRealUploadPath() {
		return realUploadPath;
	}
	public void setRealUploadPath(String realUploadPath) {
		this.realUploadPath = realUploadPath;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDownloadTimes() {
		return downloadTimes;
	}

	public void setDownloadTimes(int downloadTimes) {
		this.downloadTimes = downloadTimes;
	}


	@Override
	public String toString() {
		return "FileUD [contentType=" + contentType + ", date=" + date
				+ ", downloadTimes=" + downloadTimes + ", fileName=" + fileName
				+ ", id=" + id + ", location=" + location + ", realUploadPath="
				+ realUploadPath + ", remark=" + remark + ", size=" + size
				+ ", title=" + title + ", uploader=" + uploader + "]";
	}

	
}
