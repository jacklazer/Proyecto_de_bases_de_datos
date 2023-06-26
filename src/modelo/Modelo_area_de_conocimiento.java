/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author juanc
 */
public class Modelo_area_de_conocimiento {
    
    private String codigo_area_de_conocimiento ;
    private String nombre_area_de_conocimiento ;
    private String descripcion_area_de_conocimiento ;
    private String codigo_area_padre ;

    public String getCodigo_area_de_conocimiento() {
        return codigo_area_de_conocimiento;
    }

    public String getNombre_area_de_conocimiento() {
        return nombre_area_de_conocimiento;
    }

    public String getDescripcion_area_de_conocimiento() {
        return descripcion_area_de_conocimiento;
    }

    public String getCodigo_area_padre() {
        return codigo_area_padre;
    }

    public void setCodigo_area_de_conocimiento(String codigo_area_de_conocimiento) {
        this.codigo_area_de_conocimiento = codigo_area_de_conocimiento;
    }

    public void setNombre_area_de_conocimiento(String nombre_area_de_conocimiento) {
        this.nombre_area_de_conocimiento = nombre_area_de_conocimiento;
    }

    public void setDescripcion_area_de_conocimiento(String descripcion_area_de_conocimiento) {
        this.descripcion_area_de_conocimiento = descripcion_area_de_conocimiento;
    }

    public void setCodigo_area_padre(String codigo_area_padre) {
        this.codigo_area_padre = codigo_area_padre;
    }

}
