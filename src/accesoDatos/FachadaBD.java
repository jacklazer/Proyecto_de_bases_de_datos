/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accesoDatos;
import java.sql.*;

/**
 *
 * @author ___
 */
public class FachadaBD {

        String url, usuario, password;
        Connection conexion =null;
        
        FachadaBD(){
            url="jdbc:postgresql://localhost:5432/Proyecto_BD";
            usuario="postgres";
            password="passwordPSQL1";
        }
        
        public Connection openConnection(){
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println( "Driver cargado" );
            } catch( ClassNotFoundException e ) {
                System.out.println( "No se pudo cargar el driver" );
            }

            try{
                conexion = DriverManager.getConnection(url, usuario, password);
                System.out.println( "Conexion exitosa con la base de datos" );
                return conexion;
             } catch( SQLException e ) {
                System.out.println( "No se pudo conectar la base de datos" );
                return null;
             }
        }

        public Connection getConnetion(){
            if (conexion == null) {
                return this.openConnection();
            }
            else{
                  return conexion;      
            }            
        }
        
        public void closeConection(Connection c){
            try{
                if (conexion != null){
                    c.close();
                }
                 
            } catch( SQLException e ) {
                System.out.println( "No se pudo cerrar" );
            }
        }
        
        /*
        public static void main(String a[]){
            FachadaBD fachada = new FachadaBD();
            Connection c = fachada.openConnection();
           fachada.closeConection(c);
        }*/
        
        
}
