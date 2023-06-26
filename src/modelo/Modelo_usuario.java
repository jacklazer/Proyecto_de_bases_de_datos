/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author juanc
 */
public class Modelo_usuario {
    
    private String codigo_usuario;
    private String nombre_usuario;
    private String direccion_usuario;
    private String telefono_usuario;
    private String e_mail_usuario;
    private String contrasenya_usuario;

    public String getCodigo_usuario() {
        return codigo_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getDireccion_usuario() {
        return direccion_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public String getE_mail_usuario() {
        return e_mail_usuario;
    }

    public String getContrasenya_usuario() {
        return contrasenya_usuario;
    }

    public void setCodigo_usuario(String codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public void setE_mail_usuario(String e_mail_usuario) {
        this.e_mail_usuario = e_mail_usuario;
    }
            
    public void setContrasenya_usuario(String contrasenya_usuario) {
        this.contrasenya_usuario = contrasenya_usuario;
    }
    
}
