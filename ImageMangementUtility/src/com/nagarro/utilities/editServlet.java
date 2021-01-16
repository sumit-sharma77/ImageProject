package com.nagarro.utilities;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.dao.ImageDAO;

/**
 * Servlet implementation class editServlet
 */
@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String newName=request.getParameter("newImgName");
		if(newName=="") {
			response.sendRedirect("ImageUtility.jsp");
		}else {
			ImageDAO image = new ImageDAO();
			image.editName(Integer.parseInt(id),newName);
			response.sendRedirect("ImageUtility.jsp");
		}
	}

}
