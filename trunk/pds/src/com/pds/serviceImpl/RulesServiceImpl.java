/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.RulesDao;
import com.pds.model.Rules;
import com.pds.service.RulesService;

/**
 * @author xueshishasha
 *
 */
@Service
public class RulesServiceImpl extends BaseServiceImpl<Rules> implements
	RulesService {
	@Resource //传给父类用。
	public void setDao(RulesDao dao) {
		super.setDao(dao);
	}
}
