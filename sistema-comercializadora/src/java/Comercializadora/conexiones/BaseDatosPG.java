/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercializadora.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fernando
 */
public class BaseDatosPG {
   Connection conn = null;
    public BaseDatosPG(){
        //String urlDatabase = "jdbc:postgresql://localhost:5432/pedidos";
             
        try{
            
            Class.forName("org.postgresql.Driver");
           // conn = DriverManager.getConnection(urlDatabase, "postgres","luis123");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos", "postgres", "luis123");
            
        }catch(SQLException ex){
            System.out.println("Excepcion:" + ex.getMessage());
            
        }catch(ClassNotFoundException ex){
            System.out.println("Excepcion no encontro drive:" + ex.getMessage());
        }
    }
    
    public Connection getConnection(){
        return this.conn;
    }
    
    public void desconectarBD(){
        System.out.println("Cerrar conexion a base de datos");
        if(conn != null){
                
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("no se realizo la desconexion: "  + ex.getMessage());
            }
          }
    }
    
    
}
