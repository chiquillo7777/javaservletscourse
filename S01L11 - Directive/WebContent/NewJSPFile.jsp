<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%! public int a; %>
	
	<%
		a=5;
	
		for(int i=0; i<a; i++ ){
			out.print(a);
		}
	%>
</body>
</html>