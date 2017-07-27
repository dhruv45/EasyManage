<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
</head>
<body>
<center>

<%
out.print(session.getAttribute("username"));
%>
<a href="<%=request.getContextPath()%>/Login_Servlet?data=logout"><input type="button" value="Logout"></a> 

<a href="<%=request.getContextPath()%>/Employee_Servlet?data=fileupload">|File Upload</a>

<a href="<%=request.getContextPath()%>/Employee_Servlet?data=leaverequest&username=<% session.getAttribute("username"); %>">|Leave Request</a>

<a href="FileUploda.jsp">|File Upload</a>


<a href="<%=request.getContextPath()%>/Payroll_Servlet?data=checkpay&username=<% session.getAttribute("username"); %>"">|Check Pay</a>


</center>
</body>
</html>