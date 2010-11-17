/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.pds.core.BaseServiceImpl;
import com.pds.dao.FileDao;
import com.pds.model.FileUD;
import com.pds.service.FileService;

/**
 * @author xueshishasha
 *
 */
@Service
public class FileServiceImpl extends BaseServiceImpl<FileUD> implements
		FileService {
	@Resource //传给父类用。
	public void setDao(FileDao dao) {
		super.setDao(dao);
	}
}
