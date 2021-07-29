package com.example.hibernatetutorial;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateTutorialApplication {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection successful!");
		} catch(Exception exc) {
			exc.printStackTrace();
		}
		
		SpringApplication.run(HibernateTutorialApplication.class, args);
	}

}
