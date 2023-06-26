/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author juanc
 */
public class Modelo_estudiante {
    
    private String codigo_usuario_estudiante;
    private String universidad_estudiante;
    private String carrera_estudiante;
    
    public String getCodigo_usuario_estudiante() {
        return codigo_usuario_estudiante;
    }

    public String getUniversidad_estudiante() {
        return universidad_estudiante;
    }

    public String getCarrera_estudiante() {
        return carrera_estudiante;
    }

    public void setCodigo_usuario_estudiante(String codigo_usuario_estudiante) {
        this.codigo_usuario_estudiante = codigo_usuario_estudiante;
    }

    public void setUniversidad_estudiante(String universidad_estudiante) {
        this.universidad_estudiante = universidad_estudiante;
    }

    public void setCarrera_estudiante(String carrera_estudiante) {
        this.carrera_estudiante = carrera_estudiante;
    }
}
