package com.pds.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 部门设置
 * @author xueshishasha
 *
 */
@Entity
public class Departments extends PageContent {

	//----------------下面是从父类中继承过来的getter，为了方便使用注解-----------------/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Override
	public int getId() {
		return super.getId();
	}

	@Override
	public String getAuthor() {
		return super.getAuthor();
	}

	@Override
	public String getContent() {
		return super.getContent();
	}

	@Override
	public Date getDate() {
		return super.getDate();
	}


	@Override
	public int getVisitedCount() {
		return super.getVisitedCount();
	}
}
