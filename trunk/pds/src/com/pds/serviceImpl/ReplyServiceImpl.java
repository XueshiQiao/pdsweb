package com.pds.serviceImpl;
/**
 * BY qiaoxueshi at pingdingshan university
 */

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pds.core.BaseServiceImpl;
import com.pds.dao.ReplyDao;
import com.pds.model.Reply;
import com.pds.service.ReplyService;

/**
 * @author xueshishasha
 *
 */
@Service
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements
	ReplyService {
	@Resource //传给父类用。
	public void setDao(ReplyDao dao) {
		super.setDao(dao);
	}
}
