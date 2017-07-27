<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Add Bonus</h2>
<c:forEach items="${sessionScope.listemployeeunderme }" var="a">

<form action="<%= request.getContextPath() %>/Manager_Servlet?data=bonusdone&username=${a.username}" method="post">
<input type="hidden" name="username" value="${x.username}">

<table border="1px">

	
	<tr><td>Username: </td><td><input type="text" disabled="disabled" name="username" value="${a.username }"/></td></tr>
	<tr><td>Firstname: </td><td><input type="text" disabled="disabled" value="${a.firstname }"/></td></tr>
	<tr><td>Lastname: </td><td><input type="text" disabled="disabled" value="${a.lastname }"/></td></tr>
	<tr><td>Divisionname: </td><td><input type="text" disabled="disabled"name="division" value="${a.divisionname }"/></td></tr>
	<tr><td>Positionname: </td><td><input type="text" disabled="disabled"name="position" value="${a.position}"></td></tr>
	<tr><td>AssignBonus:</td><td><input type="text" name="bonus" placeholder="enter just digits"></td></tr>
	<td><input type="submit" value="Assign Bonus" ></td>
</table>
</c:forEach>

</form>
</center>
</body>
</html>