package com.pds.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 规章制度
 * @author xueshishasha
 *
 */
@Entity
public class Rules extends Article {
	
	
	//----------------下面是从父类中继承过来的getter，为了方便使用注解-----------------/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setAuthor(String author) {
		// TODO Auto-generated method stub
		super.setAuthor(author);
	}

	@Override
	public void setBrief(String brief) {
		// TODO Auto-generated method stub
		super.setBrief(brief);
	}

	@Override
	public void setContent(String content) {
		// TODO Auto-generated method stub
		super.setContent(content);
	}

	@Override
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		super.setDate(date);
	}

	@Override
	public void setDep(String dep) {
		// TODO Auto-generated method stub
		super.setDep(dep);
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		super.setTitle(title);
	}

	@Override
	public void setVisitedCount(int visitedCount) {
		// TODO Auto-generated method stub
		super.setVisitedCount(visitedCount);
	}

	
	
}
