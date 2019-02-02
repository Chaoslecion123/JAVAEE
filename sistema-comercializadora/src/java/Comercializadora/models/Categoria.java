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
public class Categoria {
    
    private long categoriaId;
    private String nombreCat;
    
    public Categoria(){
        
    }
    
    public Categoria(long id){
        this.categoriaId = id;
    }
    
    public Categoria(long id, String nombre){
        this.categoriaId = id;
        this.nombreCat = nombre;
    }

    public long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }
    
    
    
}
