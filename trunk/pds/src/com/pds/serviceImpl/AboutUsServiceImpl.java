/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;

import java.util.List;

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
	
	@Override
	public AboutUs getRecentAboutUs() {
		List<AboutUs> aboutuses = this.findByHql("from AboutUs where id = (select max(id) from AboutUs)", null);
		if(aboutuses != null && aboutuses.size() > 0 ){
			return aboutuses.get(0);
		}
		AboutUs au = new AboutUs();
		au.setIntroduction("暂无信息");
		return au;
	}
}
