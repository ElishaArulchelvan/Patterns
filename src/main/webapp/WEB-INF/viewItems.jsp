<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>
<link href= "webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"></link>

<c:url var="viewItemsURL" value="/viewItems" />
<c:url value="/delete" var="deleteItemURL" />
<c:url var="PhoneUrl" value="/searchByCategory?category=Phone"  />
<c:url var="LaptopUrl" value="/searchByCategory?category=Laptop"  />
<c:url var="TVUrl" value="/searchByCategory?category=TV"  />
<c:url var="TabletUrl" value="/searchByCategory?category=Tablet"  />

<div class="container">

	<h1>Items</h1>

	<div class="row">
		<div class="col-md-12">
		<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center"><a href="${PhoneUrl}">Phones </a></th>
						<th class="text-center"><a href="${LaptopUrl}">Laptops</a></th>
						<th class="text-center"><a href="${TVUrl}">TV </a></th>
						<th class="text-center"><a href="${TabletUrl}">Tablets</a></th>
					</tr>
				</thead>
				</table>
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center col-md-1">Item ID.</th>
						<th class="text-center">Title </th>
						<th class="text-center">Manufacturer </th>
						<th class="text-center">Price</th>
						<th class="text-center">Category</th>
					</tr>
				</thead>
				<tbody>
	
					<c:forEach items="${itemList}" var="item">
						<tr>
							<td>${item.getItemId()}</td>
							<td>${item.getTitle()}</td>
							<td>${item.getManufacturer()}</td>
							<td>${item.getPrice()}</td>
							<td>${item.getCategory()}</td>
							<td><a href="<c:url value='/delete/${item.itemId}'  />" class="btn btn-danger custom-width" path="status">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			</form>
		</div>
	</div>

</div>