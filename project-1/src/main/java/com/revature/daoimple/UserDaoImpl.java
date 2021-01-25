package com.revature.daoimple;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.dao.UserDao;

import com.revature.model.User;
import static com.revature.util.HibernateUtil.getSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
	public static Logger log = Logger.getLogger(UserDaoImpl.class);

	@Override
	public User login(String username, String password) {
		//StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		//SessionFactory sf = meta.getSessionFactoryBuilder().build();
		
		Session session = getSession();
		log.info("Session was created successfully");
		
		List<User> targetUser = session.createQuery("from User where ers_username='"+username+"' and ers_password='"+password+"'",User.class).list();
		User currentUser = targetUser.get(0);
		
		return currentUser;
	}

}
