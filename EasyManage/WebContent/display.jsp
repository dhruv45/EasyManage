<%@page import="DAO.FetchDirectoryDAO"%>
<%@page import="Servlet.Uploadfile"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.*"%>
   <%@page import="VO.*" %>

<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Media</title>
</head>

<body>

<% Blob image = null;
byte[ ] imgData = null ;
try {
FileuploadVO fvo = FetchDirectoryDAO.Media(Integer.parseInt(request.getParameter("viewid")));	
image = fvo.getGetfile();
imgData = image.getBytes(1,(int)image.length());
response.setContentType(fvo.getFiletype());
OutputStream o = response.getOutputStream();
o.write(imgData);
o.flush();
o.close();
} catch (Exception e) {
out.println(e.getMessage());
return;

} 



%>
</body>
</html>