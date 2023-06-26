/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_area_de_interes;
import accesoDatos.DAO_area_de_interes;

/**
 *
 * @author juanc
 */
public class Controlador_area_de_interes {
            
    DAO_area_de_interes dao_area_de_interes;
    
    public Controlador_area_de_interes(){
        dao_area_de_interes = new DAO_area_de_interes();           
    }
    
    public void agregar_area_de_interes(String codigo_area_de_interes, String nombre_area_de_interes){
        Modelo_area_de_interes modelo_area_de_interes = new Modelo_area_de_interes();        

        modelo_area_de_interes.setCodigo_area_de_interes(codigo_area_de_interes);
        modelo_area_de_interes.setNombre_area_de_interes(nombre_area_de_interes);
        
        dao_area_de_interes.insertar_area_de_interes(modelo_area_de_interes);
    }

    public Modelo_area_de_interes consultar_area_de_interes(String codigo_area_de_interes){
        
        Modelo_area_de_interes modelo_area_de_interes = dao_area_de_interes.seleccionar_area_de_interes(codigo_area_de_interes);
      
        return modelo_area_de_interes;
    }
    
    public void modificar_area_de_interes(Modelo_area_de_interes modelo_area_de_interes, String columna, String valor){
        
        dao_area_de_interes.actualizar_area_de_interes(modelo_area_de_interes, columna, valor);
      
    }
    
    public void eliminar_area_de_interes(String codigo_area_de_interes) {
        dao_area_de_interes.eliminar_area_de_interes(codigo_area_de_interes);
    
    }

}
