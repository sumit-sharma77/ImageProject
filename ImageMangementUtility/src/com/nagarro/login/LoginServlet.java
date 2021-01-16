package com.nagarro.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("password"); 
		
		LoginValidation login = new LoginValidation();
		
		HttpSession session = request.getSession();
		
		if(login.validateLogin(uname, pass)) {
			
			
			session.setAttribute("username",uname);
			request.setAttribute("authorized", "true");
			
			response.sendRedirect("ImageUtility.jsp");
			
		}else
		{
			session.setAttribute("authorized", "false");
			request.getSession().setAttribute("error", "Invalid Username or Password !!!");
			
			response.sendRedirect("Login.jsp");
		}
	}

}
