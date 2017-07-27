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
<h2>Leave Requests</h2>
<table border="1px">
<tr>

<td>UserName</td>

<td>Leave Reason</td>
<td>Leave Date</td>
<td>Leave Days</td>

<td>Approve</td>
<td>Decline</td>

</tr>

<c:forEach items="${sessionScope.listofleave }" var="x">
<tr>

<td>${x.username}</td>
<%-- <td>${x.leavecount}</td> --%>
<td>${x.leavereason}</td>
<td>${x.date}</td>
<td>${x.leavedays}</td>

<td><a href="<%=request.getContextPath()%>/Manager_Servlet?data=approverequest&username=${x.username}&leaveid=${x.leaveid}&leavedays=${x.leavedays}"><input type="button" value="Approve"/></a></td>
<td><a href="<%=request.getContextPath()%>/Manager_Servlet?data=declinerequest&username=${x.username}"><input type="button" value="Decline"/></a></td>
</tr>
</c:forEach>

</table>
</div>
</center>
</body>
</html>