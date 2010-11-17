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
import com.pds.model.AboutUs;

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration({"/applicationContext-hibernate.xml",
						"/applicationContext-beans.xml",
						"/applicationContext-dataSource.xml"}) //指定Spring的配置文件 /为classpath下
//@Transactional //对所有的测试方法都使用事务，并在测试完成后回滚事务
public class TestAboutUsServiceImpl {
//	@Autowired
//	private ApplicationContext appplicationContext; //自动注入applicationContext，这样就可以使用appli*.getBean("beanName")
	@Resource 		//会自动注入 default by type
	private AboutUsDao aboutUsDao;
	@Resource
	private AboutUsService aboutUsService;
	
	@Before //在每个测试用例方法之前都会执行
	public void init(){
	}
	
	@After //在每个测试用例执行完之后执行
	public void destory(){
	}
	
	@Test
//	@Transactional  //使用该注释会使用事务，而且在测试完成之后会回滚事务，也就是说在该方法中做出的一切操作都不会对数据库中的数据产生任何影响
//	@Rollback(false) //这里设置为false，就让事务不回滚
	public void testAdd(){
		Assert.assertNotNull(aboutUsDao);
		Assert.assertNotNull(aboutUsService);
		for(int i = 0; i<100; i++){
			AboutUs au = new AboutUs();
			au.setIntroduction("introduction"+i);
			au.setCompetency("Hello world"+i);
			au.setContact("联系方式"+i);
			au.setHistory("历史"+i);
//		aboutUsDao.save(au);
			aboutUsService.save(au);
			
		}
//		userDao.save(new User("userDao1","world!"));
//		userService.registerUser(new User("UserService1","world!"));
	}
	@Test
	public void testDelete(){
		AboutUs au = aboutUsService.deleteById(1);
		Assert.assertNotNull(au);
		System.out.println(au.getContact());
		
	}
	
	@Test
	public void testGetById(){
		AboutUs au = aboutUsService.findById(1);
		Assert.assertNotNull(au);
		System.out.println(au.getContact());
	}
	@Test
	public void testGetAll(){
		List<AboutUs> list = aboutUsService.findAll();
		System.out.println(list.size());
		
	}
	
	@Test
	public void insert10Records(){
		AboutUs au = null;
		for(int i = 0; i < 10; i++){
			au = new AboutUs();
			au.setHistory("history"+i);
			au.setCompetency("competency"+i);
			au.setContact("contact"+i);
			au.setIntroduction("introduction"+i);
			aboutUsService.save(au);
		}
	}
	
	@Test
	public void testGetPageByHql(){
		String hql = "from AboutUs where id > ? ";
		Paginable<AboutUs> page = aboutUsService.findPageByHql(hql, new Integer[]{10}, 1, 10);
		System.out.println(page);
		System.out.println("PageSize:"+page.getList().size());
		for(AboutUs au : page.getList()){
			System.out.println(au);
		}
	}
	@Test
	public void testGetPageByHql2(){
		String hql = "from AboutUs";
		Paginable<AboutUs> page = aboutUsService.findPageByHql(2);
		System.out.println(page);
		System.out.println("PageSize:"+page.getList().size());
		for(AboutUs au : page.getList()){
			System.out.println(au);
		}
	}
	@Test
	public void testGetPageByHql3(){
		String hql = "from AboutUs";
		Paginable<AboutUs> page = aboutUsService.findPageByHql(-12, 20);
		System.out.println(page);
		System.out.println("PageSize:"+page.getList().size());
		for(AboutUs au : page.getList()){
			System.out.println(au);
		}
	}
}
