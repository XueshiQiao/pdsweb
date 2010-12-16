package com.pds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 后台登陆管理用户
 * @author xueshishasha
 *
 */
@Entity
@Table(name="backGroundUser")
public class BackgroundUser {
	private int id;
	private String username; //用户名
	private String password; 	//密码
	private int role; //角色
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=16)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(length=16)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}
