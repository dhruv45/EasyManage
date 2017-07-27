<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<div>
<h2>Directories</h2>
<table border="1px">
<tr><td>Directory Name</td><td>File Name</td><td>Access</td></tr>

<c:forEach items="${sessionScope.publicfetch }" var="x">
<tr><td>${x.directoryname }</td><td><a href="display.jsp?viewid=${x.file_id}">${x.filename }</a></td><td>${x.access }</td></tr>
</c:forEach>
</table>
</div>
</center>
</body>
</html>