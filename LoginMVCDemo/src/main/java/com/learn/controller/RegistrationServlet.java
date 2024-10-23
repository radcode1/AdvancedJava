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
 * Servlet implementation class RegistrationServlet
 */
@WebServlet(name = "register", urlPatterns = { "/register" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String error = UserUtil.validateRegistrationFields(request);
		HttpSession session = request.getSession();
		
		if (error == null) {
			
			UserService userService = new UserService();
			UserBean userBean = new UserBean();
			userBean.setFirstName(request.getParameter("firstname"));
			userBean.setLastName(request.getParameter("lastname"));
			userBean.setUsername(request.getParameter("username"));
			userBean.setPassword(request.getParameter("password"));
			
			error = userService.registerUser(userBean);
			
			if(error == null) {
				session.setAttribute("error", error);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else {
			session.setAttribute("error", error);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Register.jsp");
			requestDispatcher.forward(request, response);
		}
			
	}
		
}


