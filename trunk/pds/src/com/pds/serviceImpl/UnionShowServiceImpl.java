/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.UnionShowDao;
import com.pds.model.UnionShow;
import com.pds.service.UnionShowService;

/**
 * @author xueshishasha
 *
 */
@Service
public class UnionShowServiceImpl extends BaseServiceImpl<UnionShow> implements
	UnionShowService {
	@Resource //传给父类用。
	public void setDao(UnionShowDao dao) {
		super.setDao(dao);
	}
}
