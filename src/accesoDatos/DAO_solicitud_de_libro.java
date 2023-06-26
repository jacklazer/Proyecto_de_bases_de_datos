/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package accesoDatos;

import modelo.Modelo_solicitud_de_libro;
import java.sql.*;

/**
 *
 * @author juanc
 */
public class DAO_solicitud_de_libro {
    
    FachadaBD fachada;
    Connection conexion;

    public DAO_solicitud_de_libro(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_solicitud_de_libro(Modelo_solicitud_de_libro modelo_solicitud_de_libro){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO solicitud_de_libro (isbn_libro_solicitud, codigo_usuario_solicitud, identificacion_empleado_solicitud, fecha_solicitud, descripcion) VALUES ('" +
//                modelo_solicitud_de_libro.getNumero_consecutivo_solicitud()+ "', '" + 
                modelo_solicitud_de_libro.getIsbn_libro_solicitud() + "', '" + 
                modelo_solicitud_de_libro.getCodigo_usuario_solicitud()+ "', '" + 
                modelo_solicitud_de_libro.getIdentificacion_empleado_solicitud()+ "', '" + 
                modelo_solicitud_de_libro.getFecha_solicitud()+ "', '" + 
                modelo_solicitud_de_libro.getDescripcion() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Modelo_solicitud_de_libro seleccionar_solicitud_de_libro(String numero_consecutivo_solicitud){

        Modelo_solicitud_de_libro modelo_libro= new Modelo_solicitud_de_libro();
        
        String sql_select;
        sql_select="SELECT "
                + "numero_consecutivo_solicitud, "
                + "isbn_libro_solicitud, "
                + "codigo_usuario_solicitud, "
                + "identificacion_empleado_solicitud, "
                + "fecha_solicitud, "
                + "descripcion "
                + "FROM solicitud_de_libro WHERE numero_consecutivo_solicitud = '" + numero_consecutivo_solicitud +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_libro.setNumero_consecutivo_solicitud(seleccion.getString(1));
               modelo_libro.setIsbn_libro_solicitud(seleccion.getString(2));
               modelo_libro.setCodigo_usuario_solicitud(seleccion.getString(3));
               modelo_libro.setIdentificacion_empleado_solicitud(seleccion.getString(4));
               modelo_libro.setFecha_solicitud(seleccion.getString(5));
               modelo_libro.setDescripcion(seleccion.getString(6));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_libro;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    public void actualizar_solicitud_de_libro(Modelo_solicitud_de_libro modelo_solicitud_de_libro, String columna, String valor){

        int numeroFilas=0;
        
        String sql_guardar;
        
        sql_guardar="UPDATE solicitud_de_libro \n" +
                "SET " + columna + " = '" + valor + "' \n" +
                "WHERE numero_consecutivo_solicitud = '" + modelo_solicitud_de_libro.getNumero_consecutivo_solicitud() +"' ;";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Actualizacion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        
    }
    
    public void eliminar_solicitud_de_libro(String numero_consecutivo_solicitud) {
    String sql_eliminar = "DELETE FROM solicitud_de_libro WHERE numero_consecutivo_solicitud = '" + numero_consecutivo_solicitud + "'";

    try {
        Statement sentencia = this.conexion.createStatement();
        int numeroFilas = sentencia.executeUpdate(sql_eliminar);

        if (numeroFilas > 0) {
            System.out.println("Eliminación exitosa");
        } else {
            System.out.println("No se encontró ningún registro para eliminar");
        }
    } catch (SQLException e) {
        System.out.println("Error al intentar eliminar el registro");
        System.out.println(e);
        }
    }

    public String seleccionar_solicitudes_de_usuario(String codigo_usuario_solicitud){
        
        String lista_de_solicitudes = "";
        
        String sql_select;
        sql_select="SELECT "
                + "numero_consecutivo_solicitud "
                + "FROM solicitud_de_libro WHERE codigo_usuario_solicitud = '" + codigo_usuario_solicitud +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               lista_de_solicitudes = lista_de_solicitudes + "- " + seleccion.getString(1) + "\n";
            }
            
            System.out.println("Seleccion exitosa");
           
            return lista_de_solicitudes/*modelo_libros_y_autores*/;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }    
    
}
