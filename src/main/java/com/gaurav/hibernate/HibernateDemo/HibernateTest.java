package com.gaurav.hibernate.HibernateDemo;

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
		
		UserDetails userDetails = new UserDetails(1, "Gaurav Gupta", new Date(), "1025 Hancock St.", "This is description");
		
		//below is now deprecated
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Configuration configuration = new Configuration().configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		
		session.close();
		
		userDetails = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		userDetails = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("Details 22222 : \n"+userDetails.toString());
	}

}
