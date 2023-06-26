
package controlador;
import modelo.Modelo_editorial;
import Vistas.Vista_editorial;
import accesoDatos.editorial_DAO;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Franklin Aguirre
 */
public class Controlador_editorial  {
        
    editorial_DAO editorial_DAO;
    
    public Controlador_editorial(){
        editorial_DAO = new editorial_DAO();           
    }
    
    public int insertar_editorial(String  codigo_editorial, String nombre_editorial, String pagina_web_editorial, String pais_de_origen_editorial){
        Modelo_editorial Modelo_editorial = new Modelo_editorial();        

        Modelo_editorial.setCodigo_editorial(codigo_editorial);
        Modelo_editorial.setNombre_editorial(nombre_editorial);
        Modelo_editorial.setPagina_web_editorial(pagina_web_editorial);
        Modelo_editorial.setPais_de_origen_editorial(pais_de_origen_editorial);
        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar una Editorial");
        
        int result = editorial_DAO.guardar_editorial(Modelo_editorial);
        
        System.out.println("Se  insertó  una  nueva Editorial");
        
        return result;
    }

    public Modelo_editorial consultar_editorial(String codigo_editorial){
        
        Modelo_editorial modelo_editorial = editorial_DAO.consultar_editorial(codigo_editorial);
      
        return modelo_editorial;
    }

    public void modificar_editorial(Modelo_editorial modelo_editorial, String columna, String valor){
        
        editorial_DAO.actualizar_editorial(modelo_editorial, columna, valor);
      
    }
    
    public void eliminar_editorial(String codigo_editorial) {
        editorial_DAO.eliminar_editorial(codigo_editorial);
    }

}
