<%-- 
    Document   : index
    Created on : 02/02/2019, 12:04:06 AM
    Author     : fernando
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Comercializadora.models.Empleado" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<%= request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/css/styles.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head> 
    <%
        List<Empleado> listEmpleados = null;
        if (request.getAttribute("empleados") != null) {
            listEmpleados = (List<Empleado>) request.getAttribute("empleados");
        }

        String resultado = "";

        if (request.getSession().getAttribute("opEmp") != null) {
            resultado = (String) request.getSession().getAttribute("opEmp");
        }
    %>

    <body>
        <jsp:include page ="../layouts/header.jsp"></jsp:include>

            <div class="page-content">
                <div class="row">

                <jsp:include page = "../layouts/sidebar.jsp"></jsp:include>

                    <div class="col-md-10">
                    <% if (!resultado.isEmpty()) {%>
                    <div class="alert alert-success alert-dismissable fade in"> 

                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <%= resultado%>
                    </div>
                    <% request.getSession().removeAttribute("opEmp"); %>
                    <% }%>
                    <div class="row">
                        <div class="col-md-12"> 
                            <div class="content-box-large">
                                <div class="panel-heading">
                                    <div class="panel-title">Tabla Empleados</div>
                                </div>
                                <div class="panel-body">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>ID Empleado</th>
                                                <th>Nombre</th>
                                                <th>Apelldio</th>
                                                <th>Fecha de Nacimiento</th>
                                                <th>Reporta a</th>
                                                <th>Extensión</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            
                                                <% for(Empleado empleado : listEmpleados ){ %>
                                                    <tr>
                                                        <td> <%= empleado.getEmpleadoId() %> </td>
                                                        <td> <%= empleado.getNombre() %></td>
                                                        <td> <%= empleado.getApellido() %></td>
                                                        <td> <%= new SimpleDateFormat("dd-MM-yyyy").format(
                                                                 empleado.getFecha_nac()) %></td>
                                                        <td> <%= empleado.getJefe() %></td>
                                                        <td><%= empleado.getExtension() %></td>
                                                        <td><a href="empleados?accion=editar&idEmp=<%= empleado.getEmpleadoId() %>" class="btn btn-primary">Editar</a></td>
                                                        <td>
                                                            
                                                            <form action="empleados" method="post">
                                                                <input type="hidden" name="accion" value="borrar">
                                                                <input type="hidden" name="idEmp" value="<%= empleado.getEmpleadoId() %>">
                                                                <input type="submit" value="Borrar" class="btn btn-danger">
                                                            </form>
                                                 
                                                        </td>
                                                    </tr>
                                                <% } %>
                                            
                                        </tbody>
                                    </table>
                                    <a href="categorias?accion=nuevo" class="btn btn-primary btn-lg">Nueva Categoria</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page = "../layouts/footer.jsp"></jsp:include>
    </body>
</html>
