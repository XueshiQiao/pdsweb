/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.service;

import java.util.List;

import com.pds.core.BaseService;

/**
 * @author qiaoxueshi
 * 通用的Get Top X Sercice
 */

public interface CommonGetTopXService<T> extends BaseService<T> {
	
	/**
	 * 根据最新发布的前十
	 * @return
	 */
	public List<T> getTop10(); 
	
	/**
	 * 得到前十 根据访问量或者下载量
	 * @return
	 */
	public List<T> getTop10ByHot(); 
}
