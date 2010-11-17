/**
 * BY qiaoxueshi at pingdingshan university
 */

package com.pds.daoImpl;
import org.springframework.stereotype.Repository;

import com.pds.core.HibernateBaseDao;
import com.pds.dao.RulesDao;
import com.pds.model.Rules;


@Repository
public class RulesDaoImpl extends HibernateBaseDao<Rules, Integer> implements
	RulesDao {

}
