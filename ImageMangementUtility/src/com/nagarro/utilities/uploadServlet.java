package com.nagarro.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.nagarro.dao.ImageDAO;
import com.nagarro.entities.Image;

/**
 * Servlet implementation class uploadServlet
 */
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 2097152)
public class uploadServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String user = (String) session.getAttribute("username");
		/*String hasValue = request.getParameter("img");
		PrintWriter out = response.getWriter();
		out.print(hasValue);*/
		InputStream inputStream = null;
		
	try {	Part filePart = request.getPart("img");
	

		if (filePart != null) {
			
			float size = filePart.getSize()/1024;
			String imgName = getSubmittedFileName(filePart);
			inputStream = filePart.getInputStream();
			
			byte[] data = new byte[inputStream.available()];
			inputStream.read(data);
			
			Image image = new Image(imgName, data, size, user);
			ImageDAO imgdao = new ImageDAO();
			imgdao.insertImage(image);
			session.setAttribute("errormsg", "");
			response.sendRedirect("ImageUtility.jsp");
		}}catch(Exception e) {
				session.setAttribute("errormsg", "Image Size is more than 2 MB");
				/*RequestDispatcher dis=request.getRequestDispatcher("ImageUtility.jsp");          
		         dis.include(request, response); */  
				response.sendRedirect("ImageUtility.jsp");
		}

	}
	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}

}
