/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.CriticismDao;
import com.pds.model.Criticism;
import com.pds.service.CriticismService;

/**
 * @author xueshishasha
 *
 */
@Service
public class CriticismServiceImpl extends BaseServiceImpl<Criticism> implements
	CriticismService {
	@Resource //传给父类用。
	public void setDao(CriticismDao dao) {
		super.setDao(dao);
	}
}
