package com.pds.daoImpl;
/**
 * BY qiaoxueshi at pingdingshan university
 */


import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.ReplyDao;
import com.pds.model.Reply;


@Repository
public class ReplyDaoImpl extends HibernateBaseDao<Reply, Integer> implements
	ReplyDao {

}
