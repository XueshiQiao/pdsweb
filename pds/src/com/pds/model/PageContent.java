package com.pds.model;

import java.util.Date;
/**
 * 所有单页显示内容的父类
 * @author xueshishasha
 *
 */
public class PageContent {
	
	private int id; //id
	private String content; //内容 
	private String author; //作者
	private Date date; //日期
	private int visitedCount = 0; //点击量/访问量
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getVisitedCount() {
		return visitedCount;
	}
	public void setVisitedCount(int visitedCount) {
		this.visitedCount = visitedCount;
	}
	
}
