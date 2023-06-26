/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_libro_digital;
import accesoDatos.DAO_libro_digital;

/**
 *
 * @author juanc
 */
public class Controlador_libro_digital {
            
    DAO_libro_digital dao_libro_digital;
    
    public Controlador_libro_digital(){
        dao_libro_digital = new DAO_libro_digital();           
    }
    
    public void agregar_libro_digital(String isbn_libro_digital, String url_libro_digital, String formato_libro_digital, String tamanyo_libro_digital){
        Modelo_libro_digital modelo_libro_digital = new Modelo_libro_digital();

        modelo_libro_digital.setIsbn_libro_digital(isbn_libro_digital);
        modelo_libro_digital.setUrl_libro_digital(url_libro_digital);
        modelo_libro_digital.setFormato_libro_digital(formato_libro_digital);
        modelo_libro_digital.setTamanyo_libro_digital(tamanyo_libro_digital);
        
        dao_libro_digital.insertar_libro_digital(modelo_libro_digital);
    }

    public Modelo_libro_digital consultar_libro_digital(String isbn_libro_digital){
        
        Modelo_libro_digital modelo_libro_digital = dao_libro_digital.seleccionar_libro_digital(isbn_libro_digital);
      
        return modelo_libro_digital;
    }
    
    public void modificar_libro_digital(Modelo_libro_digital modelo_libro_digital, String columna, String valor){
        
        dao_libro_digital.actualizar_libro_digital(modelo_libro_digital, columna, valor);

    }
    
    public void eliminar_libro_digital(String isbn_libro_digital) {
        dao_libro_digital.eliminar_libro_digital(isbn_libro_digital);
    }
}
