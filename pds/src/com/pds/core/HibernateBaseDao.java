package com.pds.core;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pds.common.page.PageModel;
import com.pds.common.page.Paginable;


public class HibernateBaseDao<T, ID extends Serializable> extends
		HibernateDaoSupport implements GenericDao<T, ID> {

	private Class<T> persistentClass = null;
	
	/**
	 * 我们之所以要在这里添加setMySessionFactory()方法,是因为要为DAO层的类注入sessionFactory这个属性。
	 * <注：HibernateDaoSupport里面的setMySessionFactory()方法是final的，不能覆写，所以这里起了一个不同的名字setMySessionFactory。> 
	 * 以后让所有的DAO类继承本类，就能直接拥有sessionFactory属性了。
	 * 其实，这样做是相当于配置文件方式的代码： 
	 * <bean id="userDao" class="com.oa.dao.UserDaoImpl">  
	 *	 <property name="sessionFactory" ref="sessionFactory"/>  
	 * </bean> 
	 */
	@Resource(name="sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	protected Query getQuery(Session session,String cmd) {
		Query query;
		try {
			query = session.getNamedQuery(cmd);//创建xml中声明的query名称
		} catch (HibernateException e) {
			try{
				query = session.createQuery(cmd);//否则创建Hibernate的SQL
			}catch (HibernateException ex) {
				query = session.createSQLQuery(cmd);//否则创建数据库SQL
			}
		}
		return query;
	}

	/*
	 * Cmd parameter is the named query's name. Please refer to Hibernate Named
	 * Query.
	 * 
	 * @see com.zybedu.dao.FindCmdDao#findCmd(java.lang.String,
	 *      java.lang.Object[], int, int)
	 */
	@SuppressWarnings("unchecked")
	public List findListByCmd(final String cmd ,
			final int page, final int count, final Object... params) {
		List result = null;
		Object o = this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = getQuery(session, cmd);
				if (params != null && params.length > 0) {
					int len = params.length;
					for (int i = 0; i < len; i++) {
						query.setParameter(i, params[i]);
					}
				}
				if (page > 0) {
					int maxResult = count;
					if (count < 1)
						maxResult = 1;
					int first = (page - 1) * maxResult;
					query.setFirstResult(first);
					query.setMaxResults(maxResult);
				} else {

				}
				List list = query.list();
				org.hibernate.Hibernate.initialize(list);
				return list;
			}
		});
		if (o != null)
			result = (List) o;
		return result;
	}

	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
		this.getSession().flush();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List list = this.getHibernateTemplate().loadAll(
				this.getPersistentClass());
		org.hibernate.Hibernate.initialize(list);
		return list;
	}

	public T getById(ID id) {
		return (T) this.getHibernateTemplate().get(this.getPersistentClass(),
				id);
	}

	public T saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	public T save(T entity) {
		this.getHibernateTemplate().save(entity);
		return entity;
	}

	public T update(T entity) {
		this.getHibernateTemplate().update(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public void executeDelOrUpdateHql(final String hql) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {

				Query query = getQuery(session, hql);
				query.executeUpdate();
				return null;
			}
		});
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getPersistentClass() {
		if (this.persistentClass == null) {
			this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return this.persistentClass;
	}

	@SuppressWarnings({ "unchecked"})
	public List<Map> findMapListByDynSql(String querySql ,final int page,
			final int count) {
		List result = null;
		final String fullHql = querySql;
		if (fullHql != null) {
			Object o = this.getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException {

							Query query = getQuery(session, fullHql);//创建sql对象

							if (page > 0) {
								int maxResult = count;
								if (count < 1)
									maxResult = 1;
								int first = (page - 1) * maxResult;
								query.setFirstResult(first);
								query.setMaxResults(maxResult);
							}
							return query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
						}
					});
			if (o != null)
				result = (List) o;
		}
		return result;
	}
	
	

	@SuppressWarnings("unchecked")
	public Object queryForCmd(String querySql , final Object... params) {
		Object result = null;
		final String fullHql = querySql;
		// LazyParser parser=parsers.get(cmd);
		
		this.getHibernateTemplate().setCacheQueries(true); //TODO 使用缓存 类似这里
		
		if (fullHql != null) {
			Object o = this.getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException {

							Query query  = getQuery(session, fullHql);
							if (params != null) {
								int len = params.length;
								for (int i = 0; i < len; i++) {
									query.setParameter(i, params[i]);
								}
							}
							return query.uniqueResult();
						}
					});
			if (o != null)
				result = o;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object queryForSingleResultMap(String querySql, final Object... params ) {
		Object result = null;
		final String fullHql = querySql;
		if (fullHql != null) {
			Object o = this.getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException {

							Query query  = getQuery(session, fullHql);
							if (params != null) {
								int len = params.length;
								for (int i = 0; i < len; i++) {
									query.setParameter(i, params[i]);
								}
							}
							return query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).uniqueResult();
						}
					});
			if (o != null)
				result = o;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Paginable<T> findPageByHql(final String hql, final Object[] paras,
			final int _pageNo, final int _pageSize) {
		
		final String wherehql = "select count(*) " + hql;
		//获得总记录数
		Long longValue =  this.getCountByHql(wherehql, paras);
		Integer totalCount = longValue.intValue();

		//调整后的页数
		final int  adjustedPageNo;
		//实际页面大小
		final int pageNo = _pageNo < 1 ? 1 : _pageNo;
		final int pageSize = _pageSize < 1 ? 10 : _pageSize;
//		if(pageNo < 1){
//			pageNo = 1;
//			//throw new RuntimeException( "["+this.getClass().getName()+"]请求的页面要不能小于1");
//		}
//		if(pageSize < 1){
//			throw new RuntimeException("["+this.getClass().getName()+"]请求的页面大小要不能小于1");
//		}
		int realPageSize = totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1); 
		//如果要求页数比实际的页面大小要大，则返回最后一页
		if(pageNo > realPageSize){
			adjustedPageNo = realPageSize;
		}else{
			adjustedPageNo = pageNo;
		}
		
		//查找记录
		List<T> list = (List<T>)getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = (Query) session.createQuery(hql);
				if (paras != null) {
					for (int i = 0; i < paras.length; i++) {
						query.setParameter(i, paras[i]);
					}
				}
				query.setFirstResult((adjustedPageNo-1) * pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
		PageModel<T> pageModel = new PageModel<T>(list, totalCount, adjustedPageNo, pageSize);
//		System.out.println(pageModel.getList().size());
		return pageModel;
	}
	
	
	@Override
	public Paginable<T> findPageByHql(int pageNo, int pageSize) {
		return this.findPageByHql("from "+this.getPersistentClass().getSimpleName(), null, pageNo, pageSize);
	}

	@Override
	public Paginable<T> findPageByHql(int pageNo) {
		return this.findPageByHql("from "+this.getPersistentClass().getSimpleName(), null, pageNo, 10);
	}

	@Override
	public Long getCountByHql(final String hql, final Object[] paras) {
		Long longValue = getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);   
				if (paras != null) {
					for (int i = 0; i < paras.length; i++) {
						query.setParameter(i, paras[i]);
					}
				}
				return ((Long)query.uniqueResult());
			}
		});
		return longValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHql(final String hql, final Object[] params) {
		List<T> result = null;
		Object o = this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = getQuery(session, hql);
				if (params != null && params.length > 0) {
					int len = params.length;
					for (int i = 0; i < len; i++) {
						query.setParameter(i, params[i]);
					}
				}
				List list = query.list();
				return list;
			}
		});
		if (o != null)
			result = (List<T>) o;
		return result;
	}
	
}

/*
1. 例如: objectDao.queryForCmd("select usercode,passwd,did,pid from s_user t where t.did = 1") 返回的是长度为4的一个数组

2. 例如: SUser user = (SUser) genericDao.queryForCmd("from com.jj.demo.hbm.SUser as u where u.did = 1"); 返回的是SUser对象

3. 例如: objectDao.queryForSingleResultMap("select * from F_D_FILE1 where did = ?",3); 返回单条记录为一个map

4. 例如: objectDao.queryForCmd("from com.jj.demo.hbm.FDFile as fd where fd.fieldname = ?","CREATOR"); 返回为一个FDFile对象

5. 例如: objectDao.findMapListByDynSql("select * from d_file1", -1, -1); 返回为每条记录为一个map的多条记录list

6. 例如: objectDao.queryForCmd("select count(*) from s_all"); 返回为一个结果obj . 可转换为整型


Java代码 
	List<Map> ls =  objectDao.findMapListByDynSql("select * from D_FILE1", 1, 30);   
    for (Map map : ls) {   
        System.out.println(map.get("TITLE"));   
	}  
 */
