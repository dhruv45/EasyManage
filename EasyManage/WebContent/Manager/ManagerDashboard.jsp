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
<p>hello<%
out.print(session.getAttribute("username"));
%></p>

<a href="<%=request.getContextPath()%>/Login_Servlet?data=logout"><input type="button" value="Logout"></a> 

<a href="<%=request.getContextPath()%>/Manager_Servlet?data=leavemanage&username=${a.username}">|Pending Request</a> 

<a href="<%=request.getContextPath()%>/Manager_Servlet?data=bonus&username=${a.username}">|Assign Bonus</a> 

<a href="<%=request.getContextPath()%>/Payroll_Servlet?data=checkpay&username=<% session.getAttribute("username"); %>"">|Check Pay</a>

<a href="MakeDirectory.jsp">|Make Directory</a>

<a href="<%=request.getContextPath()%>/Directory_Servlet?data=uploadfile&username=<% session.getAttribute("username"); %>"">|Upload File</a>
<br>
<br>
<br>
<a href="<%=request.getContextPath()%>/Uploadfile?data=public&username=<% session.getAttribute("username"); %>"">View Public Directories</a>

<a href="<%=request.getContextPath()%>/Uploadfile?data=private&username=<% session.getAttribute("username"); %>"">|View Private Directories</a>

<a href="<%=request.getContextPath()%>/Uploadfile?data=protectedc&username=<% session.getAttribute("username"); %>"">|View Protected Directories</a>

<a href="<%=request.getContextPath()%>/Uploadfile?data=default&username=<% session.getAttribute("username"); %>"">|View Default Directories</a>


</center>
</body>
</html>