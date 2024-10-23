package com.learn.util;

import jakarta.servlet.http.HttpServletRequest;

public class UserUtil {

	public static String validateRequest(HttpServletRequest request) {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String error = null;
		
		if(userName.isEmpty() || password.isEmpty())
			error = "UserName or Password is empty";
		
		return error;
	}
	
	public static String validateRegistrationFields(HttpServletRequest request) {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String error = null;
		
		
		if(userName.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty())
			error = "The fields cannot be blank";
		
		return error;
	}


}
