/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 通报批评
 * @author xueshishasha
 *
 */
@Entity
public class Criticism {
	
	private int id; 
	private String department; 	//院系
	private String content; //通报的内容
	private Date date; //日期

//	private String stuClass;//班级
//	private String reason;//通报的原因
//	private String stuName;//被通报的学生姓名
//	private String dormitory;//宿舍
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Column(length=4000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
//	public String getStuClass() {
//		return stuClass;
//	}
//	public void setStuClass(String stuClass) {
//		this.stuClass = stuClass;
//	}
//	public String getReason() {
//		return reason;
//	}
//	public void setReason(String reason) {
//		this.reason = reason;
//	}
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}
//	public String getStuName() {
//		return stuName;
//	}
//	public void setStuName(String stuName) {
//		this.stuName = stuName;
//	}
//	public String getDormitory() {
//		return dormitory;
//	}
//	public void setDormitory(String dormitory) {
//		this.dormitory = dormitory;
//	}

}
