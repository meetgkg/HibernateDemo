package com.gaurav.hibernate.HibernateDemo14;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
		
		UserDetails details = new UserDetails();
		details.setId(5);
		details.setUserName("Gaurav 8");
		
		Example example = Example.create(details);
		
		Criteria criteria = session.createCriteria(UserDetails.class)
				.add(example);
		
		List<UserDetails> userList = (List<UserDetails>)criteria.list();
		printDetails2(userList);
		
		session.getTransaction().commit();
		session.close();
	}

	private static void printDetails2(List<UserDetails> userList2) {
		for(UserDetails detail : userList2){
			System.out.println(detail.toString());
		}
		
	}

}
