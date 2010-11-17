/**
 * BY qiaoxueshi at pingdingshan university
 */

package com.pds.daoImpl;
import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.NewsDao;
import com.pds.model.News;


@Repository
public class NewsDaoImpl extends HibernateBaseDao<News, Integer> implements
	NewsDao {

}
