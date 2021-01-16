<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
	.loginContainer{
		width: 40%;
		border:1px solid black;
		margin: auto;
		padding: 20px;	
		background-color: lightBlue;	
	} 
</style>
</head>
<body>
	<div class="loginContainer">
		

		<form action="LoginServlet" method="post">
			<table align="center" >
				<tr>
					<td></td>
					<td><h1>Login Page</h1></td>
				</tr>
				<tr>
					<td align="left">UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td align="left">Password</td>
					<td align="right"><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>
						<%
							if (session.getAttribute("authorized") != null && session.getAttribute("authorized").equals("false")) {
								out.print(request.getSession().getAttribute("error"));
								session.setAttribute("authorized", null);
							}
						session.setAttribute("errormsg", "");
						%>
					</td>
				</tr>
				<tr>
					<td> </td>
					<td> </td>
					<td><input type="submit" value="Login>>" /></td>
				</tr>	
			</table>
			
		</form>

	</div>
</body>
</html>