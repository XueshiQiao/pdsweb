/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.RoleDao;
import com.pds.model.Role;
import com.pds.service.RoleService;

/**
 * @author xueshishasha
 *
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements
	RoleService {
	@Resource //传给父类用。
	public void setDao(RoleDao dao) {
		super.setDao(dao);
	}
}
