/**
 * BY qiaoxueshi at pingdingshan university
 */

package com.pds.daoImpl;
import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.FileUDDao;
import com.pds.model.FileUD;


@Repository
public class FileUDDaoImpl extends HibernateBaseDao<FileUD, Integer> implements
	FileUDDao {

}
