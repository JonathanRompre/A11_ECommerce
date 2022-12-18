<%-- 
    Document   : login
    Created on : Nov. 16, 2022, 2:12:01 p.m.
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
        <title><fmt:message key="login.title"/></title>
        <script src="scripts/script.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/banner.jsp"/>
        <div class="col-4 offset-4 border mt-5">
            <fieldset>
                <legend><fmt:message key="login.title"/></legend>
                <div id="message"></div>
                <div class="text-center">
                    <form name="loginForm">
                        <div class="m-1">
                            <input type="text" required name="email" placeholder="<fmt:message key="login.email"/>" class="w-50" /><br>
                            <div id="invalidEmail" style="display: none">
                                <span><fmt:message key="login.noAccount"/></span><br>
                            </div>
                        </div>
                        <div class="m-1">
                            <input type="password" name="password" placeholder="<fmt:message key="login.password"/>" class="w-50"/><br>
                            <div id="invalidPass" style="display: none">
                                <span><fmt:message key="login.invalidPassword"/></span><br>
                            </div>
                        </div>
                        <div class="mt-3">
                            <button type="button" value="login" class="btn btn-outline-secondary" onclick="authentifier()"><fmt:message key="login.btnLogin"/></button>
                        </div>
                    </form>
                </div>
            </fieldset>
            <a href="Register" class="btn btn-light m-1"><fmt:message key="login.register"/></a><br>
            <a href="Accueil" class="btn btn-light m-1"><fmt:message key="login.homePage"/></a>
            <a href="ViewAdminPage" class="float-right text-secondary text-decoration-none"><fmt:message key="login.admin"/></a>
        </div>
    </body>
    <jsp:include page="/WEB-INF/footer.jsp"/>
</html>
