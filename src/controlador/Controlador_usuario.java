/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Modelo_usuario;
import accesoDatos.DAO_usuario;

/**
 *
 * @author juanc
 */
public class Controlador_usuario {
            
    DAO_usuario dao_usuario;
    
    public Controlador_usuario(){
        dao_usuario = new DAO_usuario();           
    }
    
    public void agregar_usuario(String codigo_usuario, String nombre_usuario, String direccion_usuario, String telefono_usuario, String e_mail_usuario, String contrasenya_usuario){
        Modelo_usuario modelo_usuario = new Modelo_usuario();        

        modelo_usuario.setCodigo_usuario(codigo_usuario);
        modelo_usuario.setNombre_usuario(nombre_usuario);
        modelo_usuario.setDireccion_usuario(direccion_usuario);
        modelo_usuario.setTelefono_usuario(telefono_usuario);
        modelo_usuario.setE_mail_usuario(e_mail_usuario);
        modelo_usuario.setContrasenya_usuario(contrasenya_usuario);
        
        dao_usuario.insertar_usuario(modelo_usuario);
    }

    public Modelo_usuario consultar_usuario(String codigo_usuario){
        
        Modelo_usuario modelo_usuario = dao_usuario.seleccionar_usuario(codigo_usuario);
      
        return modelo_usuario;
    }
    
    public void modificar_usuario(Modelo_usuario modelo_usuario, String columna, String valor){
        
        dao_usuario.actualizar_usuario(modelo_usuario, columna, valor);
      
    }
    
    public void eliminar_usuario(String codigo_usuario) {
        dao_usuario.eliminar_usuario(codigo_usuario);
    }

}
