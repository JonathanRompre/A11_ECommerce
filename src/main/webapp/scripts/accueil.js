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
        filterBar = requete.responseText;
        
        $('#filterContainer').html(filterBar);
        
        productList();
    }
}

function productList(){
    requete = new XMLHttpRequest();
    requete.onreadystatechange = setProducts;
    
    url = "ProductList";
    
    requete.open("GET",url,true);
    
    requete.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    
    requete.send();
}

function setProducts(){
    if((requete.readyState === 4) && (requete.status === 200)){
        products = requete.responseText;
        
        $('#productContainer').html(products);
    }
}

$(function(){
    filter("/A11_TP2/CreateFilters?");
});