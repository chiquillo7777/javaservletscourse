<%-- 
    Document   : users
    Created on : Feb 20, 2020, 11:29:49 AM
    Author     : carlos.chiquillo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items= "${users}" var="users">
            ${users.username}
        </c:forEach>
    </body>
</html>
