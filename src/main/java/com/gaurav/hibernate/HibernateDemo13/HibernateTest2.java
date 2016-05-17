
package com.gaurav.hibernate.HibernateDemo13;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
		
		UserDetails userDetails = null;
		Query query = session.createQuery("from UserDetails where id > :id and userName = :userName");
		int id = 5;
		String userName = "Gaurav 9";
		query.setInteger("id", id);
		query.setString("userName", userName);
		List<UserDetails> userList = (List<UserDetails>)query.list();
		System.out.println("Count is : "+userList.size());
		for(UserDetails detail : userList){
			System.out.println("Id : " + detail.getId() + ", User Name : " + detail.getUserName());
		}
		
		session.getTransaction().commit();
		session.close();
	}

}
