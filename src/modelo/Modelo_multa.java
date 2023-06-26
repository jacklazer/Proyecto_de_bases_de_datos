/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author juanc
 */
public class Modelo_multa {
        
    private String codigo_multa;
    private String fecha_multa;
    private String valor_multa;
    private String descripcion_multa;
    private String codigo_usuario_multa;
    
    public String getCodigo_multa() {
        return codigo_multa;
    }

    public String getFecha_multa() {
        return fecha_multa;
    }

    public String getValor_multa() {
        return valor_multa;
    }

    public String getDescripcion_multa() {
        return descripcion_multa;
    }

    public String getCodigo_usuario_multa() {
        return codigo_usuario_multa;
    }

    public void setCodigo_multa(String codigo_multa) {
        this.codigo_multa = codigo_multa;
    }

    public void setFecha_multa(String fecha_multa) {
        this.fecha_multa = fecha_multa;
    }

    public void setValor_multa(String valor_multa) {
        this.valor_multa = valor_multa;
    }

    public void setDescripcion_multa(String descripcion_multa) {
        this.descripcion_multa = descripcion_multa;
    }

    public void setCodigo_usuario_multa(String codigo_usuario_multa) {
        this.codigo_usuario_multa = codigo_usuario_multa;
    }
}
