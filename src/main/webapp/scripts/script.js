/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
var response;
function authentifier() {
    requete = new XMLHttpRequest();

    url = "LoginValidation";

    requete.onreadystatechange = traiterValidation;

    requete.open("POST", url, true);
    requete.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    requete.send("email=" + document.loginForm.email.value + "&password=" + document.loginForm.password.value);
}

function traiterValidation() {
    if ((requete.readyState === 4) && (requete.status === 200)) {
        response = JSON.parse(requete.responseText);
        if (response.isSuspended == true) {
            $('#message').html("<span class='text-danger fs-3'>This account is suspended.</span>")
        } else {
            $('#message').html("")
            if (response.loginSuccess == true) {
                window.location.href = "Accueil";
            } else if (response.emailExists == true) {
                document.getElementById("invalidPass").style = "display: block";
                document.getElementById("invalidEmail").style = "display: none";
            } else {
                document.getElementById("invalidPass").style = "display: none";
                document.getElementById("invalidEmail").style = "display: block";
            }
        }
    }
}