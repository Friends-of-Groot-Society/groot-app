<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Discount/Average Page</title>
</head>
<body>
 <h2>${discount}</h2>
<%
		int result = (Integer) request.getAttribute("result");
		out.println("Average of two numbers is :" + result);
	%>
<hr>
<a href="viewUserDetails.do">View</a>
<br />
<a href="/">HOME</a>
<br />



</body>
</html>
