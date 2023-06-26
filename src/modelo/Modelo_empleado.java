/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author juanc
 */
public class Modelo_empleado {    
            
    private String identificacion_empleado;
    private String nombre_empleado;
    private String cargo_empleado;
    private String contrasenya_empleado;

    public String getIdentificacion_empleado() {
        return identificacion_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public String getCargo_empleado() {
        return cargo_empleado;
    }

    public String getContrasenya_empleado() {
        return contrasenya_empleado;
    }

    public void setIdentificacion_empleado(String identificacion_empleado) {
        this.identificacion_empleado = identificacion_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public void setCargo_empleado(String cargo_empleado) {
        this.cargo_empleado = cargo_empleado;
    }
        
    public void setContrasenya_empleado(String contrasenya_empleado) {
        this.contrasenya_empleado = contrasenya_empleado;
    }

}
