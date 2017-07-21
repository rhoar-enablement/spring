<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Product Catalog Admin</title>
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1>Admin - Product List</h1>
            </div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${prodList}" var="product" varStatus="loop">
                    <tr>
                        <td>
                            <a href="/admin/product/${product.itemId}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                        </td>
                        <td>
                            <a href="/admin/product/delete/${product.itemId}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                        </td>
                        <td><c:out value="${product.itemId}"/></td>
                        <td><c:out value="${product.name}"/></td>
                        <td>$<c:out value="${product.price}"/></td>
                        <td><c:out value="${product.description}"/></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/admin/product/add" class="btn btn-default btn-lg">
                <span class="glyphicon glyphicon-plus"></span> Add 
            </a>	  	
        </div>
    </body>
</html>