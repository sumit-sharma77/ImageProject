<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Name</title>
<style type="text/css">
	.container{
		width: 40%;
		 border:1px solid black;
		margin: auto;
		padding: 20px;	
		background-color: lightBlue; 
	}
	.buttons{
		margin-top: 20px;
		margin-left: 170px;
	}
	
</style>
</head>
<body>
<div class="container">
<form action="editServlet?id=<%=request.getParameter("id")%>" method="post">
<div class = "NewName">
	Enter New Image Name: <input type="text" name="newImgName" />
</div>
<div class="buttons">
	<button>Submit</button> <button> GoBack</button>
</div>
</form>
</div>
</body>
</html>