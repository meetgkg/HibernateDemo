package com.gaurav.hibernate.HibernateDemo13;

import java.util.List;

import org.hibernate.Query;
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
		
		//Just for populate
		/*for(int i = 1; i < 11; i ++){
			session.save(new UserDetails("Gaurav "+ i));
		}*/
		//Query query = session.createQuery("from UserDetails where id > 5 ");
		//Query query = session.createQuery("from UserDetails");
		Query query = session.createQuery("select userName from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(4);
		//List<UserDetails> userList = (List<UserDetails>)query.list();
		List<String> userList = (List<String>)query.list();
		System.out.println("Count is : "+userList.size());
		for(String detail : userList){
			//System.out.println("Id : " + detail.getId() + ", User Name : " + detail.getUserName());
			System.out.println("User Name : " + detail);
		}
		
		session.getTransaction().commit();
		session.close();
	}

}
