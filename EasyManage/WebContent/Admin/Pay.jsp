<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="../Payroll_Servlet?data=runpayroll" method="post">

Select Pay Month: 
	<select name="paymonth"><option selected="selected" > 01</option>
	<option> 02</option>
	<option> 03</option>
	<option> 04</option>
	<option> 05</option>
	<option> 06</option>
	<option> 07</option>
	<option> 08</option>
	<option> 09</option>
	<option> 10</option>
	<option> 11</option>
	<option> 12</option></select>
	<br>
	<br>
<input type="submit" value="Run Payroll">
</form>

</center>
</body>
</html>