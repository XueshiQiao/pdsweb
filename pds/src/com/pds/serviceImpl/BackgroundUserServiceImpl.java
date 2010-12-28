package com.pds.serviceImpl;
/**
 * BY qiaoxueshi at pingdingshan university
 */

import java.util.List;

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

	@Override
	public BackgroundUser login(BackgroundUser user) {
		List<BackgroundUser> users =  this.getDao().findByHql("from BackgroundUser where username=? and password = ?" , new String[]{user.getUsername(),user.getPassword()});
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}

	@Override
	public BackgroundUser login(String username, String password){
		return this.login(new BackgroundUser(username, password));
	}
	
	
}
