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
public class Rules extends PageContent {
	
	
	//----------------下面是从父类中继承过来的getter，为了方便使用注解-----------------/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return super.getAuthor();
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return super.getContent();
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return super.getDate();
	}


	@Override
	public int getVisitedCount() {
		// TODO Auto-generated method stub
		return super.getVisitedCount();
	}
	
}
