package com.gaurav.hibernate.HibernateDemo11;

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
		
		Configuration configuration = new Configuration().configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		UserDetails userDetails = null;
		/*for (int i = 0; i < 10 ; i++ ){
			userDetails = new UserDetails("Gaurav Gupta " + i);
			session.save(userDetails);
		}*/
		userDetails = (UserDetails)session.get(UserDetails.class, 6);
		if (userDetails != null)
			session.delete(userDetails);
		
		userDetails = (UserDetails)session.get(UserDetails.class, 7);
		userDetails.setUserName("Updated Gaurav Gupta");
		session.update(userDetails);
		
		session.getTransaction().commit();
		session.close();
		//System.out.println(userDetails.toString());
	}

}
