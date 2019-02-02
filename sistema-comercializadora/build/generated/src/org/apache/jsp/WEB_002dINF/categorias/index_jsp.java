package org.apache.jsp.WEB_002dINF.categorias;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Bootstrap Admin Theme v3</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link href=\"");
      out.print( request.getContextPath());
      out.write("/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- styles -->\n");
      out.write("        <link href=\"");
      out.print( request.getContextPath());
      out.write("/css/styles.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layouts/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"page-content\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layouts/sidebar.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-10\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12\"> \n");
      out.write("                                <div class=\"content-box-large\">\n");
      out.write("                                    <div class=\"panel-heading\">\n");
      out.write("                                        <div class=\"panel-title\">Basic Table</div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"panel-body\">\n");
      out.write("                                        <table class=\"table\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>#</th>\n");
      out.write("                                                    <th>First Name</th>\n");
      out.write("                                                    <th>Last Name</th>\n");
      out.write("                                                    <th>Username</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>1</td>\n");
      out.write("                                                    <td>Mark</td>\n");
      out.write("                                                    <td>Otto</td>\n");
      out.write("                                                    <td>@mdo</td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>2</td>\n");
      out.write("                                                    <td>Jacob</td>\n");
      out.write("                                                    <td>Thornton</td>\n");
      out.write("                                                    <td>@fat</td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>3</td>\n");
      out.write("                                                    <td>Larry</td>\n");
      out.write("                                                    <td>the Bird</td>\n");
      out.write("                                                    <td>@twitter</td>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layouts/footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
