<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link href= "webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"></link>
<c:url value="/cart/remove" var="deleteItemUrl"/>


<head>
    <meta charset="UTF-8">
    <title>View Cart</title>
</head>
<body>
      <div class="card-header"><h2>Cart Items</h2></div>
         <div class="card card-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cartitems}" var="cartitem">
                        <td>${cartitem.item.title}</td>
                        <td ${cartitem.item.category}></td>
                        <td ${cartitem.item.price}></td>
                        <td ${cartitem.quantity}></td>
                    </c:forEach>
 
                    </tbody>
                </table>
            </div>
   
    <div class="container">
        <h2>Your Cart Total is: <span ${total}></span></h2>
        <br/>
        <a href="@{/homepage/order/{id}(id=${cart.id})}"class="btn btn-secondary" >Order </a>
    </div>

</body>
</html>