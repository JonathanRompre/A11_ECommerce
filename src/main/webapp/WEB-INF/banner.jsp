<%-- 
    Document   : banner
    Created on : Dec. 12, 2022, 9:11:19 p.m.
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="d-flex flex-column ">
    <div>
        <nav class="navbar navbar-dark  " style="float: right">
            <c:choose>
                <c:when test="${sessionScope.Locale == 'en_CA' || sessionScope.Locale == 'en_US' }">
                    <a class="text-dark">EN</a>&nbsp;&nbsp;            
                </c:when>
                <c:otherwise>
                    <a href="SetLocale?langue=en_CA">EN</a>&nbsp;&nbsp;            
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${sessionScope.Locale == 'fr_CA'}">
                    <a class="text-dark">FR</a>&nbsp;&nbsp;            
                </c:when>
                <c:otherwise>
                    <a href="SetLocale?langue=fr_CA">FR</a>&nbsp;&nbsp;            
                </c:otherwise>
            </c:choose>
            <c:if test="${requestScope.authenticating == null || requestScope.authenticating == false}">
                <c:choose>
                    <c:when test="${sessionScope.uid == null}">
                        <a class="btn btn-light " role="button" href="Login">Log in</a>
                        <a class="btn btn-light " role="button" href="Register">Signup</a>
                    </c:when>
                    <c:otherwise>
                        <a class="btn btn-light " role="button" href="Logout">Log out</a>
                        <c:if test="${not pageContext.request.requestURI.endsWith('/profile.jsp')}">
                            <img src="<c:url value="/images/profileIcon.png"/>" class="rounded-circle linkImage mx-1" width="35" onclick="window.location='ViewProfile'"/>
                        </c:if>
                        <a class="btn btn-light" href="Checkout">Cart 
                            <span id="cartSize" class="badge badge-danger">${sessionScope.cartList}</span>
                        </a>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </nav>
    </div>
    <div class="bg-dark text-white m-2 p-1 d-flex flex-row bannerImage">
        <img src="<c:url value="/images/headerDog.jpg"/>" class="rounded-circle image" width="100" onclick="window.location='Accueil'"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <h1 class="align-self-center">Jo & Sam Petstore</h1> 
    </div>
</div>