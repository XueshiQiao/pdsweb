package com.pds.serviceImpl;
/**
 * BY qiaoxueshi at pingdingshan university
 */

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.BackgroundUserDao;
import com.pds.model.BackgroundUser;
import com.pds.service.BackgroundUserService;

/**
 * @author xueshishasha
 *
 */
@Service
public class BackgroundUserServiceImpl extends BaseServiceImpl<BackgroundUser> implements
	BackgroundUserService {
	@Resource //传给父类用。
	public void setDao(BackgroundUserDao dao) {
		super.setDao(dao);
	}
}
