package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.revature.model.User;

import static com.revature.util.HibernateUtil.getSession;
import static com.revature.util.HibernateUtil.closeSes;
public class Driver {

	public static void main(String[] args) {
		
		
		//StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		//Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		//SessionFactory sf = meta.getSessionFactoryBuilder().build();
		//Session session = sf.openSession();
		Session ses = getSession();
		Transaction t = ses.beginTransaction();
		
		User e1 = new User();
		e1.setFirstName("Alex");
		e1.setLastName("Seaholm");
		e1.setUsername("ASeaholm");
		e1.setPassword("password");
		e1.setEmail("ASeaholm@gmail.com");
		
		
		ses.save(e1);
		t.commit();
		System.out.println("Successfully Saved");
		closeSes();
	}
}
