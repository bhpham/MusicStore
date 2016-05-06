<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.musicstore.*" %>
<%@ page import="java.util.List" %>
<jsp:useBean id="userModel" class="com.musicstore.model.UserModel" scope="request" />
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
        
<title>Register page</title>

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
	                        <li><a href="/MusicStoreSpringMVC/Account/login">Login</a></li>
	                    </ul>
	                   
	                </div>
	            </nav>
	        </header>
            
            	
	
	<div id="Login-error">${error}</div>
	<div class="section-register">
	<form action="/MusicStoreSpringMVC/Account/register" method="post">
		<fieldset>
			<legend>Login information</legend>
			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" id="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password" /></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input type="password" name="confirmPassword" id="confirmPassword" /></td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>Shipping information</legend>
			<table>
				<tr>
					<td>First name:</td>
					<td><input type="text" name="firstname" id="firstname" /></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td><input type="text" name="lastname" id="lastname" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" name="address" id="address" /></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><input type="text" name="city" id="city" /></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><input type="text" name="state" id="state" /></td>
				</tr>
				<tr>
					<td>Zip code:</td>
					<td><input type="text" name="postalCode" id="postalCode" /></td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><input type="text" name="country" id="country" /></td>
				</tr>
				<tr>
					<td>Email address:</td>
					<td><input type="text" name="email" id="email" /></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><input type="text" name="phone" id="phone" /></td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>Payment</legend>
			<p>We are running a promotion: All musics are free with promotion code "FREE"</p>
			<table>
				<tr>
					<td>Promotion Code:</td>
					<td><input type="text" name="promoCode"/></td>
				<tr>
			</table>
		</fieldset>
		
		<h4><input type="submit" value="Create" /></h4>
		
	</form>
	</div>
	
<!-- 	<div id="footer"><h3>Build with Spring MVC</h3></div> -->
</body>
</html>