package com.revature.service;

import com.revature.dao.EmployeeDao;
import com.revature.daoimple.EmployeeDaoImpl;
import com.revature.model.Employee;

public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	public Employee login(String username, String password) {
		System.out.println("Service");
		return employeeDao.login(username, password);
	}
	
}
