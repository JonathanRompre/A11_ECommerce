<%-- 
    Document   : init
    Created on : Dec. 6, 2022, 10:19:20 a.m.
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../ConfigDatabase"/>
        <jsp:include page="../InitLocale"/>
        <jsp:forward page="../acceuil.jsp"/>
    </body>
</html>
