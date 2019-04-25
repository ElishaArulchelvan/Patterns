<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>
<link href= "webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"></link>

<c:url value="/payment" var="paymentURL"/>

<div class="container">

	 <div class="row">
        <form action="${paymentURL}" method="post" role="form" class="form-horizontal">
			<h3>Order </h3>
					<div class="row">
						<div class="col-xs-7 text-left">Total:</div>
						<div class="col-xs-5 text-right">
						<span ${orders.getTotal()}></span>
						</div>
					</div>

            <div class="form-group">
                <label for="date">Shipping Address</label>
                <div class="col-sm-100">
                    <input type="text" id="shippingaddress" class="form-control" placeholder="Shipping Address" autofocus>
                </div>
            </div>

            <div class="form-group">
                <label for="nameCard">Name on Card:</label>
                <div class="col-sm-100">
                    <input type="text" id="nameCard" class="form-control" placeholder="Name on Card">
                </div>
            </div>

            <div class="form-group">
				<label for="cardType">Select Card Type:</label> <select
					class="form-control" id="cardType" name="type">
					<option value="visa">Credit Card</option>
					<option value="mastercard">Debit Card</option>
					</select>
			</div>

           <div class="form-group">
				<label>Expiration Date</label>
					<div class="row">
					<div class="col-xs-100">
					 <select class="form-control" name="expiryMonth">
						<option disabled="disabled">-- Month --</option>
						<option value="01">Jan (01)</option>
						<option value="02">Feb (02)</option>
						<option value="03">Mar (03)</option>
						<option value="04">Apr (04)</option>
						<option value="05">May (05)</option>
						<option value="06">June (06)</option>
						<option value="07">July (07)</option>
						<option value="08">Aug (08)</option>
						<option value="09">Sep (09)</option>
						<option value="10">Oct (10)</option>
						<option value="11">Nov (11)</option>
						<option value="12">Dec (12)</option>
					</select>
				</div>
				<div class="col-xs-100">
					<select class="form-control" name="expiryYear">
						<option disabled="disabled">-- Year --</option>
						<option value="19">2019</option>
						<option value="20">2020</option>
						<option value="21">2021</option>
						<option value="22">2022</option>
						<option value="23">2023</option>
						<option value="23">2024</option>
						<option value="23">2025</option>
						<option value="23">2026</option>
						<option value="23">2027</option>
						<option value="23">2028</option>
						<option value="23">2029</option>
					</select>
				</div>
	</div>
	</div>
	<div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" class="btn btn-primary">Confirm</button>
                    <a href="#" class="btn btn-danger">Cancel</a>
                </div>
            </div>
	
        </form>
    </div>
</div>