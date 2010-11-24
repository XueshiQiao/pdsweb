/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.core;

import java.io.Serializable;
import java.util.List;

import com.pds.common.page.Paginable;


/**
 * 最基本的Service实现，系统中所有的Service都实现此接口
 * @author xueshishasha
 *
 * @param <T>
 */
public interface BaseService<T> {
	
	/**
	 * 通过ID查找对象
	 * 
	 * @param id
	 *            记录的ID
	 * @return 实体对象
	 */
	public T findById(Serializable id);

	public T load(Serializable id);

	/**
	 * 查找所有对象
	 * 
	 * @return 对象列表
	 */
	public List<T> findAll();

	/**
	 * 查找分页数据
	 * @param hql  hql查询语句
	 * @param paras 参数
	 * @param pageNo 查询第几页
	 * @param pageSize 每页大小
	 * @return 分页对象
	 */
	public Paginable<T> findPageByHql(String hql,Object[] paras,int pageNo, int pageSize);
	
	/**
	 * 得到第pageNo页的分页数据
	 * hql默认为from T
	 * paras 默认为空
	 * pageSize默认为10
	 * @param pageNo
	 * @return
	 */
	public Paginable<T> findPageByHql(int pageNo);
	
	/**
	 * 得到第pageNo页的分页数据,按每页pageSize条数据分页
	 * hql默认为from T
	 * paras 默认为空
	 * @param pageNo
	 * @return
	 */
	public Paginable<T> findPageByHql(int pageNo,int pageSize);
	
	/**
	 * 保存对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 操作信息
	 */
	public T save(T entity);

	public T update(T entity);

	public T saveOrUpdate(T entity);

	public void delete(T entity);

	/**
	 * 根据ID删除记录
	 * 
	 * @param id
	 *            记录ID
	 */
	public T deleteById(Serializable id);

	/**
	 * 根据ID数组删除记录，当发生异常时，操作终止并回滚
	 * 
	 * @param ids
	 *            记录ID数组
	 * @return 删除的对象
	 */
	public List<T> deleteById(Serializable[] ids);
	
	/**
	 * 根据hql和参数得到对象列表
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<T> findByHql(final String hql, final Object[] params);

	
	
}
