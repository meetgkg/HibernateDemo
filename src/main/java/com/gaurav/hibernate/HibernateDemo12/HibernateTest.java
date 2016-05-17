package com.gaurav.hibernate.HibernateDemo12;

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
		
		//UserDetails userDetails = new UserDetails("Gaurav Gupta");
		//session.save(userDetails);
		
		//userDetails.setUserName("Amit Gupta");
		
		/*PersistentSaveTest test = new PersistentSaveTest();
		userDetails = test.checkUpdate(userDetails);*/
		
		UserDetails userDetails = (UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		//userDetails.setUserName("Updated User Name after Session.close");
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(userDetails);
		userDetails.setUserName("Updateddd");
		session.getTransaction().commit();
		session.close();
	}

}
