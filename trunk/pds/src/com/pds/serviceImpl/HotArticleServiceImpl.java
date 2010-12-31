/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.common.page.Paginable;
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
	@Override
	public List<HotArticle> getTop10() {
		Paginable<HotArticle> page = getDao().findPageByHql("from HotArticle order by id desc",null,1, 10);
		if(page != null){
			return page.getList();
		}
		return null;
	}

	@Override
	public List<HotArticle> getTop10ByHot() {
//		return getDao().findByHql("from HotArticle order by visitedCount desc", null);
		Paginable<HotArticle> page = getDao().findPageByHql("from HotArticle order by visitedCount desc",null,1, 10);
		if(page != null){
			return page.getList();
		}
		return null;
	}
}
