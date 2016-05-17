package com.gaurav.hibernate.HibernateDemo8;

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
		Vehicle vehicle1 = new Vehicle("Audi");
		Vehicle vehicle2 = new Vehicle("Ferrari");
		userDetails.getVehicle().add(vehicle1);
		userDetails.getVehicle().add(vehicle2);
		
		vehicle1.getUserList().add(userDetails);
		vehicle2.getUserList().add(userDetails);
		
		Configuration configuration = new Configuration().configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(userDetails);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}

}
