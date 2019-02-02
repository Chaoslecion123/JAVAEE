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
public class Cliente {
    private long clienteId;
    private String cedulaRuc;
    private String nombrecia;
    private String direccionCli;
    private String fax;
    private String email;
    private String celular;
    private String fijo;

    public Cliente(long clienteId, String cedulaRuc, String nombrecia, String direccionCli, String fax, String email, String celular, String fijo) {
        this.clienteId = clienteId;
        this.cedulaRuc = cedulaRuc;
        this.nombrecia = nombrecia;
        this.direccionCli = direccionCli;
        this.fax = fax;
        this.email = email;
        this.celular = celular;
        this.fijo = fijo;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public String getCedulaRuc() {
        return cedulaRuc;
    }

    public void setCedulaRuc(String cedulaRuc) {
        this.cedulaRuc = cedulaRuc;
    }

    public String getNombrecia() {
        return nombrecia;
    }

    public void setNombrecia(String nombrecia) {
        this.nombrecia = nombrecia;
    }

    public String getDireccionCli() {
        return direccionCli;
    }

    public void setDireccionCli(String direccionCli) {
        this.direccionCli = direccionCli;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }
    
    
}
