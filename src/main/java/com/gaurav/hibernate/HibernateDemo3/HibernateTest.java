package com.gaurav.hibernate.HibernateDemo3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateTest {
	
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		
		Address homeAddress = new Address("1025 Hancock", "Quincy", "MA", "02169");
		Address officeAddress = new Address("1 Post Offc", "Boston", "MA", "02109");
		
		UserDetails userDetails1 = new UserDetails("Gaurav Gupta", homeAddress, officeAddress);
		
		
		//below is now deprecated
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Configuration configuration = new Configuration().configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(userDetails1);
		session.getTransaction().commit();
		session.close();
	}

}
