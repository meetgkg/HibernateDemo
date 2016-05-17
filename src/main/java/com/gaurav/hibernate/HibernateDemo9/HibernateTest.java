package com.gaurav.hibernate.HibernateDemo9;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateTest {
	
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		
		//UserDetails userDetails = new UserDetails("Gaurav Gupta");
		
		Vehicle vehicle = new Vehicle("Vehicle");
		
		TwoWheeler TwoWheeler = new TwoWheeler("Yamaha", "Handle");
		
		FourWheeler fourWheeler = new FourWheeler("Infiniti", "Wheel");
		
		//userDetails.getVehicle().add(vehicle);
		
		Configuration configuration = new Configuration().configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		//session.persist(userDetails);
		session.save(vehicle);
		session.save(TwoWheeler);
		session.save(fourWheeler);
		session.getTransaction().commit();
		session.close();
	}

}
