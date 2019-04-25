<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>
<link href= "webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"></link>

<c:url var="ordersURL" value="/orders" />
<c:url var="paymentURL" value="/payment" />

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
						<tr>
							<td>${orders.getId()}</td>
							<td>${orders.getUser().getEmail()}</td>
							<td>${orders.getTotal()}</td>
						</tr>
				</tbody>
			</table>
			<a href="<c:url value='/payment'/>" class="btn btn-danger custom-width" path="status">Pay</a></td>
		</div>
	</div>

</div>