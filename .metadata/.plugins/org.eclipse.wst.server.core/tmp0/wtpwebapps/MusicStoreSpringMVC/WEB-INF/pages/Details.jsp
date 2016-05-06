<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <!-- Meta tag used for responsive web  -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
          
         <link rel="stylesheet" type="text/css" href="../resources/vendors/css/normalize.css">
        <link rel="stylesheet" type="text/css" href="../resources/vendors/css/grid.css">
        <link rel="stylesheet" type="text/css" href="../resources/resources/css/style.css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,100,300italic' rel='stylesheet' type='text/css'>
        
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Store Details</title>
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
            
            <div id="categories">
				<div class="row">
					<c:forEach items="${genreList}" var="myGenre">
						<c:url var="albumUrl" value="Browse?genre=${myGenre.name}" />
						<h3><a href="${ albumUrl }"><c:out value="${myGenre.name}" /></a></h3>
					</c:forEach>
				</div>
			</div>	
	
	<form:form  modelAttribute="addedAlbum" method="POST" commandName="addedAlbum" action="/MusicStoreSpringMVC/Store/Details?albumId=${addedAlbum.albumId}">
		<h1><c:out value="${foundAlbum.title}"/></h1>
		<img alt="Album art of album : ${detailedAlbum.title}" src="../resources/Images/placeholder.gif"></img><br/><br/>
		<h4><c:out value=" Genre: ${detailedAlbum.genre.name}" /></h4>
		<h4><c:out value=" Artist: ${detailedAlbum.artist.artistName}" /></h4>
		<h4><c:out value=" Price: ${detailedAlbum.price}" /></h4>
		
		<input type="submit" value="Add to Cart" />
	</form:form>
	
<!-- 	<div id="footer"><h3>Build with Spring MVC</h3></div> -->
</body>
</html>