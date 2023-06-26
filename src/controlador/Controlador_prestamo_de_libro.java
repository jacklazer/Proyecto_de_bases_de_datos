/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_prestamo_de_libro;
import accesoDatos.DAO_prestamo_de_libro;

/**
 *
 * @author juanc
 */
public class Controlador_prestamo_de_libro {
            
    DAO_prestamo_de_libro dao_prestamo_de_libro;
    
    public Controlador_prestamo_de_libro(){
        dao_prestamo_de_libro = new DAO_prestamo_de_libro();           
    }
    
    public void agregar_prestamo_de_libro(/*String numero_consecutivo_prestamo,*/ String codigo_usuario_prestamo, String identificacion_empleado_prestamo, String isbn_libro_ejemplar_prestamo, String numero_ejemplar_prestamo, String fecha_de_realizacion_prestamo, String descripcion_prestamo, String fecha_de_devolucion_prestamo){
        Modelo_prestamo_de_libro modelo_prestamo_de_libro = new Modelo_prestamo_de_libro();        

//        modelo_prestamo_de_libro.setNumero_consecutivo_prestamo(numero_consecutivo_prestamo);
        modelo_prestamo_de_libro.setCodigo_usuario_prestamo(codigo_usuario_prestamo);
        modelo_prestamo_de_libro.setIdentificacion_empleado_prestamo(identificacion_empleado_prestamo);
        modelo_prestamo_de_libro.setIsbn_libro_ejemplar_prestamo(isbn_libro_ejemplar_prestamo);
        modelo_prestamo_de_libro.setNumero_ejemplar_prestamo(numero_ejemplar_prestamo);
        modelo_prestamo_de_libro.setFecha_de_realizacion_prestamo(fecha_de_realizacion_prestamo);
        modelo_prestamo_de_libro.setDescripcion_prestamo(descripcion_prestamo);
        modelo_prestamo_de_libro.setFecha_de_devolucion_prestamo(fecha_de_devolucion_prestamo);
        
        dao_prestamo_de_libro.insertar_prestamo_de_libro(modelo_prestamo_de_libro);
    }

    public Modelo_prestamo_de_libro consultar_prestamo_de_libro(String numero_consecutivo_prestamo){
        
        Modelo_prestamo_de_libro modelo_prestamo_de_libro = dao_prestamo_de_libro.seleccionar_prestamo_de_libro(numero_consecutivo_prestamo);
      
        return modelo_prestamo_de_libro;
    }

    public void modificar_prestamo_de_libro(Modelo_prestamo_de_libro modelo_prestamo_de_libro, String columna, String valor){
        
        dao_prestamo_de_libro.actualizar_prestamo_de_libro(modelo_prestamo_de_libro, columna, valor);
      
    }
    
    public void eliminar_prestamo_de_libro(String numero_consecutivo_prestamo) {
        dao_prestamo_de_libro.eliminar_prestamo_de_libro(numero_consecutivo_prestamo);
    }

    public String consultar_prestamos_de_usuario(String codigo_usuario){
        String lista_de_prestamos = dao_prestamo_de_libro.seleccionar_prestamos_de_usuario(codigo_usuario);
        return lista_de_prestamos;
    }    
}
