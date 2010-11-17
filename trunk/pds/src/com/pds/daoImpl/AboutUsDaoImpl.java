/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.daoImpl;


import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.AboutUsDao;
import com.pds.model.AboutUs;


@Repository
public class AboutUsDaoImpl extends HibernateBaseDao<AboutUs, Integer> implements
		AboutUsDao {
	
}
