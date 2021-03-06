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
        
<title>Create Album</title>
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
         

	<h2>Create new Albums</h2>
	<div class="section-createAlbums">
	<form:form modelAttribute="createAlbum" method="POST" commandName="createAlbum" action="/MusicStoreSpringMVC/StoreManager/CreateAlbum">
		
			<h4>Genre</h4>
			<select name="genreSelected">
				<c:forEach items="${genres}" var="myGenre">
					<option value="${myGenre.genreId }" ${myGenre.name==selectedGenre?'selected':''}> ${myGenre.name }</option>
				</c:forEach>
			</select>
			<br/>
			
			
			<h4>Artist</h4>
			<select name="artistSelected">
				<c:forEach items="${artists}" var="myArtist">
					<option value="${myArtist.artistId}" ${myArtist.artistName==selectedArtist?'selected':''}> ${myArtist.artistName}</option>
				</c:forEach>
			</select>
		 <br/><br/>
		 
		 <h4>Title</h4>
		 <form:input name="txtTitle" path="title" />
		 <br/><br/>

		 <h4>Price</h4>
		 <form:input path="price" />
		 <br/><br/>		 
		 
		 <h4>AlbumArtUrl</h4>
		 <form:input path="albumArtUrl" />
		 <br/><br/>
		 
		<input type="submit" value="Create" /> | <a href="/MusicStoreSpringMVC/StoreManager/" id="current">Back To List</a>
		<br/><br/>
		
	</form:form>	
	
	</div>
	
<!-- 	<div id="footer"><h3>Build with Spring MVC</h3></div> -->
</body>
</html>