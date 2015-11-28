/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Conexion {
    // Atributos
    public Connection conexion;//Nombre de conexión a la base de datos
    public Statement orden;//Sentencia sql de actualización
    public ResultSet datos;//Resultados de consulta
    public PreparedStatement ordenEditar;//Sentencia de actualización diferida
    public PreparedStatement ordenDetail;//Sentencia de actualización diferida en tabla detalle
    private String ultimoSql;//Se agregó
    /**
     * Constructor for objects of class DataBase
     */
    public Conexion(){
        // initialise instance variables
        conexion = null;
    }
    /**
     * Permite Establecer una conexion a la base de datos
     * @param  None
     * @return true: si se logro establecer la conexion
     *         false:Fallo en la conexion.
     */    
    public boolean Open(){//Devuelve false(no conectado) o true(conectado)
       String driver=null, url=null; 
       driver = "com.mysql.jdbc.Driver";
       url    = "jdbc:mysql://192.100.162.120/uan";
       try{
           // Se carga la clase de conectividad a MySql
          Class.forName(driver);      
          conexion=DriverManager.getConnection(url, "equipo01", "equipo-2015");
         }     
       catch(ClassNotFoundException e){
          JOptionPane.showMessageDialog(null,"Problema al cargar el driver de MySql","DataBase",JOptionPane.ERROR_MESSAGE);
          System.exit(0);
         }
       catch (SQLException e){
          JOptionPane.showMessageDialog(null,"No se pudo establecer enlace a la base de datos","DataBase",JOptionPane.ERROR_MESSAGE);
          System.exit(0);
         }           
         //JOptionPane.showMessageDialog(null,"Conexion a la base de datos exitosa","DataBase",JOptionPane.INFORMATION_MESSAGE);
         return true;
    } // Fin del metodo Open   

    /**
     * Permite Cerrar una conexion a la base de datos
     * @param  None
     * @return true: si se logro cerrar la conexion
     *         false:Fallo al cerrar la conexion.
     */    
    public boolean Close(){
        try{          
          conexion.close();//cierra la conexión de la base de datos para ahorrar recursos
          return true;
        }
        catch (SQLException e){
          JOptionPane.showMessageDialog(null,"Problema al cerrar la conexion","DataBase",JOptionPane.ERROR_MESSAGE);            
          return false;
        }
    }
    public void EjecutarSQL(String sql){  
        try{
          orden = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
          datos = orden.executeQuery(sql);//ejectutar un sql
        }
        catch (SQLException Error){
            JOptionPane.showMessageDialog(null, Error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String args[]){
        
    }
} //fin clase