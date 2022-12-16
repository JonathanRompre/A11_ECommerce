<%-- 
    Document   : cart
    Created on : 13 déc. 2022, 17 h 17 min 41 s
    Author     : Samuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <script src="scripts/checkout.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="styles/styles.css"/>
        
    </head>
    
    <body>
        <div class="d-flex flex-column ">
            <div id="banner">
                <jsp:include page="/WEB-INF/banner.jsp"/>
            </div>
            <div class="container my-3 table-responsive">
                <div class="d-flex py-3"><h3>Total Price: <span id="total" class="total">0</span> $ </h3> <button class="mx-3 btn btn-primary" onclick="produceInvoice(confirm('Are you sure you want to checkout this cart?'))">Check Out</button>  </div>
                <table id="cartTable" class="table table-light text-center ">
                    <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">Price</th>
                            <th scope="col">Amount</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach  var="item" items="${sessionScope.checkoutList}">
                            <tr class="text-center ">
                                <td class="align-middle"><img src="<c:url value="/images/${item.product.imageName}"/>" width="100"/></td>
                                <td class="align-middle">${item.product.categorie} ${item.product.type}</td> 
                                <td class="align-middle">${item.product.description}</td> 
                                <td class="price align-middle " id="price${item.cartProduct.id}" name="price" value="${item.product.price}">$${item.product.price} </td> 
                                <td class="align-middle">$ <span id="amount" class="amount"></span></td>
                                <td class="align-middle">
                                    <div >
                                        <input class="qty text-center align-middle form-control border-secondary"  min="1" max="50" type="number" name="qty" id="cartQty${item.cartProduct.id}" value="${item.cartProduct.quantity}" style="width:60px" oninput="UpdateCartQty(${item.cartProduct.id})"/>
                                    </div>
                                </td > 
                                <td class="align-middle"><button type="button" class="quickview btn btn-danger col-12" onclick="deleteProduct(${item.cartProduct.id})" >Delete</button></td> 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <br>
            <br>
        </div>
    </body>
    <jsp:include page="/WEB-INF/footer.jsp"/>
</html>
