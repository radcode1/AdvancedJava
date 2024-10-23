package com.learn.service;

import com.learn.bean.UserBean;
import com.learn.dao.UserDAO;

public class UserService {
	
	UserDAO userDAO = new UserDAO();

	public  String authenticateAndPopulateUser(UserBean userBean) {
		String error = null;
		
		userBean = userDAO.getUserBean(userBean);
		
		if(userBean.getFirstName() == null) {
			error = "Invalid User Credentials";
		}
		
		return error;
	}
	
	public String registerUser(UserBean userBean) {
		
		String error = null;
		
		boolean userAlreadyExists = userDAO.userAlreadyExists(userBean.getUsername());
		
		if(userAlreadyExists)
			error = "Username already exists";
		
		else {
			error = userDAO.insertUser(userBean);
			
		}
		
		return error;
		
		
	}

}
