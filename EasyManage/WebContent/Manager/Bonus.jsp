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
<h2>List of Employee under ME</h2>
<table border="1px">
<tr><td>First Name</td>
<td>Last Name</td><td>User Name</td>
<td>Position</td>
<td>Assign Bonus</td>
</tr>

<c:forEach items="${sessionScope.listemployeeunderme}" var="x">
<tr>
<td>${x.firstname }</td>
<td>${x.lastname }</td>
<td>${x.username }</td>
<td>${x.position}</td>
<td><a href="<%=request.getContextPath()%>/Manager_Servlet?data=addbonus&username=${x.username}">Assign Bonus</a></td>
</tr>
</c:forEach>
</table>
</div>
</center>
</body>
</html>