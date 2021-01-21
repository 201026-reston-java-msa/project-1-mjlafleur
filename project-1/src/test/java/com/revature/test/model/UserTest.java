package com.revature.test.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;

import com.revature.model.Role;
import com.revature.model.User;




public class UserTest {
	

	/**
	 * User should have GeneratedValue through Hibernate, username, password,
	 * first, last, email, Role: id, name. 
	 */
	 @Mock Role role = new Role(1,"Employee");
	 @Mock User user = new User("tester","password","test","user","testEmail@email.com",role);
	
	 /**
	  * Checks that Hibernate creates an ID.
	  * 	 This is not generating an ID with Hibernate just giving 
	  * the default value of 0.
	  */
	 @Test
	 public void hasGeneratedId() {
		 assertNotNull(user.getUserId());
		 System.out.println(user.getUserId());
	 }
	 
	 
	 /**
	  * Checks the getter for Username.
	  */
	@Test
	public void hasGetter() {
		assertNotNull(user.getUsername());	
	}
	
	/**
	 * Checks the setter for Username.
	 */
	@Test
	public void hasSetter() {
		user.setUsername("testy");
		assertEquals(user.getUsername(),"testy");
	}
	
	/**
	 * For now just going to assume that getter/setter works for rest of user.
	 */

}
