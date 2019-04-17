<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href= "webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"></link>

<c:url value="/register" var="registerURL"/>
<c:url value="/login" var="loginURL"/>

<div class="container">
    <div class="card card-container">
        <h4> Create new account</h4>
        <form action="${registerURL}" method="post" class="form-signin">
            <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required>
            <input name="firstName" type="text" id="inputFirstName" class="form-control" placeholder="First name" required>
            <input name="lastName" type="text" id="inputLastName" class="form-control" placeholder="Last name" required>
            <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>


            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Create</button>
        </form>
        <div class="margin-bottom-10">
            <a href="${loginURL}" class="forgot-password">Back to login</a>
        </div>
    </div>
</div>
<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>
