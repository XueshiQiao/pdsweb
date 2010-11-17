/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.DepartmentsDao;
import com.pds.model.Departments;
import com.pds.service.DepartmentsService;

/**
 * @author xueshishasha
 *
 */
@Service
public class DepartmentsServiceImpl extends BaseServiceImpl<Departments> implements
	DepartmentsService {
	@Resource //传给父类用。
	public void setDao(DepartmentsDao dao) {
		super.setDao(dao);
	}
}
