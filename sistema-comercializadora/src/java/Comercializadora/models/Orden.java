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
public class Orden {
    private long ordenId;
    private long empleadoId;
    private long clienteId;
    private Date fechaOrden;
    private double descuento;
}
