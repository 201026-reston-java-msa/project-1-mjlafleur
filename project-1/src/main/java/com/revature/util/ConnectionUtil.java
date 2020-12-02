package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		
		//For compatibility with other technologies/frameworks will need to register our Driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url=
				"jdbc:postgresql://revdatabase.cwrli2cspmix.us-east-2.rds.amazonaws.com/banking";
		String username= "RevDataBase";
		String password= "evild0er";
		//Please, for the love of G-d DO NOT use this oh-so-crackable password on anything else.
		
		return DriverManager.getConnection(url, username, password);
	}
	
}
