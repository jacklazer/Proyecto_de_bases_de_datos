/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author juanc
 */
public class Modelo_solicitud_de_libro {

    private String numero_consecutivo_solicitud;
    private String isbn_libro_solicitud;
    private String codigo_usuario_solicitud;
    private String identificacion_empleado_solicitud;
    private String fecha_solicitud;
    private String descripcion;
    
    public String getNumero_consecutivo_solicitud() {
        return numero_consecutivo_solicitud;
    }

    public String getIsbn_libro_solicitud() {
        return isbn_libro_solicitud;
    }

    public String getCodigo_usuario_solicitud() {
        return codigo_usuario_solicitud;
    }

    public String getIdentificacion_empleado_solicitud() {
        return identificacion_empleado_solicitud;
    }

    public String getFecha_solicitud() {
        return fecha_solicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNumero_consecutivo_solicitud(String numero_consecutivo_solicitud) {
        this.numero_consecutivo_solicitud = numero_consecutivo_solicitud;
    }

    public void setIsbn_libro_solicitud(String isbn_libro_solicitud) {
        this.isbn_libro_solicitud = isbn_libro_solicitud;
    }

    public void setCodigo_usuario_solicitud(String codigo_usuario_solicitud) {
        this.codigo_usuario_solicitud = codigo_usuario_solicitud;
    }

    public void setIdentificacion_empleado_solicitud(String identificacion_empleado_solicitud) {
        this.identificacion_empleado_solicitud = identificacion_empleado_solicitud;
    }

    public void setFecha_solicitud(String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
