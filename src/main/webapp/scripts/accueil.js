/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function filter(url) {
    requete = new XMLHttpRequest();
    requete.onreadystatechange = setFiltres;

    requete.open("GET", url, true);

    requete.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    requete.send();
}

function setFiltres() {
    if ((requete.readyState === 4) && (requete.status === 200)) {
        filterBar = requete.responseText;

        $('#filterContainer').html(filterBar);

        productList();
    }
}

function productList() {
    requete = new XMLHttpRequest();
    requete.onreadystatechange = setProducts;

    url = "ProductList";

    requete.open("GET", url, true);

    requete.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    requete.send();
}

function setProducts() {
    if ((requete.readyState === 4) && (requete.status === 200)) {
        products = requete.responseText;

        $('#productContainer').html(products);
    }
}

$(function () {
    filter("/CreateFilters?");
});

function addToCart(productID) {
    requete = new XMLHttpRequest();
    requete.onreadystatechange = validAddToCart;
    url = "AddToCart?pid=" + productID;
    requete.open("GET", url, true);

    requete.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    requete.send();
}

function validAddToCart() {
    if ((requete.readyState === 4) && (requete.status === 200)) {
        response = JSON.parse(requete.responseText);
        if (response.addToCartSucess == true) {
            document.getElementById("cartSize").textContent = response.cartListSize;
        } else {
            alert("Product wasn't added to your cart")
        }
    }
}