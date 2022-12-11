/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



function filter(url){
    requete = new XMLHttpRequest();
    requete.onreadystatechange = testFiltre;
    
    requete.open("GET",url,true);
    
    requete.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    
    requete.send();
    
}

function testFiltre(){
    if((requete.readyState === 4) && (requete.status === 200)){
        console.log(requete.responseText);
    }
}