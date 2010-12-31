/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.common.page.Paginable;
import com.pds.core.BaseServiceImpl;
import com.pds.dao.LinkDao;
import com.pds.model.Criticism;
import com.pds.model.FileUD;
import com.pds.model.Link;
import com.pds.service.LinkService;

/**
 * @author xueshishasha
 *
 */
@Service
public class LinkServiceImpl extends BaseServiceImpl<Link> implements
	LinkService {
	@Resource //传给父类用。
	public void setDao(LinkDao dao) {
		super.setDao(dao);
	}
	
	@Override
	public List<Link> getTop10() {
//		return getDao().findByHql("from Link order by sortId", null);
		Paginable<Link> page = getDao().findPageByHql("from Link order by sortId",null,1, 10);
		if(page != null){
			return page.getList();
		}
		return null;
	}

	@Override
	public List<Link> getTop10ByHot() {
		Paginable<Link> page = getDao().findPageByHql("from Link order by sortId",null,1, 10);
		if(page != null){
			return page.getList();
		}
		return null;
//		return getDao().findByHql("from Link order by sortId", null);
	}
	
}
