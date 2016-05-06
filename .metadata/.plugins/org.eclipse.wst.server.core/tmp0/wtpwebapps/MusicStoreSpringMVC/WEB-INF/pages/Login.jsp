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
        
<title>Login page</title>
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
            
         
	
	<div id="Login-error">${error}</div>
	<div class="section-login">
	<form:form modelAttribute="login" method="POST" commandName="login" action="/MusicStoreSpringMVC/Account/login">
		
			<h2>Account Information</h2>
			
			<h4>Username</h4>
			<form:input path="username"/><br/><br/>
			
			<h4>Password</h4>
			<form:password path="password"/><br/><br/>
			
			<input type="submit" value="Login" /><br/><br/>
			<h4><a href="/MusicStoreSpringMVC/Account/register"/>Click here to register</h4>
	
	</form:form>
	</div>
<!-- 	<div id="footer"><h3>Build with Spring MVC</h3></div> -->
</body>
</html>