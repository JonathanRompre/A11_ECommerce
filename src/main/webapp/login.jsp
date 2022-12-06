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
    </head>
    <body>
        <fieldset style="width:25%;">
            <legend>Login</legend>
            <form name="loginForm" action="LoginValidation" method="POST">
                <input type="text" name="email" placeholder="email" /><br>
                <input type="password" name="password" placeholder="password"/><br>
                <button type="submit" value="login">login</button>
            </form>
        </fieldset>
        <a href="register.jsp">Register</a>
    </body>
</html>
