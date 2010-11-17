/**
 * BY qiaoxueshi at pingdingshan university
 */

package com.pds.daoImpl;
import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.DepartmentsDao;
import com.pds.model.Departments;


@Repository
public class DepartmentsDaoImpl extends HibernateBaseDao<Departments, Integer> implements
	DepartmentsDao {

}
