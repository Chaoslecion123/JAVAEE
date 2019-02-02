/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercializadora.dao;

import Comercializadora.conexiones.BaseDatosPG;
import Comercializadora.models.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando
 */
public class CategoriaJDBCDAO implements ICategoriaDao {

    @Override
    public List<Categoria> listAll() {
        // codigo para acceder mediante JDBC a registros
        // de categorias mediante una base de datos
        Categoria cat;
        List<Categoria> listaCategorias = new ArrayList<>();
        try {
            BaseDatosPG base = new BaseDatosPG();
            String sql = "select * from categorias";
            PreparedStatement ps = base.getConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                cat = new Categoria();
                cat.setCategoriaId(rs.getInt("categoriaid"));
                cat.setNombreCat(rs.getString("nombrecat"));
                listaCategorias.add(cat);
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Error el listAll de categorias: " + ex.getMessage());
        }
        
        return listaCategorias;
   
    }
    
    @Override
    public String insert(Categoria cat){
        String mensaje = "";
        try{
            BaseDatosPG base = new BaseDatosPG();
            String sql = "insert into categorias (categoriaid, nombrecat) "
                    + "values(?,?)";
            System.out.println(sql);
            PreparedStatement ps = base.getConnection().prepareCall(sql);
            ps.setLong(1, cat.getCategoriaId());
            ps.setString(2, cat.getNombreCat());
            ps.executeUpdate();
            mensaje = "La categoria  se ha creado correctamente";
            
            base.desconectarBD();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            mensaje = "No fue posible crear la categoria" + ex.getMessage();
        }
        return mensaje;
    }

    @Override
    public Categoria findById(long id) {
        Categoria cat = null;
        
        try {
            BaseDatosPG base = new BaseDatosPG();
            String sql = " select * from categorias where categoriaid=? LIMIT 1";
            PreparedStatement ps = base.getConnection().prepareCall(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cat = new Categoria();
                cat.setCategoriaId(rs.getInt("categoriaid"));
                cat.setNombreCat(rs.getString("nombrecat"));
                
            }           
             base.desconectarBD();
                    
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        return cat;
    }

    @Override
    public String update(Categoria cat) {
         String mensaje = "";
        try{
            BaseDatosPG base = new BaseDatosPG();
            String sql = "UPDATE categorias SET nombreCat = ?"
                    + "WHERE categoriaid = ?";
            PreparedStatement ps = base.getConnection().prepareCall(sql);            
            ps.setString(1, cat.getNombreCat());
            ps.setLong(2, cat.getCategoriaId());
            ps.executeUpdate();
            mensaje = "se actualizó la categoria";
            
            base.desconectarBD();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            mensaje = "No fue posible actualizar la categoria" + ex.getMessage();
        }
        return mensaje;
    }

    @Override
    public String delete(Categoria cat) {
        
        String mensaje = "";
        try{
            BaseDatosPG base = new BaseDatosPG();
            String sql = "delete from categorias where categoriaid=?";                    
            PreparedStatement ps = base.getConnection().prepareCall(sql);            
            ps.setLong(1, cat.getCategoriaId());
            ps.executeUpdate();
            mensaje = "se ha eliminado la categoria";
            
            base.desconectarBD();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            mensaje = "No fue posible eliminar   la categoria" + ex.getMessage();
        }
        return mensaje;
        
        
    }
    
}
