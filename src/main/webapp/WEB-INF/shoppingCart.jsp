<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link href= "webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"></link>
<c:url value="/cart/remove" var="deleteItemUrl"/>


<title>Cart</title>
</head>
<body>
	<c:url value="/confirmOrder" var="confirmUrl" />
	<div class="container">
		<h2>Your cart</h2>
		<form action="${confirmUrl}" method="post">
			${cartMessage}
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
					<th class="text-center col-md-1">Item</th>
						<th class="text-center">Title</th>
						<th class="text-center">Quantity</th>
						<th class="text-center">Price</th>
						<th class="text-center">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cartItems" items="${cartItemList}">
						<tr>
							<td><c:out value="${item.title}" /></td>
							<td><c:out value="${item.price}" /></td>
							<td>$<c:out value="${item.key.price}" />
							</td>
							<td class="text-center"><a
								href="${deleteItemUrl}/${item.key.isbn}"
								class="btn btn-sm btn-danger delete-button">Delete</a></td>
						</tr>
					</c:forEach>

					<tr></tr>
					<tr>
						<td>Total</td>
						<td></td>
						<td></td>
						<td></td>
						<td>$${cart.total}</td>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="Confirm Order"></input>
		</form>

	</div>
</body>
