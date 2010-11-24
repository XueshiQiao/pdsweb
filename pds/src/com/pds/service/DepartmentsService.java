/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.service;
import com.pds.core.BaseService;
import com.pds.model.Departments;

public interface DepartmentsService extends BaseService<Departments> {
	/**
	 * 得到最新的一条Departments记录
	 * 如果数据库中不存在的话就返回一条新的记录
	 * @return
	 */
	public Departments getRecentDepartment();
}
