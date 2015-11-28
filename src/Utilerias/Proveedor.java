/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

/**
 *
 * @author JossuéEslí
 */
public class Proveedor {
    int id;
    String razon_social;
    
    public Proveedor(int id, String razon_social){
        this.id = id;
        this.razon_social = razon_social;
    }
    
    public int getId(){
        return this.id;
    }
    
    @Override
    public String toString(){
        return this.razon_social;
    }
    
    @Override
    public boolean equals(Object buscado){
        if(buscado == null){
            return false;
        }
        if(!(buscado instanceof Proveedor)){
            return false;
        }
        Proveedor aux = (Proveedor) buscado;
        if(id != aux.id){
            return false;
        }else{
            return true;
        }
    }//fin del metodo equals
}//fin de la clase