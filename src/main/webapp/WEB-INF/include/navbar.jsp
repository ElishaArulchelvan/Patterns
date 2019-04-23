<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<c:url value="/main" var="mainURL" />
<c:url value="/addItem" var="addItemURL" />
<c:url value="/viewItems" var="viewItemsURL" />
<c:url value="/searchByMan" var="searchByManURL" />
<c:url value="/searchByTitle" var="searchByTitleURL" />
<c:url value="/logout" var="logoutURL" />

<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #85BFEC;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #333;
}
</style>
</head>
<body>

<ul>
  <li><a class="active" href="${mainURL}">Main</a></li>
  <sec:authorize access="hasRole('ADMIN')">
	<li>
	<ul class="nav nav-container">
		<li><a href="${addItemURL}">Add Items</a></li>
		<li><a href="${viewItemsURL}">View Items</a></li>
	</ul></li>
	</sec:authorize>
	
	<li>
	<sec:authorize access="hasRole('USER')">
		<li><a href="${viewItemsURL}">View Items</a></li>
		<li>
		<form class="navbar-form" action="${searchByManURL}" method="post">
			<div class="form-group">
				<input type="text" name="manufacturer" class="form-control" placeholder="Manufacturer" />
			</div>
			<button type="submit" class="btn btn-default" align="right">Search</button>
		</form>
	</li>
	<li>
		<form class="navbar-form" action="${searchByTitleURL}" method="post">
			<div class="form-group">
				<input type="text" name="title" class="form-control" placeholder="Title" />
			</div>
			<button type="submit" class="btn btn-default">Search</button>
		</form>
	</li>					
		<li role="separator" class="divider"></li>
		</sec:authorize>
		<li><a href="${logoutURL}">Logout</a></li>
</ul>



</body>
</html>