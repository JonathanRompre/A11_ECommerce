<%-- 
    Document   : register
    Created on : Dec. 6, 2022, 9:22:22 a.m.
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <fmt:setLocale value="${not empty sessionScope.Locale ? sessionScope.Locale : pageContext.request.locale}"/>
    <fmt:setBundle basename="i18n.Messages"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <script src="scripts/register.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/banner.jsp"/>
        <input type="hidden" id="registrationSuccess" value="${registrationSuccess}"/>
        <c:if test="${requestScope.registrationSuccess == true}">
            <div class="text-center">
                <span class="fs-5 text-success mt-5"> <fmt:message key="register.registrationSuccess"/> </span>
            </div>
        </c:if>
        <div class="col-6 offset-3 border rounded rounded-2 mt-5">
            <div>
                <legend><fmt:message key="register.registration"/></legend>
                <form name="registrationForm" onsubmit="return register()" method="POST">
                    <div class="m-2">
                        <label for="firstName" class="col-3 offset-1"><fmt:message key="register.firstName"/>:</label>
                        <input type="text" class="col-5" required name="firstName" id="firstName" 
                               value="<c:if test="${firstName != null}">${firstName}</c:if>" 
                               placeholder="<fmt:message key="register.firstName"/>"/>
                    </div>

                    <div class="m-2">
                        <label for="lastName" class="col-3 offset-1"><fmt:message key="register.lastName"/>:</label>
                        <input type="text" class="col-5" required name="lastName" id="lastName" 
                               value="<c:if test="${lastName != null}">${lastName}</c:if>"
                               placeholder="<fmt:message key="register.lastName"/>"/>
                    </div>

                    <div class="m-2">
                        <label for="email" class="col-3 offset-1"><fmt:message key="register.email"/>:</label>
                        <input type="email" class="col-5" required name="email" id="email" 
                               value="<c:if test="${email != null}">${email}</c:if>" 
                               placeholder="<fmt:message key="register.email"/>"/>
                    </div>

                    <c:if test="${requestScope.emailExists == true}">
                        <div class="text-center">
                            <span class="text-decoration-underline text-danger m-3"><fmt:message key="register.emailExists"/></span>
                        </div>
                    </c:if>

                    <div class="m-2">
                        <label for="password" class="col-3 offset-1"><fmt:message key="register.password"/>:</label>
                        <input type="password" class="col-5" required name="password" id="password" value="" placeholder="<fmt:message key="register.password"/>"/>
                    </div>

                    <div class="m-2">
                        <label for="passwordConfirm" class="col-3 offset-1"><fmt:message key="register.confirm"/>:</label>
                        <input type="password" class="col-5" required name="passwordConfirm" id="passwordConfirm" value="" placeholder="<fmt:message key="register.confirmPassword"/>"/><br>
                    </div>
                    <c:if test="${requestScope.passwordsMatch == false}">
                        <div class="text-center">
                            <span class="text-decoration-underline text-danger m-3"><fmt:message key="register.passwordMismatch"/></span>
                        </div>
                    </c:if>

                    <button type="submit" class="btn btn-dark col-2 offset-1" ><fmt:message key="register.register"/></button>
                </form>
            </div>
            <a href="Accueil" class="btn btn-light m-2 border"> <fmt:message key="register.homePage" /></a>
        </div>
    </body>
    <jsp:include page="/WEB-INF/footer.jsp"/>
</html>
