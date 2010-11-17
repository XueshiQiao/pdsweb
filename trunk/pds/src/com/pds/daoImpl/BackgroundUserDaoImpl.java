package com.pds.daoImpl;
/**
 * BY qiaoxueshi at pingdingshan university
 */


import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.BackgroundUserDao;
import com.pds.model.BackgroundUser;


@Repository
public class BackgroundUserDaoImpl extends HibernateBaseDao<BackgroundUser, Integer> implements
	BackgroundUserDao {

}
