<%@ page language="java" import="com.nagarro.dao.ImageDAO"
	import="java.util.*" import="com.nagarro.entities.Image"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Utility Page</title>
<script type="text/javascript">

</script>
<style>
table {
	background-color: lightblue;
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

.logout {
	
}
</style>
</head>
<body>
	<%
		if(session.getAttribute("username")==null )
		{
			response.sendRedirect("Login.jsp");
		}
		String errormsg=(String)session.getAttribute("errormsg");
		System.out.print("This is error"+errormsg);
		
	%>

	<% 
 /*  to get images of the login user */
   String username = (String)session.getAttribute("username");
	ImageDAO image = new ImageDAO();
	
	List<Image>imagesList = new LinkedList<Image>();
	
	imagesList= image.getImages(username);
	%>

	<table>
		<tr>
			<td>Welcome ${username}</td>
			<td style="text-align: right;"><a class="logout"
				href="Login.jsp">LogOut</a></td>

		</tr>
	</table>
	<table>
		<th><center>
				<h2>Image Management Utility</h2>

			</center></th>

	</table>
	<label for="imag" id="imgg">Please select an image file to
		upload(Max Size 2 MB)</label>
	<BR>
	<form action="uploadServlet" method="post"
		enctype="multipart/form-data">
		<input type="file" id="img" name="img" accept="image/*">
		<button>Submit</button>
		<button>Cancel</button>
		<label id="errormsg"></label>
		<script type="text/javascript">
		
			if ("<%=errormsg%>"!="") {
				document.getElementById("errormsg").innerHTML ="<%=errormsg%>"
			} else {
				document.getElementById("errormsg").innerHTML ="";
			}
		</script>
	</form>
	<BR>
	<BR>

	<label><B>Uploaded Image</B></label>
	<table id="table">
		<tr>
			<th>Img Id</th>
			<th>Name</th>
			<th>Size(KB)</th>
			<th>Preview</th>
			<th>Actions</th>
		</tr>
		<% 
				for (Image userImage : imagesList) { 
					byte[] dbimg = userImage.getImageData();
					String imgDataBase64=new String(Base64.getEncoder().encode(dbimg));
					

			%>
		<tr>
			<td><%=userImage.getImageId()%></td>
			<td><%=userImage.getImageName()%></td>
			<td><%=userImage.getImageSize()%></td>
			<td><img height=100px width=100px
				src="data:image/gif;base64,<%= imgDataBase64 %>"></td>
			<td>
				<form action="EditName.jsp?id=<%=userImage.getImageId()%>"
					method="post">
					<button>Edit</button>
				</form>
				<form action="DeleteServlet?id=<%=userImage.getImageId()%>"
					method="post">
					<button>Delete</button>
				</form>
			</td>

		</tr>
		<% 
				} 
			%>


	</table>


</body>
</html>