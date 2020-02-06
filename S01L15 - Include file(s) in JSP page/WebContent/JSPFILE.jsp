<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP FILE</title>
</head>
<body>

<!-- For addind static content -->
	<%@ include file = "file1.txt" %>
	<br/>
	
	<!-- For adding dynamic content -->
	<jsp:include page ="file2.txt"></jsp:include>
</body>
</html>