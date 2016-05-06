/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.63
 * Generated at: 2016-02-13 00:08:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.musicstore.*;
import com.musicstore.entities.*;
import java.util.List;
import java.util.Map;

public final class StoreManager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      com.musicstore.model.AlbumModel albumModel = null;
      albumModel = (com.musicstore.model.AlbumModel) _jspx_page_context.getAttribute("albumModel", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (albumModel == null){
        throw new java.lang.InstantiationException("bean albumModel not found within scope");
      }
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write(" <!-- Meta tag used for responsive web  -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("          \r\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/vendors/css/normalize.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/vendors/css/grid.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/resources/css/style.css\">\r\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,100,300italic' rel='stylesheet' type='text/css'>\r\n");
      out.write("        \r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Manager page</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<header>\r\n");
      out.write("\t            <nav>\r\n");
      out.write("\t                <div class=\"row\">\r\n");
      out.write("\t                    <img src=\"../resources/resources/img/logo.png\" alt=\"MusicStore logo\" class=\"logo\">\r\n");
      out.write("\t                    <ul class=\"main-nav\">\r\n");
      out.write("\t                        <li class=\"first\"><a href=\"/MusicStoreSpringMVC/\" id=\"current\">Home</a></li>\r\n");
      out.write("\t                        <li><a href=\"/MusicStoreSpringMVC/Store/\">Store</a></li>\r\n");
      out.write("\t                        <li><a href=\"/MusicStoreSpringMVC/ShoppingCart/\">Cart (");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${itemNumbers}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(")</a></li>\r\n");
      out.write("\t                    </ul>\r\n");
      out.write("\t                   \r\n");
      out.write("\t                </div>\r\n");
      out.write("\t            </nav>\r\n");
      out.write("\t        </header>\r\n");
      out.write("            \r\n");
      out.write("         \r\n");
      out.write("\t\r\n");
      out.write("\t<h2>Manager Index</h2>\r\n");
      out.write("\t<h3 style=\"color:Red\"><a href=\"/MusicStoreSpringMVC/StoreManager/CreateAlbum\">Create New</a></h3>\r\n");
      out.write("\t\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>Genre</th>\r\n");
      out.write("\t\t\t\t<th>Artist</th>\r\n");
      out.write("\t\t\t\t<th>Title</th>\r\n");
      out.write("\t\t\t\t<th>Price</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t<th></th>\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t");
for (Album myAlbum : albumModel.findAllAlbums()) { 
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t");
int tempGenreId = myAlbum.getGenre().getGenreId(); 
      out.write("\r\n");
      out.write("\t\t\t\t\t");
int tempArtistId = myAlbum.getArtist().getArtistId(); 
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(albumModel.findGenreByIdFromAlbumDao(tempGenreId).getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(albumModel.findArtistByIdFromAlbumDao(tempArtistId).getArtistName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(myAlbum.getTitle() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(myAlbum.getPrice() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"EditAlbum?editAlbumId=");
      out.print(myAlbum.getAlbumId() );
      out.write("\">Edit</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"DetailsAlbum?detailsAlbumId=");
      out.print(myAlbum.getAlbumId() );
      out.write("\">Details</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"DeleteAlbum?deleteAlbumId=");
      out.print(myAlbum.getAlbumId() );
      out.write("\">Delete</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("<!-- \t<div id=\"footer\"><h3>Build with Spring MVC</h3></div> -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
