package com.gaurav.hibernate.HibernateDemo14;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
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
		
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userName", "Gaurav 6"))
					.add(Restrictions.ge("id", 5))
					.add(Restrictions.like("userName", "Gaurav%"))
					.add(Restrictions.or(Restrictions.le("id", 10), Restrictions.ge("id", 1)))
					.add(Restrictions.between("id", 0, 99));
		
		List<UserDetails> userList = (List<UserDetails>)criteria.list();
		
		for(UserDetails detail : userList){
			System.out.println("Id : " + detail.getId() + ", User Name : " + detail.getUserName());
		}
		
		session.getTransaction().commit();
		session.close();
	}

}
