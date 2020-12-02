package com.revature.helper;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.controller.EmployeeController;

public class Helper {
	public static Logger log = Logger.getLogger(Helper.class);
	
	
public static void postProcess(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		case "/project-1/login":
			System.out.println("Got the URI");
			EmployeeController.login(request, response);
			break;
		default:
			System.out.println("failure");
		}
	}


public static void getProcess(HttpServletRequest req, HttpServletResponse resp) {
	// TODO Auto-generated method stub
	
}

}
