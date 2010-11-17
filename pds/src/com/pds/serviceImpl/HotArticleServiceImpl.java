/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.HotArticleDao;
import com.pds.model.HotArticle;
import com.pds.service.HotArticleService;

/**
 * @author xueshishasha
 *
 */
@Service
public class HotArticleServiceImpl extends BaseServiceImpl<HotArticle> implements
	HotArticleService {
	@Resource //传给父类用。
	public void setDao(HotArticleDao dao) {
		super.setDao(dao);
	}
}
