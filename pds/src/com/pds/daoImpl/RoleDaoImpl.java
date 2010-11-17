/**
 * BY qiaoxueshi at pingdingshan university
 */

package com.pds.daoImpl;
import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.RoleDao;
import com.pds.model.Role;


@Repository
public class RoleDaoImpl extends HibernateBaseDao<Role, Integer> implements
	RoleDao {

}
