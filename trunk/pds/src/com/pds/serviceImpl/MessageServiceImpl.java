/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.serviceImpl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.MessageDao;
import com.pds.model.Message;
import com.pds.service.MessageService;

/**
 * @author xueshishasha
 *
 */
@Service
public class MessageServiceImpl extends BaseServiceImpl<Message> implements
	MessageService {
	@Resource //传给父类用。
	public void setDao(MessageDao dao) {
		super.setDao(dao);
	}
}
