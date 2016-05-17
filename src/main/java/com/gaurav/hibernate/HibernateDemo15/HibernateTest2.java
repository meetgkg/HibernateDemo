package com.gaurav.hibernate.HibernateDemo15;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateTest2 {
	
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails userDetails1 = (UserDetails)session.get(UserDetails.class, 1);
		userDetails1.setUserName("Updated Name");
		UserDetails userDetails2 = (UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
	}

}
