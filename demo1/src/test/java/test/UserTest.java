package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.frode.controller.bean.User;
import cn.frode.controller.mapper.UserMapper;
import cn.frode.controller.service.UserService;

public class UserTest {
	@Test
	public void adduser(){
		try {
			String resource = "mysql-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session =sqlSessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setUsername("admin");
			user.setPassword("123456");
			user.setPhone("13800138000");
			user.setEmail("admin@tedu.cn");
			user.setCreatedUser("admin");
			mapper.insertUser(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void adduser1(){
		try {
			String resource = "mysql-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session =sqlSessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.getCounALL();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testCount(){
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper us = 
				ac.getBean("userMapper",UserMapper.class);
		us.getCounALL();
		System.out.println("总计有："+us.getCounALL()+"行");
	}
	@Test
	public void testInsertUser(){
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um = ac.getBean("userMapper",UserMapper.class);
		User user = new User();
		
		user.setUsername("admin");
		user.setPassword("123456");
		user.setPhone("13800138000");
		user.setEmail("admin@tedu.cn");
		user.setCreatedUser("admin");
		um.insertUser(user);
	
	}
}
