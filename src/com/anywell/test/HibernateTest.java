package com.anywell.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anywell.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Resource(name = "sessionFactory")
	private SessionFactory sf;

	@Test
	public void saveTest() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session sessio = sessionFactory.openSession();
		Transaction tx = sessio.beginTransaction();
		User user = new User();
		user.setUser_code("kate");
		user.setUser_name("凯特");
		user.setUser_password("1234");
		sessio.save(user);

		tx.commit();
		sessio.close();
	}
	@Test
	public void fun2(){
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		User u = new User();
		
		u.setUser_code("jerry");
		u.setUser_name("杰瑞");
		u.setUser_password("1234");
		
		session.save(u);
		
		//-------------------------------------------------
		tx.commit();
		
		session.close();
		
	}
	

}
