package com.gaurav.hibernate.HibernateDemo14;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
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
		
		Criteria criteria = session.createCriteria(UserDetails.class)
				.setProjection(Projections.max("id"));
		List<Integer> userList = (List<Integer>)criteria.list();
		printDetails(userList);
		
		Criteria criteria2 = session.createCriteria(UserDetails.class)
				.addOrder(Order.desc("id"));
		List<UserDetails> userList2 = (List<UserDetails>)criteria2.list();
		printDetails2(userList2);
		
		session.getTransaction().commit();
		session.close();
	}

	private static void printDetails2(List<UserDetails> userList2) {
		for(UserDetails detail : userList2){
			System.out.println(detail.toString());
		}
		
	}

	private static void printDetails(List<Integer> userList) {
		for(Integer i : userList){
			System.out.println("Max Id : " + i);
		}
	}

}
