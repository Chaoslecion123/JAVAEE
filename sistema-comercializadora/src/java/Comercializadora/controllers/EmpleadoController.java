/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercializadora.controllers;

import Comercializadora.dao.CategoriaJDBCDAO;
import Comercializadora.dao.EmpleadoJDBCDAO;
import Comercializadora.models.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando
 */
@WebServlet(name = "EmpleadoController", urlPatterns = {"/empleados"})
public class EmpleadoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EmpleadoJDBCDAO daoEmpleado = new EmpleadoJDBCDAO();      
        if(request.getParameter("accion")!= null){
            String accion = (String)request.getParameter("accion");
            
            switch(accion){
                case "nuevo":
                    formNuevo(request,response);
                    break;
                case "editar":
                    formEditar(request,response);
                    break;
            }
            
        }else {
            
            //CategoriaJDBCDAO daoCategoria = new CategoriaJDBCDAO();       
            List<Empleado> listaEmpleados = daoEmpleado.listAll();
            request.setAttribute("empleados",listaEmpleados);
            request.getRequestDispatcher("/WEB-INF/empleados/index.jsp").forward(request, response);
        }
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            if(request.getParameter("accion")!= null){
            String accion = (String)request.getParameter("accion");
            
            switch(accion){
                case "crear":
                    insertarEmpleado(request,response);
                    break;
                case "borrar":
                    borrarEmpleado(request,response);
                    break;
                case "actualizar":
                    actualizarEmpleado(request,response);
                    break;
            }
            
        }
       
    }

    private void formNuevo(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        EmpleadoJDBCDAO daoEmpleado = new EmpleadoJDBCDAO();
        List<Empleado> empleados  = daoEmpleado.listAll();
        request.setAttribute("empleados", empleados);
        
        request.setAttribute("tipoForm", "crear");
        request.getRequestDispatcher("WEB-INF/empleados/form.jsp")
                .forward(request, response);
    }

    private void formEditar(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        long idCat = Long.parseLong(request.getParameter("idCat"));
        
        EmpleadoJDBCDAO daoEmpleado = new EmpleadoJDBCDAO();
        
        Empleado empleado = daoEmpleado.findById(idCat);
        
        if(empleado != null){
            List<Empleado> empleados  = daoEmpleado.listAll();
            request.setAttribute("empleados", empleados);
            request.setAttribute("tipoForm", "actualizar");
            request.setAttribute("empleado",empleado);
            request.getRequestDispatcher("/WEB-INF/empleados/form.jsp").forward(request, response);
        }
    }

    private void insertarEmpleado(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        

        
        try {
            
            long claveEmp = Long.parseLong(request.getParameter("idEmp"));
            String nombreEmp = request.getParameter("nombreEmp");
            String apellidoEmp = request.getParameter("apellidoEmp");
            String fecha_nac = request.getParameter("fecha_nac");
            int reportaA  = Integer.parseInt(request.getParameter("reporta"));
            int extension = Integer.parseInt(request.getParameter("extension"));
            
            
            java.util.Date fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_nac);
            java.sql.Date fechaSQL = new java.sql.Date(fechaNac.getTime());
            
            EmpleadoJDBCDAO empleadoDAO = new EmpleadoJDBCDAO();
            String mensaje = empleadoDAO
                    .insert(new Empleado(claveEmp,nombreEmp,apellidoEmp,fechaSQL,reportaA,extension));
           
            request.getSession().setAttribute("opEmp",mensaje);
            response.sendRedirect("/sitema-comercializadora/empleados");
            
            //response.sendRedirect("/sistema-comercializadora/categorias");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    private void borrarEmpleado(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        long claveEmp = Long.parseLong(request.getParameter("idEmp"));
        
        EmpleadoJDBCDAO empleadoDAO = new EmpleadoJDBCDAO();
        String mensaje = empleadoDAO
                         .delete(new Empleado(claveEmp));
        request.getSession().setAttribute("opEmp", mensaje);
        response.sendRedirect("/sistema-comercializadora/empleados");
        
    }

    private void actualizarEmpleado(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        try {
            long claveEmp = Long.parseLong(request.getParameter("idEmp"));
            String nombreEmp = request.getParameter("nombreEmp");
            String apellidoEmp = request.getParameter("apellidoEmp");
            String fecha_nac = request.getParameter("fecha_nac");
            int reportaA = Integer.parseInt(request.getParameter("reporta"));
            int extension = Integer.parseInt(request.getParameter("extension"));
            
            java.util.Date fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_nac);
            java.sql.Date fechaSQL = new java.sql.Date(fechaNac.getTime());
            
            EmpleadoJDBCDAO empleadoDAO = new EmpleadoJDBCDAO();
            String mensaje = empleadoDAO
                    .update(new Empleado(claveEmp,nombreEmp,apellidoEmp,fechaNac,reportaA,extension));
            
            request.getSession().setAttribute("opEmp", mensaje);
            response.sendRedirect("/sistema-comercializadora/empleados");
        }catch(ParseException ex){
            ex.printStackTrace();
        }
        
    }

}
