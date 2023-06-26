/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package accesoDatos;

import modelo.Modelo_empleado;
import java.sql.*;

/**
 *
 * @author juanc
 */
public class DAO_empleado {
    
    FachadaBD fachada;
    Connection conexion;

    public DAO_empleado(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_empleado(Modelo_empleado modelo_empleado){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO empleado VALUES ('" +
                modelo_empleado.getIdentificacion_empleado()+ "', '" + 
                modelo_empleado.getNombre_empleado() + "', '" +
                modelo_empleado.getCargo_empleado() + "', '" + 
                modelo_empleado.getContrasenya_empleado() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Modelo_empleado seleccionar_empleado(String identificacion_empleado){

        Modelo_empleado modelo_empleado= new Modelo_empleado();
        
        String sql_select;
        sql_select="SELECT "
                + "identificacion_empleado, "
                + "nombre_empleado, "
                + "cargo_empleado, "
                + "contrasenya_empleado "
                + "FROM empleado WHERE identificacion_empleado = '" + identificacion_empleado +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_empleado.setIdentificacion_empleado(seleccion.getString(1));
               modelo_empleado.setNombre_empleado(seleccion.getString(2));
               modelo_empleado.setCargo_empleado(seleccion.getString(3));
               modelo_empleado.setContrasenya_empleado(seleccion.getString(4));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_empleado;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    public void actualizar_empleado(Modelo_empleado modelo_empleado, String columna, String valor){

        int numeroFilas=0;
        
        String sql_guardar;
        
        sql_guardar="UPDATE usuario \n" +
                "SET " + columna + " = '" + valor + "' \n" +
                "WHERE identificacion_empleado = '" + modelo_empleado.getIdentificacion_empleado()+"' ;";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Actualizacion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
    }  
    
    public void eliminar_empleado(String identificacion_empleado  ) {
        String sql_eliminar = "DELETE FROM  empleado  WHERE identificacion_empleado = '" +  identificacion_empleado  + "'";

        try {
            Statement sentencia = this.conexion.createStatement();
            int numeroFilas = sentencia.executeUpdate(sql_eliminar);

            if (numeroFilas > 0) {
                System.out.println("Se eliminó el registro correctamente");
            } else {
                System.out.println("No se encontró el registro  del empleado especificado");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar el empleado");
            System.out.println(e);
        } 
    }
}
