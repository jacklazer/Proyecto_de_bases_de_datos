/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package accesoDatos;

import modelo.Modelo_usuario;
import java.sql.*;

/**
 *
 * @author juanc
 */
public class DAO_usuario {
    
    FachadaBD fachada;
    Connection conexion;

    public DAO_usuario(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_usuario(Modelo_usuario modelo_usuario){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO usuario VALUES ('" +
                modelo_usuario.getCodigo_usuario()+ "', '" + 
                modelo_usuario.getNombre_usuario() + "', '" + 
                modelo_usuario.getDireccion_usuario()+ "', '" + 
                modelo_usuario.getTelefono_usuario()+ "', '" +
                modelo_usuario.getE_mail_usuario()+ "', '" +
                modelo_usuario.getContrasenya_usuario() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Modelo_usuario seleccionar_usuario(String codigo_usuario){

        Modelo_usuario modelo_usuario= new Modelo_usuario();
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_usuario, "
                + "nombre_usuario, "
                + "direccion_usuario, "
                + "telefono_usuario, "
                + "e_mail_usuario, "
                + "contrasenya_usuario "
                + "FROM usuario WHERE codigo_usuario = '" + codigo_usuario +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
                modelo_usuario.setCodigo_usuario(seleccion.getString(1));
                modelo_usuario.setNombre_usuario(seleccion.getString(2));
                modelo_usuario.setDireccion_usuario(seleccion.getString(3));
                modelo_usuario.setTelefono_usuario(seleccion.getString(4));
                modelo_usuario.setE_mail_usuario(seleccion.getString(5));
                modelo_usuario.setContrasenya_usuario(seleccion.getString(6));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_usuario;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    public void actualizar_usuario(Modelo_usuario modelo_usuario, String columna, String valor){

        int numeroFilas=0;
        
        String sql_guardar;
        
        sql_guardar="UPDATE usuario \n" +
                "SET " + columna + " = '" + valor + "' \n" +
                "WHERE codigo_usuario = '" + modelo_usuario.getCodigo_usuario() +"' ;";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Actualizacion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        
    }
    
    public void eliminar_usuario(String codigo_usuario) {
    String sql_eliminar = "DELETE FROM usuario WHERE codigo_usuario = '" + codigo_usuario + "'";

    try {
        Statement sentencia = this.conexion.createStatement();
        int numeroFilas = sentencia.executeUpdate(sql_eliminar);
        
        System.out.println("Eliminación exitosa");
    } catch (SQLException e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
    } catch (Exception e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
        }
    }

}
