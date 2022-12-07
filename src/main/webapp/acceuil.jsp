

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <script type="text/javascript">
            function clearSearch(){
            $('input:checked').removeAttr('checked');}
});
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceuil</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex flex-column ">
            <div>
                <nav class="navbar navbar-dark  " style="float: right">
                    <a href="login.jsp">EN</a>&nbsp;&nbsp;
                    <a href="login.jsp">FR</a>&nbsp;&nbsp;
                    <a class="btn btn-light " role="button" href="login.jsp">Log in</a>
                    <a class="btn btn-light " role="button" href="login.jsp">Signup</a>
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
                    <div class="col-3">
                        <input type="button" class="quickview btn btn-info col-12 mt-2" value="Clear" id="btnClear" onclick=""/>
                        <div>
                            <h6>Companion</h6>
                            <form class="ml-md-2">
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="companion" id="cat">
                                    <label for="boring" class="pl-1 pt-sm-0 pt-1">Cat</label>
                                </div>
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="companion" id="dog">
                                    <label for="ugly" class="pl-1 pt-sm-0 pt-1">Dog</label>
                                </div>

                            </form>
                            <h6>Type</h6>
                            <form class="ml-md-2">
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="type" id="Food">
                                    <label for="food" class="pl-1 pt-sm-0 pt-1">Food</label>
                                </div>
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="type" id="Supply">
                                    <label for="supply" class="pl-1 pt-sm-0 pt-1">Supply</label>
                                </div>
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="type" id="Toy">
                                    <label for="Toy" class="pl-1 pt-sm-0 pt-1">Toy</label>
                                </div>
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="type" id="Treat">
                                    <label for="Treat" class="pl-1 pt-sm-0 pt-1">Treat</label>
                                </div>
                            </form>
                            <h6>Price</h6>
                            <form class="ml-md-2">
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="price" id="price0-20">
                                    <label for="price0-20" class="pl-1 pt-sm-0 pt-1">$0-$19.99</label>
                                </div>
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="price" id="price20-50">
                                    <label for="price20-50" class="pl-1 pt-sm-0 pt-1">$20-$49.99</label>
                                </div>
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="price" id="price50-100">
                                    <label for="price50-100" class="pl-1 pt-sm-0 pt-1">$50-$99.99</label>
                                </div>
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="price" id="price100-500">
                                    <label for="price100-500" class="pl-1 pt-sm-0 pt-1">$100-$499.99</label>
                                </div>
                            </form>
                            <h6>Available in store</h6>
                            <form class="ml-md-2">
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="available" id="available">
                                    <label for="available" class="pl-1 pt-sm-0 pt-1">Available</label>
                                </div>
                                <div class="form-inline border rounded p-sm-2 my-2">
                                    <input type="radio" name="available" id="notAvailable">
                                    <label for="notAvailable" class="pl-1 pt-sm-0 pt-1">Not available</label>
                                </div>     
                            </form>

                        </div>
                    </div>
                    <div class="col-9">
                        <div class="row">
                            <c:forEach var="product" items="${requestScope.listProduct}" >
                                <div class="col-md-4 col-sm-6 d-inline-flex card h-150 " style="margin-bottom: 10px;">
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
