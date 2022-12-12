

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <script type="text/javascript">
            function clearSearch() {
                $('input:checked').removeAttr('checked');
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceuil</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="scripts/accueil.js"></script>
    </head>
    <body>
        <div class="d-flex flex-column ">
            <div>
                <nav class="navbar navbar-dark  " style="float: right">
                    <a href="login.jsp">EN</a>&nbsp;&nbsp;
                    <a href="login.jsp">FR</a>&nbsp;&nbsp;
                    <c:choose>
                        <c:when test="${requestScope.user == null}">
                            <a class="btn btn-light " role="button" href="login.jsp">Log in</a>
                            <a class="btn btn-light " role="button" href="register.jsp">Signup</a>
                        </c:when>
                        <c:otherwise>
                            <a class="btn btn-light " role="button" href="Logout">Log out</a>
                        </c:otherwise>
                    </c:choose>
                </nav>
            </div>
            <div class="bg-secondary m-2 p-1 d-flex flex-row">
                <img src="<c:url value="/images/headerDog.jpg"/>" class="rounded-circle" width="100"/>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <h1 class="align-self-center">Jo & Sam Petstore</h1>
            </div>
            <br>
            <br>
            <div class="container col-11 m-2">
                <div class="row">
                    <div class="col-2" >
                        <input type="button" class="quickview btn btn-info col-12 mt-2" value="Clear" id="btnClear" onclick="filter('/A11_TP2/CreateFilters?')"/>
                        <div id="filterContainer">

                        </div>
                    </div>
                    <div class="col-10">
                        <div class="row d-flex flex-row justify-content-around">
                            <c:forEach var="product" items="${sessionScope.listProduct}" >
                                <%--<div class="col-md-3 col-sm-6 d-inline-flex card h-150 m-1" id="productCard${product.id}" style="margin-bottom: 10px;">--%>
                                <div class="col-sm-6 d-inline-flex card h-150" id="productCard${product.id}" style="margin-bottom: 10px;max-width: 32%">
                                    <div class="card-body d-flex flex-column align-items-center">
                                        <div class="">
                                            <div class="d-flex flex-row mb-3" >
                                                <img src="<c:url value="/images/${product.imageName}"/>" width="200"/>
                                            </div>
                                            <div class="card-title ">
                                                <div class="tile-heading-container">
                                                    <a>${product.categorie} ${product.type}</a>
                                                </div>
                                                <div>
                                                    <h5 class="tile-heading ">
                                                        <a>${product.description}</a>
                                                    </h5>
                                                </div>
                                                <div>
                                                    <a>${product.price}$</a>
                                                </div>
                                            </div>     
                                        </div>
                                    </div>
                                    <div class="d-flex align-self-center" style="width: 85% ; margin-bottom:5px">
                                        <button type="button" class="quickview btn btn-secondary col-12 mt-2" >Add to cart</button>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div> </div>
</html>
