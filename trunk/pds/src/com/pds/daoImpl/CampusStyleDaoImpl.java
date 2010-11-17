/**
 * BY qiaoxueshi at pingdingshan university
 */

package com.pds.daoImpl;
import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.CampusStyleDao;
import com.pds.model.CampusStyle;


@Repository
public class CampusStyleDaoImpl extends HibernateBaseDao<CampusStyle, Integer> implements
	CampusStyleDao {

}
