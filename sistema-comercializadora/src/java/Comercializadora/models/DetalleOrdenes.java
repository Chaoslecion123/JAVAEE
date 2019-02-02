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
public class DetalleOrdenes {
    private long ordenId;
    private long detalleId;
    private long productoId;
    private long cantidad;

    public DetalleOrdenes(long ordenId, long detalleId, long productoId, long cantidad) {
        this.ordenId = ordenId;
        this.detalleId = detalleId;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(long ordenId) {
        this.ordenId = ordenId;
    }

    public long getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(long detalleId) {
        this.detalleId = detalleId;
    }

    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
