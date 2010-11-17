/**
 * BY qiaoxueshi at pingdingshan university
 */

package com.pds.daoImpl;
import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.MessageDao;
import com.pds.model.Message;


@Repository
public class MessageDaoImpl extends HibernateBaseDao<Message, Integer> implements
	MessageDao {

}
