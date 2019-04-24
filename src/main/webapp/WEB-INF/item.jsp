<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<link href= "webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"></link>
<%@ include file="/WEB-INF/include/navbar.jsp"%>

<c:url value="/edit" var="editURL" />

<div class="container">

	<div class="row">
		<div class="col-md-12">
		<table class="table table-striped table-hover table-bordered">
		<tr>
			<td>Item title:</td>
			<td>${item.title}</td>
		</tr>
		<tr>
			<td>Manufacturer:</td>
			<td>${item.manufacturer}</td>
		</tr>
		<tr>
			<td>Price:</td>
			<td>${item.price}</td>
		</tr>
		
	</table>
	</div>

	<table>
	<security:authorize access="hasRole('USER')">

			<td class="text-center"><a href="${buyUrl}/${item.iid}"
				class="btn btn-sm btn-primary">Add to Cart</a></td>
			<td class="text-center"><c:choose>
					<c:when test="${item.quantity > 1}"> In stock.
												</c:when>
					<c:otherwise>
												Unavailable</c:otherwise>
				</c:choose></td>
		</security:authorize>
		<security:authorize access="hasRole('ADMIN')">

			<td class="text-center"><a href="${editURL}/${item.id}"
				class="btn btn-sm btn-primary">Add to Cart</a></td>
			<td class="text-center"><c:choose>
					<c:when test="${item.quantity > 1}"> In stock.
												</c:when>
					<c:otherwise>
												Unavailable</c:otherwise>
				</c:choose></td>
		</security:authorize>
		</table>
		</div>
</div>