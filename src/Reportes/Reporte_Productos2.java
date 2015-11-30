/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;
import javax.swing.*;
import Utilerias.Conexion;

/**
 *
 * @author JossuéEslí
 */
public class Reporte_Productos2 {
    public Reporte_Productos2(){
        Conexion con = new Conexion();
        String orden_sql = "SELECT Producto.id, Producto.codigo, "
                + "Producto.nombre, Producto.precio_costo, "
                + "Producto.precio_venta, Producto.stock, "
                + "(Linea.nombre) as Linea, Proveedor.razon_social "
                + "FROM Producto "
                + "INNER JOIN Linea "
                + "ON Producto.Linea_id = Linea.id "
                + "INNER JOIN Proveedor "
                + "ON Producto.id = Proveedor.id";
        try{
            con.Open();
            con.EjecutarSQL(orden_sql);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.datos);
            JasperPrint reporte = JasperFillManager.fillReport(
                                      "src/Reportes/Reporte_Productos2.jasper", new HashMap(), jrRS);
            JasperViewer.viewReport(reporte, false);
        }catch(Exception error){
            JOptionPane.showMessageDialog(null, "Error al ejecutar el reporte " +error);
        }
    }
    public static void main(String args[]){
        new Reporte_Productos2();
    }
}