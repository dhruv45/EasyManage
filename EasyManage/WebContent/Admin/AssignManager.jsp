<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% if(session.getAttribute("username")==null)
{
response.sendRedirect("../Login.jsp");
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="../AssignManager_Servlet" method="post">
<div>
<br>
<br>
<center>
<h2>Assign Inactive Employee under Manager</h2>

List of Manager and Active Employees
<select name="listofmanager">
<c:forEach items="${sessionScope.list1}" var="x">
<option value="${x.username} ">${x.firstname}</option>
</c:forEach>
</select>
<br>
<br>
<br>
List of Inactive Employee
<select name="inactiveemployee">
<c:forEach items="${sessionScope.list}" var="x">
<option value="${x.username} ">${x.firstname}</option>
</c:forEach>
</select>
<br>
<br>
<input type="submit" name="assign" value="assign">
</center>
</div>
</form>
</body>
</html>