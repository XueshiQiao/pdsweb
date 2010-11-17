package com.pds.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 关于我们模块。
 * @author xueshishasha
 *
 */

@Entity
@Table(name="aboutUs")
public class AboutUs {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id; //id
	@Column(length=1024)
	private String introduction; // 简介
	@Column(length=1024)
	private String competency; //职能
	@Column(length=4096)
	private String history; //自律委发展（过去与现在）
	@Column(length=1024)
	private String contact; //联系方式
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getCompetency() {
		return competency;
	}
	public void setCompetency(String competency) {
		this.competency = competency;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "AboutUs [competency=" + competency + ", contact=" + contact
				+ ", history=" + history + ", id=" + id + ", introduction="
				+ introduction + "]";
	}
	
	
	
	
}
