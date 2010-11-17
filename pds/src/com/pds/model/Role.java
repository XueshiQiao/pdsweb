/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 后台管理用户角色
 * @author xueshishasha
 *
 */

@Entity
public class Role {
	private int id; 
	private String name; //角色名
	private String rights; //权限
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	
	
}
