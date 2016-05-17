package com.gaurav.hibernate.HibernateDemo2;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateTest {
	
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		
		UserDetails userDetails1 = new UserDetails("Gaurav Gupta");
		UserDetails userDetails2 = new UserDetails("Anamika Gupta");
		
		//below is now deprecated
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Configuration configuration = new Configuration().configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(userDetails1);
		session.save(userDetails2);
		session.getTransaction().commit();
		session.close();
	}

}
