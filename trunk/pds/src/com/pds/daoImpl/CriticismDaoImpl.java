/**
 * BY qiaoxueshi at pingdingshan university
 */

package com.pds.daoImpl;
import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.CriticismDao;
import com.pds.model.Criticism;


@Repository
public class CriticismDaoImpl extends HibernateBaseDao<Criticism, Integer> implements
	CriticismDao {

}
