/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package accesoDatos;

import modelo.Modelo_profesores_y_areas;
import java.sql.*;

/**
 *
 * @author juanc
 */
public class DAO_profesores_y_areas {
    
    FachadaBD fachada;
    Connection conexion;

    public DAO_profesores_y_areas(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_profesores_y_areas(Modelo_profesores_y_areas modelo_profesores_y_areas){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO profesores_y_areas VALUES ('" +
                modelo_profesores_y_areas.getCodigo_usuario_profesor_pya()+ "', '" + 
                modelo_profesores_y_areas.getCodigo_area_de_interes_pya() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public String seleccionar_profesores_de_area(String codigo_area_de_interes_pya){
        
        String lista_de_profesores = "";
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_usuario_profesor_pya "
                + "FROM profesores_y_areas WHERE codigo_area_de_interes_pya = '" + codigo_area_de_interes_pya +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               lista_de_profesores = lista_de_profesores + "- " + seleccion.getString(1) + "\n";
            }
            
            System.out.println("Seleccion exitosa");
           
            return lista_de_profesores;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    
    public String seleccionar_areas_de_profesor(String codigo_usuario_profesor_pya){
        
        String lista_de_areas = "";
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_area_de_interes_pya "
                + "FROM profesores_y_areas WHERE codigo_usuario_profesor_pya = '" + codigo_usuario_profesor_pya +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               lista_de_areas = lista_de_areas + "- " + seleccion.getString(1) + "\n";
            }
            
            System.out.println("Seleccion exitosa");
           
            return lista_de_areas;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
public void eliminar_profesores_y_areas_p(String codigo_usuario_profesor_pya) {
        String sql_eliminar = "DELETE FROM profesores_y_areas WHERE codigo_usuario_profesor_pya = '" + codigo_usuario_profesor_pya+ "'";

        try {
            Statement sentencia = this.conexion.createStatement();
            int numeroFilas = sentencia.executeUpdate(sql_eliminar);

            if (numeroFilas > 0) {
                System.out.println("Se eliminó el registro correctamente");
            } else {
                System.out.println("No se encontró el registro con el código de profesor y area de interes especificado");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar profesores y areas ");
            System.out.println(e);
        } 
    }

    public void eliminar_profesores_y_areas_a(String codigo_area_de_interes_pya ) {
        String sql_eliminar = "DELETE FROM profesores_y_areas WHERE codigo_area_de_interes_pya ='"+ codigo_area_de_interes_pya  + "'";

        try {
            Statement sentencia = this.conexion.createStatement();
            int numeroFilas = sentencia.executeUpdate(sql_eliminar);

            if (numeroFilas > 0) {
                System.out.println("Se eliminó el registro correctamente");
            } else {
                System.out.println("No se encontró el registro con el código de profesor y area de interes especificado");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar profesores y areas ");
            System.out.println(e);
        } 
    }

}
