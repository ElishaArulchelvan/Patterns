<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>
<link href= "webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"></link>

<c:url var="addItemUrl" value="/addItem" />


<div id="wrapper">
	<div class="custom" id="item">
		<h4 align="center">Add Item</h4>
	</div>
	<div id="main">
		<c:if test="${not empty errorMessage }">
			<div class="error-message">${errorMessage}</div>
		</c:if>
		<div class="contact-left">
			<form:form commandName="addItem" action="${addItemUrl}"
				modelAttribute="itemForm" method="POST" id="formMail">
				<form:hidden path="itemId" />
				<table align="center">

					<tr>
						<td class="custom">Title:</td>
						<td><form:input path="title" /></td>
						<td><form:errors path="title" class="error-message" /></td>
					</tr>
					<tr>
						<td class="custom">Manufacturer:</td>
						<td><form:input path="manufacturer" /></td>
						<td><form:errors path="manufacturer" class="error-message" /></td>
					</tr>
					<tr>
						<td class="custom">Category:</td>
						<td><form:select id="category" path="category">
								<form:option value="" label="Category" />
								<form:options items="${categoryList}" itemLabel="categoryType" />
							</form:select></td>
					</tr>
					<tr>
						<td class="custom">Price:</td>
						<td><form:input path="price" /></td>
						<td><form:errors path="price" class="error-message" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" id="send" /></td>
					</tr>

				</table>

			</form:form>

		</div>

	</div>

</div>

<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>