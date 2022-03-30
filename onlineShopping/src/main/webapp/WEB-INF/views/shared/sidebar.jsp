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
	<p class="lead">Shop Name</p>
	<div class="list-group">		
		<c:forEach items="${categories}" var="category">
			<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item id="a_${category.name}">${category.name}</a>
		</c:forEach>		
	</div>
</body>
</html>