/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercializadora.dao;

import Comercializadora.models.Empleado;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface IEmpleadoDao {
    public List<Empleado> listAll();
    public String insert(Empleado emp);
    public String update(Empleado emp);
    public String delete(Empleado emp);
    public Empleado findById(long idEmpleado);
}
