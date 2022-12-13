<%-- 
    Document   : GenProducts
    Created on : Dec. 12, 2022, 11:03:17 a.m.
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<c:forEach var="product" items="${sessionScope.listProduct}" >
    
    <div class="col-sm-6 d-inline-flex card" id="productCard${product.id}" style="margin-bottom: 10px;max-width: 32%">
        <form name="AddToCartForm" action="AddToCart" method="POST">
            <div class="card-body d-flex flex-column align-items-center">
                <div class="row" style="">
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
                <input type="hidden" id="pid" name="pid" value="${product.id}"/>
                <div class="row mb-3 w-75" >
                    <c:choose>
                        <c:when test="${sessionScope.uid != null}">
                            <button type="submit" class="quickview btn btn-secondary col-12 mt-2" >Add to cart</button>
                        </c:when>
                        <c:otherwise>
                            <button type="button" class="quickview btn btn-secondary col-12 mt-2" onclick="alert('Please login in before adding an item to the cart.')">Add to cart</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form>
    </div>
</c:forEach>
