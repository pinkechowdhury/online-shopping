<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<!--Breadcrumb-->
		<div class="row">
			<div class="col-xs-12">
				<ol class="breadcrumb">
					<li><a href="${contextRoot}/home">Home</a></li>
					<li><a href="${contextRoot}/show/all/products">Products</a></li>
					<li class="active">${product.name}</li>
				</ol>
			</div>
			<div class="col-xs-12 col-sm-8">
                <h3>${product.name}</h3>
			    <hr/>
                <p>${product.description}</p>
			    <hr/>
                <h4>Price: <strong> &euro; ${product.unit_price} /-</strong></h4>
			    <hr/>
                <c:choose>
                	<c:when test="${product.quantity < 1}">
                		<h6>Qty. Available: <span style="color:red">Out of Stock!</span></h6>
                	</c:when>
                	<c:otherwise>
                		 <h6>Qty. Available: ${product.quantity}</h6>
                	</c:otherwise>
                </c:choose>
                <c:choose>
                	<c:when test="${product.quantity < 1}">
                		<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
                    	<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</strike></a>
                	</c:when>
                	<c:otherwise>
                		 <a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
                    		<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
                	</c:otherwise>
                </c:choose>	
                <a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
            </div>
		</div>
	</div>
	<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>
</body>
</html>