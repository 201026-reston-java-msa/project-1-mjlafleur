package com.revature.helper;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.controller.UserController;

public class ServletHelper {
	public static Logger log = Logger.getLogger(ServletHelper.class);
	
	
public static void postProcess(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		log.info("The URI is "+request.getRequestURI());
		switch(request.getRequestURI()) {
		case "/ERS-Project/login":
			UserController.login(request, response);
			break;
		case "ERS-Project/register":
			UserController.register(request, response);
			break;
		default:
			System.out.println("failure");
		}
	}


public static void getProcess(HttpServletRequest req, HttpServletResponse resp) {
	// TODO Auto-generated method stub
	
}

}
