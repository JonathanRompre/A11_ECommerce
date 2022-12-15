<%-- 
    Document   : profile
    Created on : Nov. 16, 2022, 2:12:29 p.m.
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Profil</title>
    </head>
    <body>
        <div id="banner">
            <jsp:include page="/WEB-INF/banner.jsp"/>
        </div>
        <fieldset class="form-group border border-dark rounded p-3 w-50 col-8 offset-1 mt-5">
            <legend class="w-auto px-2">Profile</legend>
            <div class="form-group mx-3">
                <label for="firstName">First name:</label>
                <input type="text" class="form-control" id="firstName" placeholder="First name" name="firstName">
            </div>
            <div class="form-group mx-3">
                <label for="lastName">First name:</label>
                <input type="text" class="form-control" id="lastName" placeholder="Last name" name="lastName">
            </div>
            <div class="form-group mx-3">
                <label for="email">Email:</label>
                <input type="email" class="form-control email" id="email" placeholder="Email..." name="email">
            </div>
            <fieldset class="form-group border border-secondary p-3 rounded w-75">
                <legend class="w-auto px-2">Change password</legend>
                <div class="form-group mx-3">
                    <label for="currentPassword">Current password:</label>
                    <input type="password" class="form-control" id="currentPassword" placeholder="Current password" name="currentPassword">
                </div>
                <div class="form-group mx-3">
                    <label for="newPassword">New password:</label>
                    <input type="password" class="form-control" id="newPassword" placeholder="Current password" name="newPassword">
                </div>
            </fieldset>
        </fieldset>
    </body>
</html>
