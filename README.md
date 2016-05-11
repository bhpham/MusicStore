# MusicStore
A full stack Music store web application which sells music albums online, implements basic site administration, membership sign-in, and shopping cart functionality. The store basically display the music categories and albums details, artists for each category. On the other hand, customers can purchase the music albums  and sign up for the membership for future purchase. Besides that, Administrators can be able to manage all the music albums by adding, editing, or deleting the details on each album.

This music store application is implemented using Java J2EE techniques such as Spring, Spring MVC pattern, Hibernate with JPA annotations, HTML5/CSS3 and JSP for front-end, deploying on Tomcat 7.0 Server and Oracle 10g DBMS. 

This store is divided into multiple categories with 13 landing jsp pages:
  Display store's albums and details: index.jsp, storeindex.jsp,  Browse.jsp, Details.jsp
  Shopping cart and orders functionalities: ShoppingCart.jsp, Checkout.jsp  
  Customer's registration and sign-in: Login.jsp, Register.jsp
  Adminitrastion's site: Store Manager.jsp, CreateAlbum.jsp, DetailsAlbum.jsp, DeleteAlbum.jsp, EditAlbum.jsp

Also, We would assume it based on 10 entity classes and 5 controllers to handle and process the landing jsp pages.

To run this application:
1)Compile the program under Eclipse
2)Connect to the Oracle 10g DMBS
3)Deploy this application with Tomcat 7.0 server and run it on the localhost

