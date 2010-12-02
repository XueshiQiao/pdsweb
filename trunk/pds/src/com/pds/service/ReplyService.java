package com.pds.service;
/**
 * BY qiaoxueshi at pingdingshan university
 */

import java.util.List;

import com.pds.core.BaseService;
import com.pds.model.Reply;

public interface ReplyService extends BaseService<Reply> {
	/**
	 * 根据pId得到所有的回复
	 * @param pId
	 * @return
	 */
	public List<Reply> getReplysByPId(int pId);
}
