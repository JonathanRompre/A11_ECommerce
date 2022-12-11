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
        <div class="col-3">
            <input type="button" class="quickview btn btn-info col-12 mt-2" value="Clear" id="btnClear" onclick="window.location="CreateFilterSidebar?filter1n=Companion&filter1v=Cat""/>
            <div>
                <c:forEach var="categorie" items="${filterCategories}">
                    <h6>${categorie.name}</h6>
                    <form class="ml-md-2">
                        <c:forEach var="item" items="${categorie.items}">
                            <div class="form-inline border rounded p-sm-2 my-2">
                                <label onclick="filter(${item.url})">${item.name}</label>
                            </div>
                        </c:forEach>
                    </form>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
