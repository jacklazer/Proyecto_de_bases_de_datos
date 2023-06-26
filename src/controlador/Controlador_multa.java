/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_multa;
import accesoDatos.DAO_multa;

/**
 *
 * @author juanc
 */
public class Controlador_multa {
            
    DAO_multa dao_multa;
    
    public Controlador_multa(){
        dao_multa = new DAO_multa();           
    }
    
    public void agregar_multa(String codigo_multa, String fecha_multa, String valor_multa, String descripcion_multa, String codigo_usuario_multa){
        Modelo_multa modelo_multa = new Modelo_multa();        

        modelo_multa.setCodigo_multa(codigo_multa);
        modelo_multa.setFecha_multa(fecha_multa);
        modelo_multa.setValor_multa(valor_multa);
        modelo_multa.setDescripcion_multa(descripcion_multa);
        modelo_multa.setCodigo_usuario_multa(codigo_usuario_multa);
        
        dao_multa.insertar_multa(modelo_multa);
    }

    public Modelo_multa consultar_multa(String codigo_multa){
        
        Modelo_multa modelo_multa = dao_multa.seleccionar_multa(codigo_multa);
      
        return modelo_multa;
    }

    public void modificar_multa(Modelo_multa modelo_multa, String columna, String valor){
        
        dao_multa.actualizar_multa(modelo_multa, columna, valor);
      
    }    
    
    public void eliminar_multa(String codigo_multa) {
        dao_multa.eliminar_multa(codigo_multa);
    }
    
    public String consultar_multas_de_usuario(String codigo_usuario_multa){
        String lista_de_solicitudes = dao_multa.seleccionar_multas_de_usuario(codigo_usuario_multa); 
        return lista_de_solicitudes; 
    }
}
