/**
 * BY qiaoxueshi at pingdingshan university
 */

package com.pds.daoImpl;
import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.LinkDao;
import com.pds.model.Link;


@Repository
public class LinkDaoImpl extends HibernateBaseDao<Link, Integer> implements
	LinkDao {

}
