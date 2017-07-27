<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% request.getParameter("username"); %>
<%
String message=(String) session.getAttribute("leavemsg");

if(message!=null){	
	
out.println("<p style= 'text-align:center; font-size:24px; color:red'><b> "+ message+ "</b></p>");
}
%>
<center>
<br><br>
<h2>Send a Leave Request</h2> <br><br>
</center>


<form action="<%= request.getContextPath() %>/Employee_Servlet" method="post">
<center>
<table>
<tr><td>Leave Date:</td><td><input type="date" name="date"> </td></tr>
<tr><td></td></tr>
<tr><td>Number of Days:</td><td><input type="text" name="leavedays" placeholder="max 4"> </td></tr>
<tr><td></td></tr>
<tr><td>Leave Reason:</td><td><textarea name="leavereason"></textarea> </td></tr>
<tr><td></td></tr>
</table>

<input type="submit" value="Request for leave" name="request"/>
</center>
</form>

</body>
</html>