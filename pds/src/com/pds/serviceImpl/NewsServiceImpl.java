/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.NewsDao;
import com.pds.model.News;
import com.pds.service.NewsService;

/**
 * @author xueshishasha
 *
 */
@Service
public class NewsServiceImpl extends BaseServiceImpl<News> implements
	NewsService {
	@Resource //传给父类用。
	public void setDao(NewsDao dao) {
		super.setDao(dao);
	}
}
