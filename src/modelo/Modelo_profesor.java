/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author juanc
 */
public class Modelo_profesor {
    
    private String codigo_usuario_profesor;
    private String titulo_profesor;
    private String dependencia_profesor;

    public String getCodigo_usuario_profesor() {
        return codigo_usuario_profesor;
    }

    public String getTitulo_profesor() {
        return titulo_profesor;
    }

    public String getDependencia_profesor() {
        return dependencia_profesor;
    }

    public void setCodigo_usuario_profesor(String codigo_usuario_profesor) {
        this.codigo_usuario_profesor = codigo_usuario_profesor;
    }

    public void setTitulo_profesor(String titulo_profesor) {
        this.titulo_profesor = titulo_profesor;
    }

    public void setDependencia_profesor(String dependencia_profesor) {
        this.dependencia_profesor = dependencia_profesor;
    }
}
