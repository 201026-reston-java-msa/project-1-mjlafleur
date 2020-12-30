package com.revature.dao;

import com.revature.model.User;

public interface UserDao {

	public User login(String username, String password);
	

}
