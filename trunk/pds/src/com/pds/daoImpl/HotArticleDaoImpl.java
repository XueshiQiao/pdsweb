/**
 * BY qiaoxueshi at pingdingshan university
 */

package com.pds.daoImpl;
import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.HotArticleDao;
import com.pds.model.HotArticle;


@Repository
public class HotArticleDaoImpl extends HibernateBaseDao<HotArticle, Integer> implements
	HotArticleDao {

}
