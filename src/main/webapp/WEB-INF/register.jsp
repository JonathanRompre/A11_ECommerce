<%-- 
    Document   : register
    Created on : Dec. 6, 2022, 9:22:22 a.m.
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <fmt:setLocale value="${not empty sessionScope.Locale ? sessionScope.Locale : pageContext.request.locale}"/>
    <fmt:setBundle basename="i18n.Messages"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/banner.jsp"/>
        <div class="col-6 offset-3 border rounded rounded-2 mt-5">
            <div>
                <legend><fmt:message key="registration"/></legend>
                <form name="registrationForm" action="RegisterValidation" method="POST">
                    <div class="m-2">
                        <label for="firstName" class="col-3 offset-1"><fmt:message key="firstName"/>:</label>
                        <input type="text" class="col-5" required name="firstName" id="firstName" value="" placeholder="<fmt:message key="firstName"/>"/>
                    </div>
                    
                    <div class="m-2">
                        <label for="lastName" class="col-3 offset-1"><fmt:message key="lastName"/>:</label>
                        <input type="text" class="col-5" required name="lastName" id="lastName" value="" placeholder="<fmt:message key="lastName"/>"/>
                    </div>
                    
                    <div class="m-2">
                        <label for="email" class="col-3 offset-1"><fmt:message key="email"/>:</label>
                        <input type="text" class="col-5" required name="email" id="email" value="" placeholder="<fmt:message key="email"/>"/>
                    </div>
                    
                    <div class="m-2">
                        <label for="password" class="col-3 offset-1"><fmt:message key="password"/>:</label>
                        <input type="password" class="col-5" required name="password" id="password" value="" placeholder="<fmt:message key="password"/>"/>
                    </div>
                    
                    <div class="m-2">
                        <label for="passwordConfirm" class="col-3 offset-1"><fmt:message key="confirm"/>:</label>
                        <input type="password" class="col-5" required name="passwordConfirm" id="passwordConfirm" value="" placeholder="<fmt:message key="confirmPassword"/>"/><br>
                    </div>
                    
                    <button type="submit" class="btn btn-dark col-2 offset-1"><fmt:message key="register"/></button>
                </form>
            </div>
            <a href="Accueil" class="btn btn-light m-2 border"> <fmt:message key="homePage" /></a>
        </div>
    </body>
</html>
