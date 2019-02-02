/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercializadora.controllers;

import Comercializadora.dao.CategoriaJDBCDAO;
import Comercializadora.dao.EmpleadoJDBCDAO;
import Comercializadora.models.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando
 */
@WebServlet(name = "CategoriaController", urlPatterns = {"/categorias"})
public class CategoriaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
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
            
            CategoriaJDBCDAO daoCategoria = new CategoriaJDBCDAO();       
            List<Categoria> listaCategorias = daoCategoria.listAll();
            request.setAttribute("categorias",listaCategorias);
            request.getRequestDispatcher("/WEB-INF/categorias/index.jsp").forward(request, response);
        }
        
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       if(request.getParameter("accion")!= null){
            String accion = (String)request.getParameter("accion");
            
            switch(accion){
                case "crear":
                    insertarCategoria(request,response);
                    break;
                case "borrar":
                    borrarCategoria(request,response);
                    break;
                case "actualizar":
                    actualizarCategoria(request,response);
                    break;
            }
            
        }
       
            
        }
    private void formNuevo(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
        
        request.setAttribute("tipoForm", "crear");
        request.getRequestDispatcher("WEB-INF/categorias/form.jsp").forward(request, response);
        
    }

    private void insertarCategoria(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
        
        long claveCat = Long.parseLong(request.getParameter("idCat"));
        String nombreCat = request.getParameter("nombreCat");
        
        CategoriaJDBCDAO categoriaDAO = new CategoriaJDBCDAO();
        
        String mensaje = categoriaDAO.insert(new Categoria(claveCat, nombreCat));
        
        request.getSession().setAttribute("operacionCategoria", mensaje);
        
        response.sendRedirect("/sistema-comercializadora/categorias");
    }

    private void formEditar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        long idCat = Long.parseLong(request.getParameter("idCat"));
        
        CategoriaJDBCDAO categoriaDAO = new CategoriaJDBCDAO();
        
        Categoria cat = categoriaDAO.findById(idCat);
        
        if(cat != null){
            request.setAttribute("tipoForm", "actualizar");
            request.setAttribute("categoria",cat);
            request.getRequestDispatcher("/WEB-INF/categorias/form.jsp").forward(request, response);
        }
    }

    private void actualizarCategoria(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        long claveCat = Long.parseLong(request.getParameter("idCat"));
        String nombreCat = request.getParameter("nombreCat");
        
        CategoriaJDBCDAO categoriaDAO = new CategoriaJDBCDAO();
        String mensaje = categoriaDAO.update(new Categoria(claveCat,nombreCat));
        
        request.getSession().setAttribute("operacionCategoria", mensaje);
        response.sendRedirect("/sistema-comercializadora/categorias");
    }

    private void borrarCategoria(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        long claveCat = Long.parseLong(request.getParameter("idCat"));
        CategoriaJDBCDAO categoriaDAO = new CategoriaJDBCDAO();
        String mensaje = categoriaDAO.delete(new Categoria(claveCat));
        
        request.getSession().setAttribute("operacionCategoria", mensaje);
        response.sendRedirect("/sistema-comercializadora/categorias");
       
    }
    


}
