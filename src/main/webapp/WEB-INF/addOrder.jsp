<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="/WEB-INF/include/navbar.jsp"%>
<link href= "webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"></link>

<c:url var="addOrderURL" value="/addOrder" />

<h1>Create Order</h1>
<div class="container">
	 <div class="form-group">
        <form action="${addOrderURL}" method="post" role="form" class="form-horizontal">
            
            <div class="form-group">
                <label class="control-label col-sm-2" for="Type">Item:</label>
                <div class="col-sm-6">
                    <select name ="item" id="item" class="form-control">
                    	<c:forEach items="${itemList}" var="items">
                    	<option value="${items.getId()}">${items.getTitle()}</option>
                    	</c:forEach>
                    </select>
                </div>
            </div>
      	    <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <a href="#" class="btn btn-danger">Cancel</a>
                </div>
            </div>
        </form>
    </div>
</div>