package com.gaurav.hibernate.HibernateDemo4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateTest {
	
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		
		UserDetails userDetails = new UserDetails("Gaurav Gupta");
		
		Address address1 = new Address("1025 Hancock", "Quincy", "MA", "02169");
		Address address2 = new Address("1 Post Offc", "Boston", "MA", "02109");
		
		userDetails.getListOfAddresses().add(address1);
		userDetails.getListOfAddresses().add(address2);
		
		//below is now deprecated
		//SessionFactory sessionFactory2 = new Configuration().configure().buildSessionFactory();
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
		userDetails = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("***********************************************************************");
		session.close();
		System.out.println(userDetails.getListOfAddresses().size());
	}

}
