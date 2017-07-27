<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String message=(String) request.getAttribute("message");

if(message!=null){ 
out.println("<p style= 'text-align:center; font-size:24px; color:red'><b> "+ message+"</b></p>");
}
%>
<form action="Registration_Servlet" method="post">
<input type="hidden" name="position" value="employee"/>
<input type="hidden" name="status" value="inactive"/>
<input type="hidden" name="managername" value="not assigned"/>


<center>
<table>
<h2>Welcome to Easy Manage</h2>
<tr>
	<td>Firstname:</td><td><input type="text" name="firstname"></td>
</tr>
<tr>
	<td>Lastname:</td><td><input type="text" name="lastname"></td>
</tr>
<tr>
	<td>Address:</td><td><input type="text" name="address"></td>
</tr>
<tr>
	<td>Phone Number:</td><td><input type="text" name="phonenumber"></td>
</tr>
<tr>
	<td>Email:</td><td><input type="text" name="email"></td>
</tr>
<tr>
	<td>Username:</td><td><input type="text" name="username"></td>
</tr>
<tr>
	<td>Password:</td><td><input type="password" name="password"></td>
</tr>
<tr>
<tr>
<td><br></td>
</tr>
<tr>
	<td colspan="6" align="center"><input type="submit" name="button" value="Register"></td>
</tr>
<tr>
<td><br></td>
</tr>
<tr>
	<td colspan="6" align="center">Already Registred?<a href="Login.jsp">Login Here</a></td>
</tr>

</table>
</center>
</form>
</body>
</html>