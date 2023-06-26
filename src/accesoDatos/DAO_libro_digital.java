/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package accesoDatos;

import modelo.Modelo_libro_digital;
import java.sql.*;

/**
 *
 * @author juanc
 */
public class DAO_libro_digital {
    
    FachadaBD fachada;
    Connection conexion;

    public DAO_libro_digital(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_libro_digital(Modelo_libro_digital modelo_libro_digital){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO libro_digital VALUES ('" +
                modelo_libro_digital.getIsbn_libro_digital()+ "', '" + 
                modelo_libro_digital.getUrl_libro_digital() + "', '" + 
                modelo_libro_digital.getFormato_libro_digital()+ "', '" +
                modelo_libro_digital.getTamanyo_libro_digital() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Modelo_libro_digital seleccionar_libro_digital(String isbn_libro_digital){

        Modelo_libro_digital modelo_libro_digital= new Modelo_libro_digital();
        
        String sql_select;
        sql_select="SELECT "
                + "isbn_libro_digital, "
                + "url_libro_digital, "
                + "formato_libro_digital, "
                + "tamanyo_libro_digital "
                + "FROM libro_digital WHERE isbn_libro_digital = '" + isbn_libro_digital +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_libro_digital.setIsbn_libro_digital(seleccion.getString(1));
               modelo_libro_digital.setUrl_libro_digital(seleccion.getString(2));
               modelo_libro_digital.setFormato_libro_digital(seleccion.getString(3));
               modelo_libro_digital.setTamanyo_libro_digital(seleccion.getString(4));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_libro_digital;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    public void actualizar_libro_digital(Modelo_libro_digital modelo_libro_digital, String columna, String valor){

        int numeroFilas=0;
        
        String sql_guardar;
        
        sql_guardar="UPDATE libro_digital \n" +
                "SET " + columna + " = '" + valor + "' \n" +
                "WHERE isbn_libro_digital = '" + modelo_libro_digital.getIsbn_libro_digital()+"' ;";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Actualizacion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
    } 
    
    public void eliminar_libro_digital(String isbn_libro_digital   ) {
        String sql_eliminar = "DELETE FROM  libro_digital  WHERE isbn_libro_digital = '" +  isbn_libro_digital  + "'";

        try {
            Statement sentencia = this.conexion.createStatement();
            int numeroFilas = sentencia.executeUpdate(sql_eliminar);

            if (numeroFilas > 0) {
                System.out.println("Se eliminó el registro correctamente");
            } else {
                System.out.println("No se encontró el registro con el libro digital especificado");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar el xxx");
            System.out.println(e);
        } 
    }
}
