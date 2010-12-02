package com.pds.service;

import java.util.Date;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pds.model.Message;

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
		//在reply端维护关系 下面只会保存message 不会保存reply  (message端级联保存失败)
//		Message message  = new Message();
//		message.setContent("message1");
//		
//		//message.getReplys().add(reply);
//		messageService.save(message);
		
		//下面这个如果messae存在的话 就保存reply
//		Reply reply = new Reply();
//		Message message = messageService.findById(2);
//		if(message!=null){
//			reply.setMessage(message);
//			replyService.save(reply);
//		}
		
		//message获得所有的reply成功
//		Message message  = messageService.findById(1);
//		List<Reply> list = message.getReplys();
//		for(Reply reply : list){
//			System.out.println(reply.getId());
//		}
		
		//级联删除成功（删除Mesaage时也删除reply）
//		Message message  = messageService.findById(1);
//		messageService.delete(message);
//		Assert.assertNotNull(replyService.findById(1));
		
		//Reply获得Message成功。
//		Reply reply = replyService.findById(2);
//		Assert.assertNotNull(reply.getMessage());
		
		//单独修改reply成功
//		Reply reply = replyService.findById(2);
//		reply.setContent("Hello world!");
//		replyService.update(reply);
		
		//单独修改message成功
//		Message message = messageService.findById(2);
//		message.setDate(new Date());
//		messageService.update(message);
	}
}
