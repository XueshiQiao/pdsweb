/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.common.page;

import java.util.List;

/**
 * @author qiaoxueshi
 *
 * @param <T>
 */
public interface Paginable<T> {
	
	/**
	 * 是否是最后一页
	 * @return
	 */
	public boolean isLastPage();

	/**
	 * 得到总的页数
	 * @return
	 */
	public int getPageCount();
	
	/**
	 * 每页大小
	 * @return
	 */
	public int getPageSize();

	/**
	 * 总记录数
	 * @return
	 */
	public int getTotalCount();

	/**
	 * 是否是第一页
	 * @return
	 */
	public boolean isFirstPage();

	/**
	 * 得到List格式数据
	 * @return
	 */
	public List<T> getList();

	/**
	 * 得到当前是第几页
	 * @return
	 */
	public int getPageNo();

}