<%-- 
    Document   : administration
    Created on : Nov. 16, 2022, 2:12:14 p.m.
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Administration</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${!sessionScope.adminAuth == true}">
                <fieldset>
                    <legend>Authentification</legend>
                    <form name="adminAuthForm" action="ViewAdminPage?action=auth" method="POST">
                        <label for="adminPass">Password</label>
                        <input type="password" id="adminPass" name="adminPass"/>
                        <button type="submit">Confirm</button>
                    </form>
                </fieldset>
            </c:when>
            <c:otherwise>
                <div class="offset-1 bg-secondary p-2">
                    <a href="ViewAdminPage?action=exit" class="btn btn-sm btn-outline-light">Exit</a>
                </div>
                <%--  Liste des utilisateurs--%>
                <div class="offset-1 mt-3">
                    <div class="m-2">
                        <h2>Users</h2>
                        <table class="table table-striped">
                            <thead>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Email</th>
                            <th>Activate/Deactivate</th>
                            </thead>
                            <tbody>
                                <c:forEach var="user" items="${userList}">
                                    <tr>
                                        <td>${user.firstName}</td>
                                        <td>${user.lastName}</td>
                                        <td>${user.email}</td>
                                        <td>
                                            <form method="POST" action="ViewAdminPage">
                                                <c:choose>
                                                    <c:when test="${user.suspended == true}">
                                                        <input type="hidden" name="action" value="activateUser"/>
                                                        <input type="hidden" name="id" value="${user.id}"/>
                                                        <button type="submit" class="btn btn-light">Activate</button>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="hidden" name="action" value="deactivateUser"/>
                                                        <input type="hidden" name="id" value="${user.id}"/>
                                                        <button type="submit" class="btn btn-light">Deactivate</button>
                                                    </c:otherwise>
                                                </c:choose>
                                            </form>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>

                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="m-2">
                        <%-- Liste des produits --%>
                        <h3>Produits</h3>
                        <table class="table table-striped">
                            <thead>
                            <th >Category</th>
                            <th >Type</th>
                            <th >Description</th>
                            <th >Unit price</th>
                            <th >Stock</th>
                            <th >Image</th>
                            <th >Active status</th>
                            </thead>
                            <tbody>
                                <c:forEach var="product" items="${productList}">
                                    <tr>
                                        <td>${product.categorie}</td>
                                        <td>${product.type}</td>
                                        <td>${product.description}</td>
                                        <td>${product.price}</td>
                                        <td>${product.quantity}</td>
                                        <td>${product.imageName}</td>
                                        <td>
                                            <form method="POST" action="ViewAdminPage">
                                                <c:choose>
                                                    <c:when test="${product.active== true}">
                                                        <input type="hidden" name="action" value="deactivateProduct"/>
                                                        <input type="hidden" name="id" value="${product.id}"/>
                                                        <button type="submit" class="btn btn-success btn-sm"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="hidden" name="action" value="activateProduct"/>
                                                        <input type="hidden" name="id" value="${product.id}"/>
                                                        <button type="submit" class="btn btn-danger btn-sm"/>
                                                    </c:otherwise>
                                                </c:choose>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            <form method="POST" action="ViewAdminPage">
                                <tr>
                                    <input type="hidden" name="action" value="addProduct"/>
                                    <td><input type="text" required id="category" name="category" value="" placeholder="Category"/></td>
                                    <td><input type="text" required id="type" name="type" value="" placeholder="Type"/></td>
                                    <td><input type="text" required id="description" name="description" value="" placeholder="Description"/></td>
                                    <td><input type="number" required id="unitPrice" step="0.01" name="unitPrice" value="" placeholder="Unit Price"/></td>
                                    <td><input type="text" required id="stock" name="stock" value="" placeholder="Stock"/></td>
                                    <td><input type="text" required id="image" name="image" value="" placeholder="Image"/></td>
                                    <td><button type="submit" class="btn btn-sm">Add</button></td>
                                </tr>
                            </form>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
