/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.common.page.Paginable;
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

	@Override
	public List<News> getTop10() {
//		return getDao().findByHql("from News order by date desc", null);
		Paginable<News> page = getDao().findPageByHql("from News order by id desc",null,1, 10);
		if(page != null){
			return page.getList();
		}
		return null;
	}

	@Override
	public List<News> getTop10ByHot() {
//		return getDao().findByHql("from News order by visitedCount desc", null);
		Paginable<News> page = getDao().findPageByHql("from News order by visitedCount desc",null,1, 10);
		if(page != null){
			return page.getList();
		}
		return null;
		
	}
	
	
}
