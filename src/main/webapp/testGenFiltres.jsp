<%-- 
    Document   : testGenFiltres
    Created on : Dec. 10, 2022, 5:01:24 p.m.
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <c:forEach var="categorie" items="${filterCategories}">
                <h6>${categorie.name}</h6>
                <c:forEach var="item" items="${categorie.items}">
                    <div class="form-inline border rounded p-sm-2 my-2">
                        <input type="button" class="w-100" value="${item.name}" onclick="filter('${item.url}')"/>
                    </div>
                </c:forEach>
            </c:forEach>
        </div>
    </body>
</html>
