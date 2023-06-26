/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package accesoDatos;

import modelo.Modelo_estudiante;
import java.sql.*;

/**
 *
 * @author juanc
 */
public class DAO_estudiante {
    
    FachadaBD fachada;
    Connection conexion;

    public DAO_estudiante(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_estudiante(Modelo_estudiante modelo_estuduante){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO estudiante VALUES ('" +
                modelo_estuduante.getCodigo_usuario_estudiante()+ "', '" + 
                modelo_estuduante.getUniversidad_estudiante() + "', '" +
                modelo_estuduante.getCarrera_estudiante() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Modelo_estudiante seleccionar_estudiante(String codigo_usuario_estudiante){

        Modelo_estudiante modelo_estudiante= new Modelo_estudiante();
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_usuario_estudiante, "
                + "universidad_estudiante, "
                + "carrera_estudiante "
                + "FROM estudiante WHERE codigo_usuario_estudiante = '" + codigo_usuario_estudiante +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_estudiante.setCodigo_usuario_estudiante(seleccion.getString(1));
               modelo_estudiante.setUniversidad_estudiante(seleccion.getString(2));
               modelo_estudiante.setCarrera_estudiante(seleccion.getString(3));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_estudiante;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    public void actualizar_estudiante(Modelo_estudiante modelo_estudiante, String columna, String valor){

        int numeroFilas=0;
        
        String sql_guardar;
        
        sql_guardar="UPDATE estudiante \n" +
                "SET " + columna + " = '" + valor + "' \n" +
                "WHERE codigo_usuario_estudiante = '" + modelo_estudiante.getCodigo_usuario_estudiante()+"' ;";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Actualizacion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
    }   
    
    
    public void eliminar_estudiante(String codigo_usuario_estudiante  ) {
        String sql_eliminar = "DELETE FROM  estudiante  WHERE codigo_usuario_estudiante = '" + codigo_usuario_estudiante  + "'";

        try {
            Statement sentencia = this.conexion.createStatement();
            int numeroFilas = sentencia.executeUpdate(sql_eliminar);

            if (numeroFilas > 0) {
                System.out.println("Se eliminó el registro correctamente");
            } else {
                System.out.println("No se encontró el registro  del estudiante especificado");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar el estudiante");
            System.out.println(e);
        } 
    }
    
}
