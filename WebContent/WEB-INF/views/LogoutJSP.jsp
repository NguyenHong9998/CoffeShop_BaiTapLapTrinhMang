<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%
    // reset session to null
	request.setAttribute("account", null);
	response.sendRedirect("index.jsp");
%>
<body>

</body>
</html>