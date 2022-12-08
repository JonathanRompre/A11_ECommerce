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
    </head>
    <body>
        <fieldset style="width:25%;">
            <legend>Login</legend>
            <form name="loginForm">
                <input type="text" required name="email" placeholder="email" /><br>
                <div id="invalidEmail" style="display: none">
                    <span>There is no account associated with this email.</span><br>
                </div>
                <input type="password" name="password" placeholder="password"/><br>
                <div id="invalidPass" style="display: none">
                    <span>Invalid password.</span><br>
                </div>
                <button type="button" value="login" onclick="authentifier()">login</button>
            </form>
        </fieldset>
        <a href="register.jsp">Register</a><br>
        <a href="Accueil">Retour à l'accueil</a>
    </body>
</html>
