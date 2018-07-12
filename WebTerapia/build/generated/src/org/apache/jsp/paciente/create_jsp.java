package org.apache.jsp.paciente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class create_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registro de nuevo paciente</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Registro de nuevo paciente</h1>\n");
      out.write("        <hr>\n");
      out.write("        <form action=\"./paciente\" method=\"POST\">\n");
      out.write("            <label>C&eacute;dula: </label>\n");
      out.write("            <input type=\"text\" id=\"cedula\" name=\"cedula\" placeholder=\"Ingrese su c&eacute;dula\"  required />\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("         \n");
      out.write("            <label>Nombre: </label>\n");
      out.write("            <input type=\"text\" id=\"nombre\" name=\"nombre\" placeholder=\"Ingrese su nombre\"  required />\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <label>Fecha de Nacimiento: </label>\n");
      out.write("            <input type=\"date\" id=\"fechanacimiento\" name=\"fechanacimiento\" placeholder=\"Ingrese su fecha de nacimiento\"  required/>\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <label>Estatura: </label>\n");
      out.write("            <input type=\"number\" id=\"estatura\"  min=\"100\" max=\"235\" name=\"estatura\" />\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <label>Peso: </label>\n");
      out.write("            <input type=\"number\" id=\"peso\"  min=\"32\" max=\"275\" name=\"peso\" />\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <!--<input type=\"submit\" value=\"save\" name=\"command\" />-->\n");
      out.write("            <button type=\"submit\" value=\"save\" name=\"command\">Crear</button>\n");
      out.write("            <!--<input type=\"reset\" value=\"cancel\"/>-->\n");
      out.write("            <button type=\"reset\" value=\"cancel\"><a href=\"./paciente?command=list\"/>Cancelar</a></button>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("                    <a href=\"./paciente?command=list\"/>Listado de pacientes</a>\n");
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
