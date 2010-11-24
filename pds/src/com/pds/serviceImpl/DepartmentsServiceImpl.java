/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import java.util.List;

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

	@Override
	public Departments getRecentDepartment() {
		List<Departments> deps = this.findByHql("from Departments where id = (select max(id) from Departments)", null);
		if(deps != null && deps.size() > 0 ){
			return deps.get(0);
		}
		return new Departments();
	}
	
	
}
