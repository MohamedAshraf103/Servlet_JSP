<%@page import="com.model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.controllers.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" href="images/Circle-icons-dolly.svg.png">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Show Products</title>
</head>
<body>
	<div class="w-75 mx-auto my-3 p-4">
		<input type="text" oninput="search(this.value)" id="searchInput"
			placeholder="Search by name" class="form-control mx-auto w-75 my-3">
		<table class="table text-center">
			<thead>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Category</th>
				<th>Description</th>
			</thead>
			<%
			ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
			for (Product p : products) {
			%>
			<tr>
				<td><%=p.getId()%>></td>
				<td><%=p.getName()%></td>
				<td><%=p.getPrice()%></td>
				<td><%=p.getCategory()%></td>
				<td><%=p.getDescription()%></td>
			</tr>
			<%
			}
			%>

		</table>
	</div>
	<div id="updateprod"></div>

</body>
</html>