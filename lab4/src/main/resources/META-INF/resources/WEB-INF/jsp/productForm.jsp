<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false" %>
<html>
	<head>
		<title>Product Catalog Form</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="container">
			<div class="page-header">
				<h1>Admin Product Form</h1>
			</div>
			<sf:form method="POST" modelAttribute="product" >
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Attribute</th>
						<th>Value</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Id:</td>
						<td><sf:input path="itemId" size="40" cssClass="form-control" readonly="true"/></td>
					</tr>
					<tr>
						<td>Name:</td>	
						<td><sf:input path="name" size="40" cssClass="form-control"/></td>
					</tr>
					<tr>
						<td>Price</td>
						<td>
							<div class="input-group">
								<span class="input-group-addon">$</span>
								<sf:input path="price" cssClass="form-control"/>
							</div>
						</td>
					</tr>
					<tr>
						<td>Description</td>
						<td><sf:textarea cols="80" rows="5" path="description" cssClass="form-control"/></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="Save" class="btn btn-default btn-lg"/>
			<input type="button" value="Cancel" class="btn btn-default btn-lg" onClick="window.location='/admin/productlist';"/>
			</sf:form>	
		</div>
	</body>
</html>