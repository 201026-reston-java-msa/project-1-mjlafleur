package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.User;
import com.revature.service.UserService;

//The Controller is turning the request into the response. 
public class UserController {
	public static UserService userServ = new UserService();
	/////////////////////////////////// POST/////////////////////////

	public static void login(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(request.getInputStream(), User.class);// turns json to USER object

		//setting username and password for the login attempt
		String username = user.getUsername();
		String password = user.getPassword();

		//calls login for the userService.
		User targetUser = userServ.login(username, password);
		// always responding from the controller
		
		//checks the user_role id
		if (targetUser.getRole().getRoleId() > 0) {
			response.getWriter().write(new ObjectMapper().writeValueAsString(targetUser.getUsername()));
			HttpSession session = request.getSession();
			session.setAttribute("username", targetUser.getUsername());
			
		} else {
			System.out.println("Error Message");
			response.sendError(400, "Invalid Credentials");
		}

	}

	public static void register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
