/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.FileUDDao;
import com.pds.model.Criticism;
import com.pds.model.FileUD;
import com.pds.service.FileUDService;

/**
 * @author xueshishasha
 *
 */
@Service
public class FileUDServiceImpl extends BaseServiceImpl<FileUD> implements
	FileUDService {
	@Resource //传给父类用。
	public void setDao(FileUDDao dao) {
		super.setDao(dao);
	}
	
	@Override
	public List<FileUD> getTop10() {
		return getDao().findByHql("from FileUD order by date desc", null);
	}

	@Override
	public List<FileUD> getTop10ByHot() {
		return getDao().findByHql("from FileUD order by downloadTimes desc", null);
	}
}
