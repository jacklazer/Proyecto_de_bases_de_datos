/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package accesoDatos;

import modelo.Modelo_profesor;
import java.sql.*;

/**
 *
 * @author juanc
 */
public class DAO_profesor {
    
    FachadaBD fachada;
    Connection conexion;

    public DAO_profesor(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_profesor(Modelo_profesor modelo_profesor){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO profesor VALUES ('" +
                modelo_profesor.getCodigo_usuario_profesor()+ "', '" + 
                modelo_profesor.getTitulo_profesor() + "', '" +
                modelo_profesor.getDependencia_profesor() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Modelo_profesor seleccionar_profesor(String codigo_usuario_profesor){

        Modelo_profesor modelo_profesor= new Modelo_profesor();
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_usuario_profesor, "
                + "titulo_profesor, "
                + "dependencia_profesor "
                + "FROM profesor WHERE codigo_usuario_profesor = '" + codigo_usuario_profesor +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_profesor.setCodigo_usuario_profesor(seleccion.getString(1));
               modelo_profesor.setTitulo_profesor(seleccion.getString(2));
               modelo_profesor.setDependencia_profesor(seleccion.getString(3));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_profesor;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    public void actualizar_profesor(Modelo_profesor modelo_profesor, String columna, String valor){

        int numeroFilas=0;
        
        String sql_guardar;
        
        sql_guardar="UPDATE profesor \n" +
                "SET " + columna + " = '" + valor + "' \n" +
                "WHERE codigo_usuario_profesor = '" + modelo_profesor.getCodigo_usuario_profesor()+"' ;";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Actualizacion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        
    }    

    public void eliminar_profesor(String codigo_usuario_profesor  ) {
        String sql_eliminar = " DELETE FROM profesor WHERE codigo_usuario_profesor = '" + codigo_usuario_profesor   + "'";

        try {
            Statement sentencia = this.conexion.createStatement();
            int numeroFilas = sentencia.executeUpdate(sql_eliminar);

            if (numeroFilas > 0) {
                System.out.println("Se eliminó el registro correctamente");
            } else {
                System.out.println("No se encontró el registro con el código de profesor especificado");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar profesor");
            System.out.println(e);
        } 
    }

    
}
