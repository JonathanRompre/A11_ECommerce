/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function register() {
    console.log("register");
    requete = new XMLHttpRequest();

    url = "RegisterValidation";

    requete.onreadystatechange = traiterValidation;

    requete.open("POST", url, true);
    requete.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    requete.send("firstName=" + $('#firstName').val() +
            "&lastName=" + $('#lastName').val() +
            "&email=" + $('#email').val() +
            "&password=" + $('#password').val() +
            "&passwordConfirm=" + $('#passwordConfirm').val());
    return false;
}

function traiterValidation(){
    if(requete.readyState === 4 && requete.status === 200){
        $(document.body).html(requete.responseText);
        if($('#registrationSuccess').val() == "true"){
            setTimeout(function(){
                window.location.href="Login";
            },4000);
        }
    }
}
