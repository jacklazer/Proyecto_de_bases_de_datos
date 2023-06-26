/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_empleado;
import accesoDatos.DAO_empleado;

/**
 *
 * @author juanc
 */
public class Controlador_empleado {
            
    DAO_empleado dao_empleado;
    
    public Controlador_empleado(){
        dao_empleado = new DAO_empleado();           
    }
    
    public void agregar_empleado(String identificacion_empleado, String nombre_empleado, String cargo_empleado, String contrasenya_empleado){
        Modelo_empleado modelo_empleado = new Modelo_empleado();        

        modelo_empleado.setIdentificacion_empleado(identificacion_empleado);
        modelo_empleado.setNombre_empleado(nombre_empleado);
        modelo_empleado.setCargo_empleado(cargo_empleado);
        modelo_empleado.setContrasenya_empleado(contrasenya_empleado);
        
        dao_empleado.insertar_empleado(modelo_empleado);
    }

    public Modelo_empleado consultar_empleado(String identificacion_empleado){
        
        Modelo_empleado modelo_empleado = dao_empleado.seleccionar_empleado(identificacion_empleado);
      
        return modelo_empleado;
    }
    
    public void modificar_empleado(Modelo_empleado modelo_empleado, String columna, String valor){
        
        dao_empleado.actualizar_empleado(modelo_empleado, columna, valor);
      
    }
    
    public void eliminar_empleado(String identificacion_empleado) {
        dao_empleado.eliminar_empleado(identificacion_empleado);
    }
}
