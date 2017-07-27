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
<div>
<h2>Update Organizational Profile</h2>

<c:forEach items="${sessionScope.list4 }" var="a">
<form action="<%= request.getContextPath() %>/ManageOrgProfile_Servlet?data=updateprofile&username=${a.username}" method="post">
<input type="hidden" name="firstname" value="${x.firstname}">
<table border="1px">

	
	<tr><td>Username: </td><td><input type="text" disabled="disabled" name="username" value="${a.username }"/></td></tr>
	<tr><td>Firstname: </td><td><input type="text" disabled="disabled" value="${a.firstname }"/></td></tr>
	<tr><td>Lastname: </td><td><input type="text" disabled="disabled" value="${a.lastname }"/></td></tr>
	<tr><td>Divisionname: </td><td><input type="text" name="division" value="${a.divisionname }"/></td></tr>
	<tr><td>Positionname: </td><td><input type="text" name="position" value="${a.position}"></td></tr>
	<tr><td>Salary: </td><td><input type="text" name="salary" value="${a.salary}"></td></tr>
	<tr><td>Managername: </td><td>
	<option selected="selected" disabled="disabled"> disabled </option>
	<%-- <select name="listofmanager"  disabled="disabled" ></select>
<c:forEach items="${sessionScope.list2}" var="x">
<option value="${x.username} ">${x.firstname}</option>
</c:forEach>
</select></td></tr> --%>
	 
	<tr><td>Status: </td><td><input type="text" disabled="disabled" value="${a.status }"></td></tr>
	<tr>
	<td>
		<input type="submit" value="updateprofile"/>
	</td>
	</tr>

</table>

</form>
</c:forEach>

</div>

</center>

</body>
</html>