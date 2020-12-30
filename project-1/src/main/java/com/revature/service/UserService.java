package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.daoimple.UserDaoImpl;
import com.revature.model.User;

public class UserService {
	UserDao employeeDao = new UserDaoImpl();
	
	public User login(String username, String password) {
		System.out.println("Service");
		return employeeDao.login(username, password);
	}
	
}
