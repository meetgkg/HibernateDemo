package com.gaurav.hibernate.HibernateDemo13;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateTest4 {
	
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		UserDetails userDetails = null;
		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "Gaurav 9");
		
		List<UserDetails> userList = (List<UserDetails>)query.list();
		
		for(UserDetails detail : userList){
			System.out.println("Id : " + detail.getId() + ", User Name : " + detail.getUserName());
		}
		
		session.getTransaction().commit();
		session.close();
	}

}
