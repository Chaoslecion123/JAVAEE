/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercializadora.dao;

import Comercializadora.models.Categoria;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface ICategoriaDao {
    
    public List<Categoria> listAll();
    public String insert(Categoria cat);
    public Categoria findById(long id);
    public String update(Categoria cat);
    public String delete(Categoria cat);
    
}
