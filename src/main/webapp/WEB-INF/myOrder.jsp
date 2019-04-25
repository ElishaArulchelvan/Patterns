<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>
<link href= "webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"></link>

<c:url var="ordersURL" value="/orders" />

<div class="container">

	<h1>Orders </h1>

	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center">Order id.</th>
						<th class="text-center">Purchased by</th>
						<th class="text-center">Items</th>
						<th class="text-center">Total</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${orderList}" var="orders">
						<tr>
							<td>${orders.getId()}</td>
							<td>${orders.getUser().getEmail()}</td>
							<td>${orders.getTotal()}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>

</div>