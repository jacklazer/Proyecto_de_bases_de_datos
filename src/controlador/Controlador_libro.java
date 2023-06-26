/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_libro;
import accesoDatos.DAO_libro;

/**
 *
 * @author juanc
 */
public class Controlador_libro {
            
    DAO_libro dao_libro;
    
    public Controlador_libro(){
        dao_libro = new DAO_libro();           
    }
    
    public void agregar_libro(String isbn_libro, String titulo_libro, String anyo_de_publicacion_libro, String idioma_libro, String numero_de_paginas_libro, String codigo_area_de_conocimiento_libro, String codigo_editorial_libro){
        Modelo_libro modelo_libro = new Modelo_libro();        

        modelo_libro.setIsbn_libro(isbn_libro);
        modelo_libro.setTitulo_libro(titulo_libro);
        modelo_libro.setAnyo_de_publicacion_libro(anyo_de_publicacion_libro);
        modelo_libro.setIdioma_libro(idioma_libro);
        modelo_libro.setNumero_de_paginas_libro(numero_de_paginas_libro);
        modelo_libro.setCodigo_area_de_conocimiento_libro(codigo_area_de_conocimiento_libro);
        modelo_libro.setCodigo_editorial_libro(codigo_editorial_libro);
        
        dao_libro.insertar_libro(modelo_libro);
    }

    public Modelo_libro consultar_libro(String isbn_libro){
        
        Modelo_libro modelo_libro = dao_libro.seleccionar_libro(isbn_libro);
      
        return modelo_libro;
    }
    
    public void modificar_libro(Modelo_libro modelo_libro, String columna, String valor){
        
        dao_libro.actualizar_libro(modelo_libro, columna, valor);
      
    }
    
    public String consultar_libro_por_titulo(String isbn_libro){
        
        String libros = dao_libro.seleccionar_libros_por_titulo(isbn_libro);
      
        return libros;
    }
    
    public void eliminar_libro(String isbn_libro) {
        dao_libro.eliminar_libro(isbn_libro);
    }

}
