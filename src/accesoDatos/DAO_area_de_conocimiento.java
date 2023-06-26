/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package accesoDatos;

import modelo.Modelo_area_de_conocimiento;
import java.sql.*;

/**
 *
 * @author juanc
 */
public class DAO_area_de_conocimiento {
    
    FachadaBD fachada;
    Connection conexion;

    public DAO_area_de_conocimiento(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_area_de_conocimiento(Modelo_area_de_conocimiento modelo_area_de_conocimiento){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO area_de_conocimiento VALUES ('" +
                modelo_area_de_conocimiento.getCodigo_area_de_conocimiento()+ "', '" + 
                modelo_area_de_conocimiento.getNombre_area_de_conocimiento()+  "', '" +
                modelo_area_de_conocimiento.getDescripcion_area_de_conocimiento()+ "', '" + 
                modelo_area_de_conocimiento.getCodigo_area_padre()+ "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa");
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Modelo_area_de_conocimiento seleccionar_area_de_conocimiento(String codigo_area_de_conocimiento){

        Modelo_area_de_conocimiento modelo_area_de_conocimiento= new Modelo_area_de_conocimiento();
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_area_de_conocimiento, "
                + "nombre_area_de_conocimiento, "
                + "descripcion_area_de_conocimiento, "
                + "codigo_area_padre "
                + "FROM area_de_conocimiento WHERE codigo_area_de_conocimiento = '" + codigo_area_de_conocimiento +  "'";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_area_de_conocimiento.setCodigo_area_de_conocimiento(seleccion.getString(1));
               modelo_area_de_conocimiento.setNombre_area_de_conocimiento(seleccion.getString(2));
               modelo_area_de_conocimiento.setDescripcion_area_de_conocimiento(seleccion.getString(3));
               modelo_area_de_conocimiento.setCodigo_area_padre(seleccion.getString(4));
            }

            System.out.println("Seleccion exitosa");
           
            return modelo_area_de_conocimiento;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    public void actualizar_area_de_conocimiento(Modelo_area_de_conocimiento modelo_area_de_conocimiento, String columna, String valor){

        int numeroFilas=0;
        
        String sql_guardar;
        
        sql_guardar="UPDATE area_de_conocimiento \n" +
                "SET " + columna + " = '" + valor + "' \n" +
                "WHERE codigo_area_de_conocimiento = '" + modelo_area_de_conocimiento.getCodigo_area_de_conocimiento()+"' ;";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Actualizacion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
    } 
    
    public void eliminar_area_de_conocimiento(String codigo_area_de_conocimiento) {
        String sql_eliminar = "DELETE FROM area_de_conocimiento WHERE codigo_area_de_conocimiento = '" + codigo_area_de_conocimiento + "'";

        try {
            Statement sentencia = this.conexion.createStatement();
            int numeroFilas = sentencia.executeUpdate(sql_eliminar);

            if (numeroFilas > 0) {
                System.out.println("Eliminación exitosa");
            } else {
                System.out.println("No se encontró el registro a eliminar");
                }
        } catch (SQLException e) {
            System.out.println("Eliminación fallida");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Eliminación fallida");
            System.out.println(e);
        }
    }
    
}
