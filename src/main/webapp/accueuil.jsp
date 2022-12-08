

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceuil</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${requestScope.user == null}">
                <a href="login.jsp">Login</a>
            </c:when>
            <c:otherwise>
                ${user.firstName} ${user.lastName} <a href="Logout">Logout</a>
            </c:otherwise>
        </c:choose>
        <h1>accueil</h1>
        <c:forEach var="product" items="${listProducts}">
            <div>
                <span>${product.name}</span>
            </div>
        </c:forEach>
    </body>
</html>
