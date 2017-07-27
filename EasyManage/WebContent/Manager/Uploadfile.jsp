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
<h2>Upload File Under Directory</h2>
<form action="<%=request.getContextPath()%>/Uploadfile" method="post" enctype="multipart/form-data">
<table>

<tr><td>Upload File: </td><td><input type="file" name="file"></td></tr><tr><td><br></td></tr>
<tr><td>File Name:</td><td><input type="text" name="filename"></td></tr><tr><td><br></td></tr>
<tr><td>Directory Name:</td><td><select name="directorylist">
<c:forEach items="${sessionScope.directorylist}" var="x">
<option value="${x.directoryname} ">${x.directoryname}</option>
</c:forEach></select>
</td></tr><tr><td><br></td></tr>
<tr><td><input type="submit" value="Upload File"></td></tr>
</table>

</form>
</center>
</body>
</html>