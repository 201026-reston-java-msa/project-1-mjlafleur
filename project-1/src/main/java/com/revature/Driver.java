package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.revature.model.Name;
import com.revature.model.User;

public class Driver {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		User e1 = new User();
		e1.setFirstName("Alex");
		e1.setLastName("Seaholm");
		e1.setUsername("ASeaholm");
		e1.setPassword("password");
		e1.setEmail("ASeaholm@gmail.com");
		
		
		session.save(e1);
		t.commit();
		System.out.println("Successfully Saved");
		sf.close();
		session.close();
	
	}
}
