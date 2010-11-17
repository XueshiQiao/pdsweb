/**
 * BY qiaoxueshi at pingdingshan university
 */

package com.pds.daoImpl;
import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.UnionShowDao;
import com.pds.model.UnionShow;


@Repository
public class UnionShowDaoImpl extends HibernateBaseDao<UnionShow, Integer> implements
	UnionShowDao {

}
