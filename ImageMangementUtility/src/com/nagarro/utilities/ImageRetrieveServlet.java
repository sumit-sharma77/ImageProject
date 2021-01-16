package com.nagarro.utilities;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageRetrieveServlet
 */
@WebServlet("/ImageRetrieveServlet")
public class ImageRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 byte[] image  = request.getParameter("img").getBytes();
		 
		/* response.setContentType("image/*");
		 OutputStream out = response.getOutputStream();
		 out.write(image); // image is of byte[] type.
*/		
	}

}
