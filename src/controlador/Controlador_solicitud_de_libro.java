/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_solicitud_de_libro;
import accesoDatos.DAO_solicitud_de_libro;

/**
 *
 * @author juanc
 */
public class Controlador_solicitud_de_libro {
            
    DAO_solicitud_de_libro dao_solicitud_de_libro;
    
    public Controlador_solicitud_de_libro(){
        dao_solicitud_de_libro = new DAO_solicitud_de_libro();           
    }
    
    public void agregar_solicitud_de_libro(/*String numero_consecutivo_solicitud,*/ String isbn_libro_solicitud, String codigo_usuario_solicitud, String identificacion_empleado_solicitud, String fecha_solicitud, String descripcion){
        Modelo_solicitud_de_libro modelo_solicitud_de_libro = new Modelo_solicitud_de_libro();        

//        modelo_solicitud_de_libro.setNumero_consecutivo_solicitud(numero_consecutivo_solicitud);
        modelo_solicitud_de_libro.setIsbn_libro_solicitud(isbn_libro_solicitud);
        modelo_solicitud_de_libro.setCodigo_usuario_solicitud(codigo_usuario_solicitud);
        modelo_solicitud_de_libro.setIdentificacion_empleado_solicitud(identificacion_empleado_solicitud);
        modelo_solicitud_de_libro.setFecha_solicitud(fecha_solicitud);
        modelo_solicitud_de_libro.setDescripcion(descripcion);
        
        dao_solicitud_de_libro.insertar_solicitud_de_libro(modelo_solicitud_de_libro);
    }

    public Modelo_solicitud_de_libro consultar_solicitud_de_libro(String numero_consecutivo_solicitud){
        
        Modelo_solicitud_de_libro modelo_solicitud_de_libro = dao_solicitud_de_libro.seleccionar_solicitud_de_libro(numero_consecutivo_solicitud);
      
        return modelo_solicitud_de_libro;
    }

    public void modificar_solicitud_de_libro(Modelo_solicitud_de_libro modelo_solicitud_de_libro, String columna, String valor){
        
        dao_solicitud_de_libro.actualizar_solicitud_de_libro(modelo_solicitud_de_libro, columna, valor);
      
    }
    
    public void eliminar_solicitud_de_libro(String numero_consecutivo_solicitud) {
        dao_solicitud_de_libro.eliminar_solicitud_de_libro(numero_consecutivo_solicitud);
    }

    public String consultar_solicitudes_de_usuario(String codigo_usuario){
        String lista_de_solicitudes = dao_solicitud_de_libro.seleccionar_solicitudes_de_usuario(codigo_usuario); 
        return lista_de_solicitudes; 
    }
    
}
