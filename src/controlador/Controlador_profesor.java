/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_profesor;
import accesoDatos.DAO_profesor;

/**
 *
 * @author juanc
 */
public class Controlador_profesor {
            
    DAO_profesor dao_profesor;
    
    public Controlador_profesor(){
        dao_profesor = new DAO_profesor();           
    }
    
    public void agregar_profesor(String codigo_usuario_profesor, String titulo_profesor, String dependencia_profesor){
        Modelo_profesor modelo_profesor = new Modelo_profesor();   

        modelo_profesor.setCodigo_usuario_profesor(codigo_usuario_profesor);
        modelo_profesor.setTitulo_profesor(titulo_profesor);
        modelo_profesor.setDependencia_profesor(dependencia_profesor);
        
        dao_profesor.insertar_profesor(modelo_profesor);
    }

    public Modelo_profesor consultar_profesor(String codigo_usuario_profesor){
        
        Modelo_profesor modelo_profesor = dao_profesor.seleccionar_profesor(codigo_usuario_profesor);
      
        return modelo_profesor;
    }
    
    public void modificar_profesor(Modelo_profesor modelo_profesor, String columna, String valor){
        
        dao_profesor.actualizar_profesor(modelo_profesor, columna, valor);
      
    }
    
    public void eliminar_profesor(String codigo_usuario_profesor) {
        dao_profesor.eliminar_profesor(codigo_usuario_profesor);
    }
}
