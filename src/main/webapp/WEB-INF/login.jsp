<%-- 
    Document   : login
    Created on : Nov. 16, 2022, 2:12:01 p.m.
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script src="scripts/script.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/banner.jsp"/>
        <div class="col-4 offset-4 border mt-5">
            <fieldset>
                <legend>Login</legend>
                <div class="text-center">
                    <form name="loginForm">
                        <div class="m-1">
                            <input type="text" required name="email" placeholder="email" class="w-50" /><br>
                            <div id="invalidEmail" style="display: none">
                                <span>There is no account associated with this email.</span><br>
                            </div>
                        </div>
                        <div class="m-1">
                            <input type="password" name="password" placeholder="password" class="w-50"/><br>
                            <div id="invalidPass" style="display: none">
                                <span>Invalid password.</span><br>
                            </div>
                        </div>
                        <div class="mt-3">
                            <button type="button" value="login" class="btn btn-outline-secondary" onclick="authentifier()">login</button>
                        </div>
                    </form>
                </div>
            </fieldset>
            <a href="Register" class="btn btn-light m-1">Register</a><br>
            <a href="Accueil" class="btn btn-light m-1">Retour à l'accueil</a>
        </div>
    </body>
    <jsp:include page="/WEB-INF/footer.jsp"/>
</html>
