/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.pds.common.page.Paginable;

/**
 * BaseService的一个实现.
 * @author xueshishasha
 *
 */
public class BaseServiceImpl<T> implements BaseService<T> {
	
	//这里不注入了，因为所有的dao都是实现了GenericDao，造成了不唯一性。
	//把Dao的注入推迟到子类中，在此类中调用super.setDao()。
	private GenericDao<T,Integer> dao;
	
	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	public T deleteById(Serializable id) {
		T o = dao.getById((Integer)id);
		if(o!=null){
			dao.delete(o);
		}
		return o;
	}

	@Override
	public List<T> deleteById(Serializable[] ids) {
		List<T> list = new ArrayList<T>();
		for(int i = 0;i<ids.length;i++){
			T o = dao.getById((Integer)ids[i]);
			if(o!=null){
				list.add(o);
				dao.delete(o);
			}
		}
		return list;
	}

	@Override
	public List<T> findAll() {
		return dao.findAll();
	}

	@Override
	public T findById(Serializable id) {
		return dao.getById((Integer)id);
	}

	@Override
	public T load(Serializable id) {
		
		return dao.getById((Integer)id);
	}

	@Override
	public T save(T entity) {
		return dao.save(entity);
		
	}

	@Override
	public T saveOrUpdate(T entity) {
		return dao.saveOrUpdate(entity);
	}

	@Override
	public T update(T entity) {
		return dao.update(entity);
	}

	public GenericDao<T, Integer> getDao() {
		return dao;
	}

	public void setDao(GenericDao<T, Integer> dao) {
		this.dao = dao;
	}

	@Override
	public Paginable<T> findPageByHql(final String hql, final Object[] paras,final int pageNo,
			final int pageSize) {
		
		return dao.findPageByHql(hql, paras, pageNo, pageSize);
	}

	@Override
	public Paginable<T> findPageByHql(int pageNo, int pageSize) {
		return dao.findPageByHql(pageNo, pageSize);
	}

	@Override
	public Paginable<T> findPageByHql(int pageNo) {
		return dao.findPageByHql(pageNo);
	}

	@Override
	public List<T> findByHql(String hql, Object[] params) {
		return dao.findByHql(hql, params);
	}
	

}
