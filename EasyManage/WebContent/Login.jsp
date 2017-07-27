<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 
<%
String message=(String) request.getAttribute("error");

if(message!=null){	
	
out.println("<p style= 'text-align:center; font-size:24px; color:red'><b> "+ message+ "</b></p>");
}
%>
<body>

<form action="Login_Servlet" method="post"> 
<center>
<h2>Login to Easy Manage</h2>
<table>
<tr>
<td></td>
</tr>
<tr>

	<td>Username:</td><td><input type="text" name="username"></td>
</tr>
<tr>
	<td>Password:</td><td><input type="password" name="password"></td>
</tr>
<tr>
<td><br></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" name="button" value="Login"></td>
</tr>
<tr>
<td><br></td>
</tr>
<tr>
	<td colspan="3" align="center"> Not Registered ? <a href="Registration.jsp">Register Here</a> 
</tr>
</table>
</center>
</form>
</body>
</html>