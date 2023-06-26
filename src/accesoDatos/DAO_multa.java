/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package accesoDatos;

import modelo.Modelo_multa;
import java.sql.*;

/**
 *
 * @author juanc
 */
public class DAO_multa {
    
    FachadaBD fachada;
    Connection conexion;

    public DAO_multa(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_multa(Modelo_multa modelo_multa){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO multa VALUES ('" +
                modelo_multa.getCodigo_multa()+ "', '" + 
                modelo_multa.getFecha_multa() + "', '" + 
                modelo_multa.getValor_multa()+ "', '" + 
                modelo_multa.getDescripcion_multa()+ "', '" + 
                modelo_multa.getCodigo_usuario_multa() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
 
    public Modelo_multa seleccionar_multa(String codigo_multa){

        Modelo_multa modelo_multa= new Modelo_multa();
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_multa, "
                + "fecha_multa, "
                + "valor_multa, "
                + "descripcion_multa, "
                + "codigo_usuario_multa "
                + "FROM multa WHERE codigo_multa = '" + codigo_multa +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_multa.setCodigo_multa(seleccion.getString(1));
               modelo_multa.setFecha_multa(seleccion.getString(2));
               modelo_multa.setValor_multa(seleccion.getString(3));
               modelo_multa.setDescripcion_multa(seleccion.getString(4));
               modelo_multa.setCodigo_usuario_multa(seleccion.getString(5));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_multa;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    public void actualizar_multa(Modelo_multa modelo_multa, String columna, String valor){

        int numeroFilas=0;
        
        String sql_guardar;
        
        sql_guardar="UPDATE multa \n" +
                "SET " + columna + " = '" + valor + "' \n" +
                "WHERE codigo_multa = '" + modelo_multa.getCodigo_multa()+"' ;";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Actualizacion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
    } 
    
    public void eliminar_multa(String codigo_multa) {
    String sql_eliminar = "DELETE FROM multa WHERE codigo_multa = '" + codigo_multa + "'";

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
    
        public String seleccionar_multas_de_usuario(String codigo_usuario_multa){
        
        String lista_de_multas = "";
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_multa "
                + "FROM multa WHERE codigo_usuario_multa = '" + codigo_usuario_multa +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               lista_de_multas = lista_de_multas + "- " + seleccion.getString(1) + "\n";
            }
            
            System.out.println("Seleccion exitosa");
           
            return lista_de_multas/*modelo_libros_y_autores*/;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }    

}
