/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_descarga_de_libro;
import accesoDatos.DAO_descarga_de_libro;

/**
 *
 * @author juanc
 */
public class Controlador_descarga_de_libro {
            
    DAO_descarga_de_libro dao_descarga_de_libro;
    
    public Controlador_descarga_de_libro(){
        dao_descarga_de_libro = new DAO_descarga_de_libro();           
    }
    
    public void agregar_descarga_de_libro(String ip_descarga, String codigo_usuario_descarga, String isbn_libro_digital_descarga, String fecha_descarga, String hora_deacarga){
        Modelo_descarga_de_libro modelo_descarga_de_libro = new Modelo_descarga_de_libro();        

        modelo_descarga_de_libro.setIp_descarga(ip_descarga);
        modelo_descarga_de_libro.setCodigo_usuario_descarga(codigo_usuario_descarga);
        modelo_descarga_de_libro.setIsbn_libro_digital_descarga(isbn_libro_digital_descarga);
        modelo_descarga_de_libro.setFecha_descarga(fecha_descarga);
        modelo_descarga_de_libro.setHora_deacarga(hora_deacarga);
        
        dao_descarga_de_libro.insertar_descarga_de_libro(modelo_descarga_de_libro);
    }

    public Modelo_descarga_de_libro consultar_descarga_de_libro(String ip_descarga){
        
        Modelo_descarga_de_libro modelo_libro = dao_descarga_de_libro.seleccionar_descarga_de_libro(ip_descarga);
      
        return modelo_libro;
    }
    
    public void eliminar_descarga(String ip_descarga) {
        dao_descarga_de_libro.eliminar_descarga_de_libro(ip_descarga);
    }
    
    public String consultar_descargas_de_usuario(String codigo_usuario){
        String lista_de_descargas = dao_descarga_de_libro.seleccionar_descargas_de_usuario(codigo_usuario); 
        return lista_de_descargas; 
    }
    
    public String lista_de_descargas() {
        return dao_descarga_de_libro.select_descarga_de_libros();
    }

}
