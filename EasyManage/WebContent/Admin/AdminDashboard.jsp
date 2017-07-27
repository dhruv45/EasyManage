<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<% if(session.getAttribute("username")==null)
{ 	
response.sendRedirect("../Login.jsp");
}
%> 

<%
String message=(String) request.getAttribute("msg");

if(message!=null){	
	
out.println("<p style= 'text-align:center; font-size:24px; color:red'><b> "+ message+ "</b></p>");
}
%>

</head>
<body>


<br>
<br>
<center>
<div>
<h2>List of Inactive Employee</h2>
<table border="1px">
<tr><td>First Name</td><td>Last Name</td><td>Email id</td><td>Phone No.</td><td>Address</td><td>User Name</td><td>Status</td><td>Change Employee Position</td></tr>

<c:forEach items="${sessionScope.list }" var="x">
<tr><td>${x.firstname }</td><td>${x.lastname }</td><td>${x.email }</td><td>${x.phonenumber }</td><td>${x.address}</td><td>${x.username }</td><td>${x.status }</td><td><a href="<%=request.getContextPath()%>/Registration_Servlet?data=changeManager&username=${x.username}"><input type="button" value="Change Position to Manager"/></a></td></tr>
</c:forEach>
</table>
</div>
</center>


<center>
<div>
<h2>List of Active Employee</h2>
<table border="1px">
<tr><td>First Name</td><td>Last Name</td><td>Email id</td><td>Phone No.</td><td>Address</td><td>User Name</td><td>Status</td><td>Position</td><td>Manage Profiles</td></tr>

<c:forEach items="${sessionScope.list1 }" var="a">
<tr><td>${a.firstname }</td><td>${a.lastname }</td><td>${a.email }</td><td>${a.phonenumber }</td><td>${a.address}</td><td>${a.username }</td><td>${a.status }</td><td>${a.position}</td><td><a href="<%=request.getContextPath()%>/ManageOrgProfile_Servlet?data=profile&username=${a.username}&firstname=${a.firstname }">|Update Org Profile</a></td></tr>
</c:forEach>
</table>
</div>
</center>



<center>
<br>
<a href="<%=request.getContextPath()%>/Login_Servlet?data=logout"><input type="button" value="Logout"></a> 

<a href="<%=request.getContextPath()%>/Login_Servlet?data=assign">|Assign Manager</a>

<a href="Pay.jsp">|Generate Pay</a>



</center>
</body>

</html>