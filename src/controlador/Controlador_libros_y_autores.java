/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_libros_y_autores;
import accesoDatos.DAO_libros_y_autores;

/**
 *
 * @author juanc
 */
public class Controlador_libros_y_autores {
            
    DAO_libros_y_autores dao_libros_y_autores;
    
    public Controlador_libros_y_autores(){
        dao_libros_y_autores = new DAO_libros_y_autores();           
    }
    
    public void agregar_libros_a_autor(String codigo_autor_lya, String lista_de_libros){
        Modelo_libros_y_autores modelo_libros_y_autores = new Modelo_libros_y_autores();
        
//        String lista_de_libros = "- Hola \n - Mundo \n - Ejemplo \n - ZD \n - FF";
        int inicio = lista_de_libros.indexOf("- ") + 2;
        int fin = lista_de_libros.indexOf("\n", inicio);

        while (inicio != -1 && fin != -1) {
            String isbn_libro_lya = lista_de_libros.substring(inicio, fin);
            
            modelo_libros_y_autores.setCodigo_autor_lya(codigo_autor_lya);
            modelo_libros_y_autores.setIsbn_libro_lya(isbn_libro_lya);
        
            dao_libros_y_autores.insertar_libros_y_autores(modelo_libros_y_autores);

            inicio = lista_de_libros.indexOf("- ", fin) + 2;
            fin = lista_de_libros.indexOf("\n", inicio);
        }
        if (inicio != -1) {
            String isbn_libro_lya = lista_de_libros.substring(inicio);
            
            modelo_libros_y_autores.setCodigo_autor_lya(codigo_autor_lya);
            modelo_libros_y_autores.setIsbn_libro_lya(isbn_libro_lya);
            
            dao_libros_y_autores.insertar_libros_y_autores(modelo_libros_y_autores);
        }
    }
    
    public void agregar_autores_a_libro(String isbn_libro_lya, String lista_de_autores){
        Modelo_libros_y_autores modelo_libros_y_autores = new Modelo_libros_y_autores();
        
//        String lista_de_libros = "- Hola \n - Mundo \n - Ejemplo \n - ZD \n - FF";
        int inicio = lista_de_autores.indexOf("- ") + 2;
        int fin = lista_de_autores.indexOf("\n", inicio);

        while (inicio != -1 && fin != -1) {
            String codigo_autor_lya = lista_de_autores.substring(inicio, fin);
            
            modelo_libros_y_autores.setIsbn_libro_lya(isbn_libro_lya);
            modelo_libros_y_autores.setCodigo_autor_lya(codigo_autor_lya);

            dao_libros_y_autores.insertar_libros_y_autores(modelo_libros_y_autores);

            inicio = lista_de_autores.indexOf("- ", fin) + 2;
            fin = lista_de_autores.indexOf("\n", inicio);
        }
        if (inicio != -1) {
            String codigo_autor_lya = lista_de_autores.substring(inicio);
            
            modelo_libros_y_autores.setIsbn_libro_lya(isbn_libro_lya);
            modelo_libros_y_autores.setCodigo_autor_lya(codigo_autor_lya);
            
            dao_libros_y_autores.insertar_libros_y_autores(modelo_libros_y_autores);
        }
    }
    

    public String/*Modelo_libros_y_autores*/ consultar_libros_de_autor(String codigo_autor_lya){
        String lista_de_libros = dao_libros_y_autores.seleccionar_libros_de_autor(codigo_autor_lya); //        Modelo_libros_y_autores modelo_libros_y_autores = dao_libros_y_autores.seleccionar_libros_de_autor(codigo_autor_lya);
        return lista_de_libros; //        return modelo_libros_y_autores;
    }
    
    public String/*Modelo_libros_y_autores*/ consultar_autores_de_libro(String isbn_libro_lya){
        String lista_de_autores = dao_libros_y_autores.seleccionar_autores_de_libro(isbn_libro_lya); //        Modelo_libros_y_autores modelo_libros_y_autores = dao_libros_y_autores.seleccionar_autores_de_libro(isbn_libro_lya);
        return lista_de_autores; //        return modelo_libros_y_autores;
    }
    
    
    public void eliminar_libros_y_autores_l(String codigo_usuario_profesor_pya) {
        dao_libros_y_autores.eliminar_libros_y_autores_l(codigo_usuario_profesor_pya);
    }
    
    public void eliminar_libros_y_autores_a(String codigo_area_de_interes_pya) {
        dao_libros_y_autores.eliminar_libros_y_autores_a(codigo_area_de_interes_pya);
    }
    
    public void agregar_autor_a_libro(String isbn_libro, String codigo_autor_lya){
        
        dao_libros_y_autores.insertar_libro_a_autor(isbn_libro, codigo_autor_lya);
    }
}
