<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<%
String message=(String) request.getAttribute("message");

if(message!=null){ 
out.println("<p style= 'text-align:center; font-size:24px; color:red'><b> "+ message+"</b></p>");
}
%>
<h2>Make Directory</h2>
<form action="../Directory_Servlet" method="post">
Directory Name:<input type="text" name="Directoryname">

Access Rights:<select name="access">
<option>Public</option>
<option>Private</option>
<option>Protected</option>
<option>Default</option>
</select>

<input type="submit" value="Make One" >
</form>
</center>
</body>
</html>