/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

/**
 *
 * @author JossuéEslí
 */
public class Linea {
    int id;
    String nombre;
    
    public Linea(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId(){
        return this.id;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
    @Override
    public boolean equals(Object buscado){
        if(buscado == null){
            return false;
        }
        if(!(buscado instanceof Linea)){
            return false;
        }
        Linea aux = (Linea) buscado;
        if(id != aux.id){
            return false;
        }else{
            return true;
        }
    }//fin del metodo equals
}//fin de la clase