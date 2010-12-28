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
 * 自律委风采
 * @author xueshishasha
 *
 */
@Entity
public class UnionShow extends Article {
	
	
	//----------------下面是从父类中继承过来的getter，为了方便使用注解-----------------//
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
	public String getBrief() {
		return super.getBrief();
	}

	@Override
	@Column(length=4000)
	public String getContent() {
		return super.getContent();
	}

	@Override
	public Date getDate() {
		return super.getDate();
	}

	@Override
	public String getDep() {
		return super.getDep();
	}
	

	@Override
	public String getTitle() {
		return super.getTitle();
	}
}
