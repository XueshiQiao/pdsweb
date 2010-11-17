/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.daoImpl;


import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.FileDao;
import com.pds.model.FileUD;


@Repository
public class FileDaoImpl extends HibernateBaseDao<FileUD, Integer> implements
	FileDao {

}
