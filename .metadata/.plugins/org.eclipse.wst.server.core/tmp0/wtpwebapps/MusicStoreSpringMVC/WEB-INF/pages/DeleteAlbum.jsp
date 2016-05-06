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
        
<title>Insert title here</title>
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
            
        
	
	<h2>Delete Albums</h2>
	
	
	<div class="section-deleteAlbums">
	<h4>Are you sure you want to delete this?</h4>
	<form:form modelAttribute="deleteAlbum" method="POST" commandName="deleteAlbum" action="/MusicStoreSpringMVC/StoreManager/DeleteAlbum?deleteAlbumId=${deleteAlbum.albumId}">
		
			<h3>Album</h3>
			<h4><c:out value=" Genre : ${deleteThisAlbum.genre.name}" /></h4>
			<h4><c:out value=" Artist : ${deleteThisAlbum.artist.artistName}" /></h4>
			<h4><c:out value=" Title : ${deleteThisAlbum.title}" /><br/></h4>
			<h4><c:out value=" Price : ${deleteThisAlbum.price}" /><br/></h4>
			<h4><c:out value=" Album Art URL : ${deleteThisAlbum.albumArtUrl }" /></h4>	
		
		<input type="submit" value="Delete" /> | <a href="/MusicStoreSpringMVC/StoreManager/" id="current">Back To List</a>
	</form:form>
	</div>
<!-- 	<div id="footer"><h3>Build with Spring MVC</h3></div> -->
	
</body>
</html>