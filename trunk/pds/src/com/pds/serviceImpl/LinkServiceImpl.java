/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.LinkDao;
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
}
