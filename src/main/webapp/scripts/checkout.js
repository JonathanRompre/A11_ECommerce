/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function updateQuantityMinus(minus) {
    if (minus.nextElementSibling.value > 1) {
        minus.nextElementSibling.value = Number(minus.nextElementSibling.value) - 1;
    }
}
function updateQuantityPlus(plus) {
    plus.previousElementSibling.value = Number(plus.previousElementSibling.value) + 1;
}

function UpdateCartQty(cpid) {
    requete = new XMLHttpRequest();
    requete.onreadystatechange = validUpdateCart;
    qty = document.getElementById('cartQty' + cpid).value;
    url = "UpdateCartQuantity?cpid=" + cpid + "&cpqty=" + qty;
    requete.open("GET", url, true);

    requete.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    requete.send();
}

function validUpdateCart() {
    if ((requete.readyState === 4) && (requete.status === 200)) {
        response = JSON.parse(requete.responseText);
        if (response.updateSucess == false) {
            alert("Quantity wasn't changed")
        } else {

        }
    }
}
function deleteProduct(cpid) {
    requete = new XMLHttpRequest();
    requete.onreadystatechange = validDeleteProduct;
    url = "DeleteCheckoutProduct?cpid=" + cpid;
    requete.open("GET", url, true);

    requete.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    requete.send();

}
function validDeleteProduct() {
    if ((requete.readyState === 4) && (requete.status === 200)) {
        response = JSON.parse(requete.responseText);
        if (response.updateSucess == false) {
            alert("Product wasn't deleted")
        } else {
            location.reload();
        }
    }
}

$(document).ready(function () {
    update_amounts();
    $('.qty, .price').on('keyup keypress blur change', function () {
        update_amounts();
    });
});
function update_amounts() {
    var sum = 0.0;
    $('#cartTable > tbody  > tr').each(function () {
        var qty = $(this).find('.qty').val();
        var price = $(this).find('.price').text().replace("$", "");
        var amount = (qty * price)
        sum += amount;
        $(this).find('.amount').text('' + amount.toFixed(2));
    });
    $('.total').text(sum.toFixed(2));
}

function produceInvoice(confirmed){
    if(confirmed){
        window.open("Invoice");
        setTimeout(function(){
            window.location.href = "Accueil";
        }, 50);
    }
    
}