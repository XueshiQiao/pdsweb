package com.pds.service;
/**
 * BY qiaoxueshi at pingdingshan university
 */

import com.pds.core.BaseService;
import com.pds.model.BackgroundUser;

public interface BackgroundUserService extends BaseService<BackgroundUser> {
	
	public BackgroundUser login(BackgroundUser user);
	public BackgroundUser login(String username,String password);
}
