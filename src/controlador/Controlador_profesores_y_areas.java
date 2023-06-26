/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_profesores_y_areas;
import accesoDatos.DAO_profesores_y_areas;

/**
 *
 * @author juanc
 */
public class Controlador_profesores_y_areas {
            
    DAO_profesores_y_areas dao_profesores_y_areas;
    
    public Controlador_profesores_y_areas(){
        dao_profesores_y_areas = new DAO_profesores_y_areas();           
    }
    
    public void agregar_profesores_a_area(String codigo_area_de_interes_pya, String lista_de_profesores){
        Modelo_profesores_y_areas modelo_profesores_y_areas = new Modelo_profesores_y_areas();
        
//        String lista_de_libros = "- Hola \n - Mundo \n - Ejemplo \n - ZD \n - FF";
        int inicio = lista_de_profesores.indexOf("- ") + 2;
        int fin = lista_de_profesores.indexOf("\n", inicio);

        while (inicio != -1 && fin != -1) {
            String codigo_usuario_profesor_pya = lista_de_profesores.substring(inicio, fin);
            
            modelo_profesores_y_areas.setCodigo_area_de_interes_pya(codigo_area_de_interes_pya);
            modelo_profesores_y_areas.setCodigo_usuario_profesor_pya(codigo_usuario_profesor_pya);
        
            dao_profesores_y_areas.insertar_profesores_y_areas(modelo_profesores_y_areas);

            inicio = lista_de_profesores.indexOf("- ", fin) + 2;
            fin = lista_de_profesores.indexOf("\n", inicio);
        }
        if (inicio != -1) {
            String codigo_usuario_profesor_pya = lista_de_profesores.substring(inicio);
            
            modelo_profesores_y_areas.setCodigo_area_de_interes_pya(codigo_area_de_interes_pya);
            modelo_profesores_y_areas.setCodigo_usuario_profesor_pya(codigo_usuario_profesor_pya);
            
            dao_profesores_y_areas.insertar_profesores_y_areas(modelo_profesores_y_areas);
        }
    }
    
    public void agregar_areas_a_profesor(String codigo_usuario_profesor_pya, String lista_de_areas){
        Modelo_profesores_y_areas modelo_libros_y_autores = new Modelo_profesores_y_areas();
        
//        String lista_de_libros = "- Hola \n - Mundo \n - Ejemplo \n - ZD \n - FF";
        int inicio = lista_de_areas.indexOf("- ") + 2;
        int fin = lista_de_areas.indexOf("\n", inicio);

        while (inicio != -1 && fin != -1) {
            String codigo_area_de_interes_pya = lista_de_areas.substring(inicio, fin);
            
            modelo_libros_y_autores.setCodigo_usuario_profesor_pya(codigo_usuario_profesor_pya);
            modelo_libros_y_autores.setCodigo_area_de_interes_pya(codigo_area_de_interes_pya);

            dao_profesores_y_areas.insertar_profesores_y_areas(modelo_libros_y_autores);

            inicio = lista_de_areas.indexOf("- ", fin) + 2;
            fin = lista_de_areas.indexOf("\n", inicio);
        }
        if (inicio != -1) {
            String codigo_area_de_interes_pya = lista_de_areas.substring(inicio);
            
            modelo_libros_y_autores.setCodigo_usuario_profesor_pya(codigo_usuario_profesor_pya);
            modelo_libros_y_autores.setCodigo_area_de_interes_pya(codigo_area_de_interes_pya);
            
            dao_profesores_y_areas.insertar_profesores_y_areas(modelo_libros_y_autores);
        }
    }
    

    public String/*Modelo_libros_y_autores*/ consultar_profesores_de_area(String codigo_area_de_interes_pya){
        String lista_de_libros = dao_profesores_y_areas.seleccionar_profesores_de_area(codigo_area_de_interes_pya); //        Modelo_libros_y_autores modelo_libros_y_autores = dao_profesores_y_areas.seleccionar_libros_de_autor(codigo_autor_lya);
        return lista_de_libros; //        return modelo_libros_y_autores;
    }
    
    public String/*Modelo_libros_y_autores*/ consultar_areas_de_profesor(String codigo_usuario_profesor_pya){
        String lista_de_autores = dao_profesores_y_areas.seleccionar_areas_de_profesor(codigo_usuario_profesor_pya); //        Modelo_libros_y_autores modelo_libros_y_autores = dao_profesores_y_areas.seleccionar_autores_de_libro(isbn_libro_lya);
        return lista_de_autores; //        return modelo_libros_y_autores;
    }
    
    public void eliminar_profesores_y_areas_p(String codigo_usuario_profesor_pya) {
        dao_profesores_y_areas.eliminar_profesores_y_areas_p(codigo_usuario_profesor_pya);
    }
    
    public void eliminar_profesores_y_areas_a(String codigo_area_de_interes_pya) {
        dao_profesores_y_areas.eliminar_profesores_y_areas_a(codigo_area_de_interes_pya);
    }
}
