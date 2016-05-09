package com.musiclivemap.cfg;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.musiclivemap.service.User;

public class ServiceBuilder {
	public static void main(String[] args) {

		// creating configuration object
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");// populates the data of the
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sesionFactory = configuration.buildSessionFactory(serviceRegistry);

		// creating session object
		Session session = sesionFactory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();

		User e1 = new User();
		e1.setNombre("Pablo");
		e1.setApellido1("Robledo");
		e1.setApellido2("Montano");

		session.persist(e1);// persisting the object

		t.commit();// transaction is committed
		session.close();

		System.out.println("successfully saved");

	}
}
