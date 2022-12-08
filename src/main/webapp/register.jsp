<%-- 
    Document   : register
    Created on : Dec. 6, 2022, 9:22:22 a.m.
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <fieldset style="width: 25%">
            <legend>Registration</legend>
            <form name="registrationForm" action="RegisterValidation" method="POST">
                Prénom:<input type="text" required name="firstName" value="" placeholder="Prénom"/><br>
                Nom:<input type="text" required name="lastName" value="" placeholder="Nom"/><br>
                Courriel:<input type="text" required name="email" value="" placeholder="Courriel"/><br>
                MDP:<input type="password" required name="password" value="" placeholder="Mot de passe"/><br>
                Confirmer:<input type="password" required name="passwordConfirm" value="" placeholder="Confirmer le mot de passe"/><br>
                <button type="submit">Register</button>
            </form>
        </fieldset>
        <a href="Accueil">Retour à l'accueil</a>
    </body>
</html>
