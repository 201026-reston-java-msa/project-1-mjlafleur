package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.User;
import com.revature.service.UserService;

public class UserController {
	public static UserService userServ = new UserService();
	/////////////////////////////////// POST/////////////////////////

	public static void login(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		User employee = mapper.readValue(request.getInputStream(), User.class);// turns json to USER object

		String username = employee.getUsername();
		String password = employee.getPassword();

		User targetEmployee = userServ.login(username, password);
		// always responding from the controller
		if (targetEmployee.getUserId() > 0) {
			response.getWriter().write(new ObjectMapper().writeValueAsString(targetEmployee.getUsername()));
			HttpSession session = request.getSession();
			session.setAttribute("username", targetEmployee.getUsername());
			System.out.println(session.getAttribute("username"));
		} else {
			System.out.println("Error Message");
			response.sendError(400, "Invalid Credentials");
		}

	}

}
