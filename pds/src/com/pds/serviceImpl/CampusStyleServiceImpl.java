/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.CampusStyleDao;
import com.pds.model.CampusStyle;
import com.pds.service.CampusStyleService;

/**
 * @author xueshishasha
 *
 */
@Service
public class CampusStyleServiceImpl extends BaseServiceImpl<CampusStyle> implements
	CampusStyleService {
	@Resource //传给父类用。
	public void setDao(CampusStyleDao dao) {
		super.setDao(dao);
	}
}
