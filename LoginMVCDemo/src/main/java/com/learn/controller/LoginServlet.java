package com.learn.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.learn.bean.UserBean;
import com.learn.service.UserService;
import com.learn.util.UserUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "loginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	UserService userService = new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String error;
			HttpSession session;
			
			error = UserUtil.validateRequest(request);
			session = request.getSession();
			
			if (error == null) {
				
				String userName = request.getParameter("username");
				String password = request.getParameter("password");
				UserBean userBean = new UserBean();
				userBean.setUsername(userName);
				userBean.setPassword(password);
				error = userService.authenticateAndPopulateUser(userBean);
				if (error == null) {

					session.setAttribute("firstName", userBean.getFirstName());
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Success.jsp");
					requestDispatcher.forward(request, response);
				} 
			}
		if(error != null) {
			session.setAttribute("error", error);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
	}

}
