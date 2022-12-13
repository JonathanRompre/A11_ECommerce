

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
        <link rel="stylesheet" href="styles/styles.css"/>
    </head>
    <body>
        <div class="d-flex flex-column ">
            <div id="banner">
                <jsp:include page="/WEB-INF/banner.jsp"/>
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
                        <div class="row d-flex flex-row justify-content-around" id="productContainer">

                        </div>
                    </div>
                </div>
            </div> 
        </div>
</html>
