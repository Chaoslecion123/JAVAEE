/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercializadora.dao;

import Comercializadora.conexiones.BaseDatosPG;
import Comercializadora.models.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.sql.Date;

/**
 *
 * @author fernando
 */
public class EmpleadoJDBCDAO implements IEmpleadoDao {

    @Override
    public List<Empleado> listAll() {
        Empleado empleado;
        List<Empleado> listaEmpleados = new ArrayList<>();
        BaseDatosPG base = new BaseDatosPG();
        try {
            
            String sql = "select * from empleados";
            PreparedStatement ps = base.getConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                long id = rs.getInt("empleadoid");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fechaNac = rs.getDate("fecha_nac");
                int reportaA = rs.getInt("reporta_a");
                int extension = rs.getInt("extension");
              
                
                empleado = new Empleado(id, nombre, apellido, fechaNac, reportaA, extension);
                
                if(reportaA > 0){
                    Empleado jefe = findById(reportaA);
                    empleado.setJefe(jefe.getNombreCompleto());
                }
                
                listaEmpleados.add(empleado);
            }
            
            base.desconectarBD();
        } catch (SQLException ex) {
            System.out.println("Error el listAll de empleados: " + ex.getMessage());
            base.desconectarBD();
        }
        
        return listaEmpleados;
        
    }

    @Override
    public String insert(Empleado emp) {
        
            String mensaje = "";
            BaseDatosPG base = new BaseDatosPG();
        try{
            
            String sql = "insert into empleados (empleadoid, nombre,apellido,fecha_nac,reporta_a,extension)"
                    + "values(?,?,?,?,?,?)";
            PreparedStatement ps = base.getConnection().prepareCall(sql);
            ps.setLong(1, emp.getEmpleadoId());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setDate(4, (Date) emp.getFecha_nac());
            ps.setInt(5,emp.getReporta_a());
            ps.setInt(6, emp.getExtension());           
            ps.executeUpdate();
            mensaje = "El empleado  se ha creado correctamente";
            
            base.desconectarBD();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            mensaje = "No fue posible registrar la categoria" + ex.getMessage();
        }
        return mensaje;
        
        
    }

    @Override
    public String update(Empleado emp) {
        
        String mensaje = "";
        BaseDatosPG base = new BaseDatosPG();
        try{          
            //String sql = "insert into empleados (empleadoid, nombre,apellido,fecha_nac,reporta_a,extension)"

            String sql = "UPDATE empleados SET nombre = ?, nombre=?,fecha_nac=?,reporta_a=?,extension=?"
                    + "WHERE categoriaid = ?";
            PreparedStatement ps = base.getConnection().prepareCall(sql);            
            ps.setLong(1, emp.getEmpleadoId());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setDate(4, (Date) emp.getFecha_nac());
            ps.setInt(5,emp.getReporta_a());
            ps.setInt(6, emp.getExtension());  
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
    public String delete(Empleado emp) {
        BaseDatosPG base = new BaseDatosPG();       
        String mensaje = "";
        try{          
            String sql = "delete from categorias where empleadoid=?";                    
            PreparedStatement ps = base.getConnection().prepareCall(sql);            
            ps.setLong(1, emp.getEmpleadoId());
            ps.executeUpdate();
            mensaje = "se ha eliminado la categoria";
            
            base.desconectarBD();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            mensaje = "No fue posible eliminar   la categoria" + ex.getMessage();
        }
        return mensaje;
    }

    @Override
    public Empleado findById(long idEmpleado) {

        Empleado empleado  = null;
        BaseDatosPG base = new BaseDatosPG();
        try {
            
            String sql = " select * from empleados where empleadoid=? LIMIT 1";
            PreparedStatement ps = base.getConnection().prepareCall(sql);
            ps.setLong(1, idEmpleado);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                long id = rs.getInt("empleadoid");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fechaNac = rs.getDate("fecha_nac");
                int reportaA = rs.getInt("reporta_a");
                int extension = rs.getInt("extension");
              
                
                empleado = new Empleado(id, nombre, apellido, fechaNac, reportaA, extension);
                
                if(reportaA > 0){
                    Empleado jefe = findById(reportaA);
                    empleado.setJefe(jefe.getNombreCompleto());
                }
                
            }           
             base.desconectarBD();
                    
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            base.desconectarBD();
        }
        
        return empleado;
    }
    
}
