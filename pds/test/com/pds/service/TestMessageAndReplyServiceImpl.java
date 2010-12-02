package com.pds.service;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pds.common.page.Paginable;
import com.pds.dao.AboutUsDao;
import com.pds.dao.DepartmentsDao;
import com.pds.model.AboutUs;
import com.pds.model.Departments;
import com.pds.model.Reply;

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration({"/applicationContext-hibernate.xml",
						"/applicationContext-beans.xml",
						"/applicationContext-dataSource.xml"}) //指定Spring的配置文件 /为classpath下
//@Transactional //对所有的测试方法都使用事务，并在测试完成后回滚事务
public class TestMessageAndReplyServiceImpl {
	@Resource
	private MessageService messageService;
	@Resource
	private ReplyService replyService;
	
	@Before //在每个测试用例方法之前都会执行
	public void init(){
	}
	
	@After //在每个测试用例执行完之后执行
	public void destory(){
	}
	
	@Test
	public void test(){
		Assert.assertNotNull(messageService);
		Assert.assertNotNull(replyService);
	}
}
