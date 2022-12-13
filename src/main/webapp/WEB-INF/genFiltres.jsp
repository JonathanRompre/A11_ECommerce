<%-- 
    Document   : testGenFiltres
    Created on : Dec. 10, 2022, 5:01:24 p.m.
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div>
    <c:forEach var="categorie" items="${filterCategories}">
        <h6>${categorie.name}</h6>
        <c:forEach var="item" items="${categorie.items}">
            <div class="form-inline border rounded p-sm-2 my-2">
                <input type="button" class="w-100 btn btn-sm
                       <c:if test="${item.activeFilter == true}">
                           btn-secondary
                        </c:if>
                       <c:if test="${item.activeFilter == false}">
                           btn-outline-secondary
                        </c:if>
                       " value="${item.name}" onclick="filter('${item.url}')"/>
            </div>
        </c:forEach>
    </c:forEach>
</div>