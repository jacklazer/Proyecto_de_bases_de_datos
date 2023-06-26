/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_area_de_conocimiento;
import accesoDatos.DAO_area_de_conocimiento;

/**
 *
 * @author juanc
 */
public class Controlador_area_de_conocimiento {
            
    DAO_area_de_conocimiento dao_area_de_conocimiento;
    
    public Controlador_area_de_conocimiento(){
        dao_area_de_conocimiento = new DAO_area_de_conocimiento();           
    }
    
    public void agregar_area_de_conocimiento(String  codigo_area_de_conocimiento, String nombre_area_de_conocimiento, String descripcion_area_de_conocimiento, String codigo_area_padre){
        Modelo_area_de_conocimiento modelo_area_de_conocimiento = new Modelo_area_de_conocimiento();        

        modelo_area_de_conocimiento.setCodigo_area_de_conocimiento(codigo_area_de_conocimiento);
        modelo_area_de_conocimiento.setNombre_area_de_conocimiento(nombre_area_de_conocimiento);
        modelo_area_de_conocimiento.setDescripcion_area_de_conocimiento(descripcion_area_de_conocimiento);
        modelo_area_de_conocimiento.setCodigo_area_padre(codigo_area_padre);
        
        dao_area_de_conocimiento.insertar_area_de_conocimiento(modelo_area_de_conocimiento);
    }

    public Modelo_area_de_conocimiento consultar_area_de_conocimiento(String codigo_area_de_conocimiento){
        
        Modelo_area_de_conocimiento modelo_area_de_conocimiento = dao_area_de_conocimiento.seleccionar_area_de_conocimiento(codigo_area_de_conocimiento);
      
        return modelo_area_de_conocimiento;
    }

    public void modificar_area_de_conocimiento(Modelo_area_de_conocimiento modelo_area_de_conocimiento, String columna, String valor){
        
        dao_area_de_conocimiento.actualizar_area_de_conocimiento(modelo_area_de_conocimiento, columna, valor);
      
    }
    
    public void eliminar_area_de_conocimiento(String codigo_area_de_conocimiento) {
        dao_area_de_conocimiento.eliminar_area_de_conocimiento(codigo_area_de_conocimiento);
    }

}
