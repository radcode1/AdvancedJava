package com.learn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.learn.bean.UserBean;

public class UserDAO {
	
	Connection connection;
	
	

	public UserBean getUserBean(UserBean userBean) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sep2024","root","StoreData");
			
			PreparedStatement preparedStatement = connection.prepareStatement(" select * from user where username = ? and password = ?");
			
			preparedStatement.setString(1, userBean.getUsername());
			preparedStatement.setString(2, userBean.getPassword());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				userBean.setFirstName(resultSet.getString(1));
				userBean.setLastName(resultSet.getString(2));
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userBean;
	}
	
	public boolean userAlreadyExists(String userName) {
		
		boolean userExists = false;
		if(userName != null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sep2024","root","StoreData");
				
				PreparedStatement st = connection.prepareStatement("select * from user where username = ?");
				st.setString(1, userName);
				ResultSet rs = st.executeQuery();
				
				if(rs.next())
					userExists = true;
				
				connection.close();
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
		}
		
		return userExists;
	}
	
	public String insertUser(UserBean userBean) {
		
		String error = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sep2024","root","StoreData");
			
			PreparedStatement st = connection.prepareStatement("insert into user values (?,?,?,?)");
			st.setString(1, userBean.getFirstName());
			st.setString(2, userBean.getLastName());
			st.setString(3, userBean.getUsername());
			st.setString(4, userBean.getPassword());
			
			int i = st.executeUpdate();
			connection.close();
			
			if (i == 1)
				error = null;
			else
				error = "Unable to register User";
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return error;
	}

}
