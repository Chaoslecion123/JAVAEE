/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercializadora.models;

import java.util.Date;

/**
 *
 * @author fernando
 */
public class Empleado {
    private long empleadoId;
    private String nombre;
    private String apellido;
    private Date fecha_nac;
    private int reporta_a;
    private int extension;
    private String jefe;

    public Empleado(long empleadoId, String nombre, String apellido, Date fecha_nac, int reporta_a, int extension) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.reporta_a = reporta_a;
        this.extension = extension;
    }

  
    
    public Empleado(){
        
    }
    
    public Empleado(long empleadoId){
        this.empleadoId = empleadoId;
    }

    public long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getReporta_a() {
        return reporta_a;
    }

    public void setReporta_a(int reporta_a) {
        this.reporta_a = reporta_a;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }
     
    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }
    

}