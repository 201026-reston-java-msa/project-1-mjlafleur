package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
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
		
		ReimbursementStatus rs1 = new ReimbursementStatus();
		rs1.setStatusName("Approved");
		ses.save(rs1);
		ReimbursementStatus rs2= new ReimbursementStatus();
		rs2.setStatusName("Denied");
		ses.save(rs2);
		ReimbursementStatus rs3 = new ReimbursementStatus();
		rs3.setStatusName("Pending");
		ses.save(rs3);
		
		ReimbursementType rt1 = new ReimbursementType();
		rt1.setTypeName("LODGING");
		ses.save(rt1);
		ReimbursementType rt2 = new ReimbursementType();
		rt2.setTypeName("TRAVEL");
		ses.save(rt2);
		ReimbursementType rt3 = new ReimbursementType();
		rt3.setTypeName("FOOD");
		ses.save(rt3);
		ReimbursementType rt4 = new ReimbursementType();
		rt4.setTypeName("OTHER");
		ses.save(rt4);
		
		
		t.commit();
		System.out.println("Successfully Saved");
		closeSes();
	}
}
