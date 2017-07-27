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
<h2>This month details:</h2>
<br>
<br>
<table border="1px">
<tr><td>salary</td><td>Bonus</td><td>Paymonth</td></tr>

<c:forEach items="${sessionScope.pay}" var="x">
<tr><td>${x.salary}</td><td>${x.bonus}</td><td>${x.paymonth}</td></tr>
</c:forEach>
</table>
</center>
</body>
</html>