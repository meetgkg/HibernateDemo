package com.gaurav.hibernate.HibernateDemo15;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateTest3 {
	
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from UserDetails where id = 1");
		query.setCacheable(true);
		List<UserDetails> list = query.list();
		
		session.getTransaction().commit();
		session.close();
				
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Query query2 = session2.createQuery("from UserDetails where id = 1");
		query.setCacheable(true);
		list = query2.list();
		
		session2.getTransaction().commit();
		session2.close();
	}

}
