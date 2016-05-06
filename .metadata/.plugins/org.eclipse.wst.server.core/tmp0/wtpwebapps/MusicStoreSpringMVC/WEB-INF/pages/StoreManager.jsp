<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.musicstore.*" %>
<%@page import="com.musicstore.entities.*" %>

<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>

<jsp:useBean id="albumModel" type="com.musicstore.model.AlbumModel" scope="request" />
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
<title>Manager page</title>
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
            
         
	
	<h2>Manager Index</h2>
	<h3 style="color:Red"><a href="/MusicStoreSpringMVC/StoreManager/CreateAlbum">Create New</a></h3>
	
	<table>
		<thead>
			<tr>
				<th>Genre</th>
				<th>Artist</th>
				<th>Title</th>
				<th>Price</th>
				<th></th>
				<th></th>
				<th></th>	
			</tr>
		</thead>
		<tbody>
			<%for (Album myAlbum : albumModel.findAllAlbums()) { %>
				<tr>
					<%int tempGenreId = myAlbum.getGenre().getGenreId(); %>
					<%int tempArtistId = myAlbum.getArtist().getArtistId(); %>
					<td><%=albumModel.findGenreByIdFromAlbumDao(tempGenreId).getName() %></td>
					<td><%=albumModel.findArtistByIdFromAlbumDao(tempArtistId).getArtistName() %></td>
					<td><%=myAlbum.getTitle() %></td>
					<td><%=myAlbum.getPrice() %></td>
					<td><a href="EditAlbum?editAlbumId=<%=myAlbum.getAlbumId() %>">Edit</a></td>
					<td><a href="DetailsAlbum?detailsAlbumId=<%=myAlbum.getAlbumId() %>">Details</a></td>
					<td><a href="DeleteAlbum?deleteAlbumId=<%=myAlbum.getAlbumId() %>">Delete</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
		
<!-- 	<div id="footer"><h3>Build with Spring MVC</h3></div> -->
</body>
</html>