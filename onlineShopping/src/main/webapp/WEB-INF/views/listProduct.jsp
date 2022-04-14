<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- Would be to display sidebar-->
			<div class="col-md-3">
				<%@include file="./shared/sidebar.jsp"%>
			</div>
			<!-- Would be to display the actual products-->
			<div class="col-md-9">
				<!-- Added breadcrumb product -->
				<div class="row">
					<div class="col-lg-12">
						<c:if test="${userClickAllProducts == true}">
							<script type="text/javascript">
								window.categoryId = '';
							</script>
							<ol class="breadcrumb">
								<li><a href="${contextRoot}/home">Home</a></li>
								<li class="active">All Products</li>
							</ol>
						</c:if>
						<c:if test="${userClickCategoryProducts == true}">
							<script type="text/javascript">
								window.categoryId = '${category.id}';
							</script>
							<ol class="breadcrumb">
								<li><a href="${contextRoot}/home">Home</a></li>
								<li class="active">Category</li>
								<li class="active">${category.name}</li>
							</ol>
						</c:if>
					</div>
				</div>
				
				<div class="row">
					<div class="col-xs-12">
						<table id="productListTable"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Qty. Available</th>
									<th></th>
								</tr>
							</thead>
							 <tfoot>
                            <tr>
                            	<th></th>
                                <th>Name</th>
                                <th>Brand</th>
                                <th>Price</th>
                                <th>Qty. Available</th>
                                <th></th>
                            </tr>
                        </tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>
</body>
</html>