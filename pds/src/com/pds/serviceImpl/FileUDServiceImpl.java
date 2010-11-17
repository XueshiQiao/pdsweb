/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.FileUDDao;
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
}
