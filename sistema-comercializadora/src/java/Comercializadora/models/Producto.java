/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercializadora.models;

/**
 *
 * @author fernando
 */
public class Producto {
    private long productoId;
    private long proveedorId;
    private long categoriaId;
    private String descripcion;
    private double precioUnit;
    private double existencia;

    public Producto(long productoId, long proveedorId, long categoriaId, String descripcion, double precioUnit, double existencia) {
        this.productoId = productoId;
        this.proveedorId = proveedorId;
        this.categoriaId = categoriaId;
        this.descripcion = descripcion;
        this.precioUnit = precioUnit;
        this.existencia = existencia;
    }

    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    public long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public double getExistencia() {
        return existencia;
    }

    public void setExistencia(double existencia) {
        this.existencia = existencia;
    }
    
    
    
    
    
}
