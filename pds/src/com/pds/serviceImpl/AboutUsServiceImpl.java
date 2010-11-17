/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.AboutUsDao;
import com.pds.model.AboutUs;
import com.pds.service.AboutUsService;

/**
 * @author xueshishasha
 *
 */
@Service
public class AboutUsServiceImpl extends BaseServiceImpl<AboutUs> implements
		AboutUsService {
	@Resource //传给父类用。
	public void setDao(AboutUsDao dao) {
		super.setDao(dao);
	}
}
