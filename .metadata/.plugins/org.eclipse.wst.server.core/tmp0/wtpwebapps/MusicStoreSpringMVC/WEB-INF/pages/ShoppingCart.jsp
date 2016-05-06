<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- Meta tag used for responsive web  -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
          
        <link rel="stylesheet" type="text/css" href="../resources/vendors/css/normalize.css">
        <link rel="stylesheet" type="text/css" href="../resources/vendors/css/grid.css">
        <link rel="stylesheet" type="text/css" href="../resources/resources/css/style.css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,100,300italic' rel='stylesheet' type='text/css'>
        
<title>Customer Cart</title>
</head>
<body>

	<header>
	            <nav>
	                <div class="row">
	                    <img src="../resources/resources/img/logo.png" alt="MusicStore logo" class="logo">
	                    <ul class="main-nav">
	                        <li class="first"><a href="/MusicStoreSpringMVC/" id="current">Home</a></li>
	                        <li><a href="/MusicStoreSpringMVC/Store/">Store</a></li>
	                        <li><a href="/MusicStoreSpringMVC/ShoppingCart/">Cart (${itemNumbers})</a></li>
	                    </ul>
	                   
	                </div>
	            </nav>
	        </header>
            
           
	
	
	<form:form modelAttribute="myCart" method="POST" commandName="myCart" action="/MusicStoreSpringMVC/ShoppingCart/">
		<h2>Review your cart :</h2>	
		<input type="submit" value="Checkout >>" />
		<div style="height:20px"></div>
		<table>
			<thead>
				<tr>
					<th><h4>Album name</h4></th>
					<th><h4>Price (each)</h4></th>
					<th><h4>Quantity</h4></th>
					<th></th>
				</tr>
			</thead>
		 
			<tbody>
				<c:out value="${removedAlbumInfo}" />
				<c:forEach items="${albumList}" var="myAlbum">
					<tr>
						<td><h4><a href="/MusicStoreSpringMVC/Store/Details?albumId=${myAlbum.albumId}"><c:out value="${myAlbum.title }"/></a></h4></td>
						<td><h4><c:out value="${myAlbum.price}"/></h4></td>
						<td><h4><c:out value="1" /></h4></td>
						<td><h4><a href="/MusicStoreSpringMVC/ShoppingCart/?deletedAlbumID=${myAlbum.albumId}"><c:out value="Remove from cart"/></a></h4></td>
					</tr>		
				</c:forEach>
				<tr>
					<td><h4>Total</h4></td>
					<td></td>
					<td></td>
					<td><h4>${ totalPrice }</h4></td>
				</tr>
				
			</tbody>	
		</table>
	
	</form:form>
	
<!-- 	<div id="footer"><h3>Build with Spring MVC</h3></div> -->
	
	
</body>
</html>