/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author juanc
 */
public class Modelo_prestamo_de_libro {
        
    private String numero_consecutivo_prestamo;
    private String codigo_usuario_prestamo;
    private String identificacion_empleado_prestamo;
    private String isbn_libro_ejemplar_prestamo;
    private String numero_ejemplar_prestamo;
    private String fecha_de_realizacion_prestamo;
    private String descripcion_prestamo;
    private String fecha_de_devolucion_prestamo;
    
    public String getNumero_consecutivo_prestamo() {
        return numero_consecutivo_prestamo;
    }

    public String getCodigo_usuario_prestamo() {
        return codigo_usuario_prestamo;
    }

    public String getIdentificacion_empleado_prestamo() {
        return identificacion_empleado_prestamo;
    }

    public String getIsbn_libro_ejemplar_prestamo() {
        return isbn_libro_ejemplar_prestamo;
    }

    public String getNumero_ejemplar_prestamo() {
        return numero_ejemplar_prestamo;
    }

    public String getFecha_de_realizacion_prestamo() {
        return fecha_de_realizacion_prestamo;
    }

    public String getDescripcion_prestamo() {
        return descripcion_prestamo;
    }

    public String getFecha_de_devolucion_prestamo() {
        return fecha_de_devolucion_prestamo;
    }

    public void setNumero_consecutivo_prestamo(String numero_consecutivo_prestamo) {
        this.numero_consecutivo_prestamo = numero_consecutivo_prestamo;
    }

    public void setCodigo_usuario_prestamo(String codigo_usuario_prestamo) {
        this.codigo_usuario_prestamo = codigo_usuario_prestamo;
    }

    public void setIdentificacion_empleado_prestamo(String identificacion_empleado_prestamo) {
        this.identificacion_empleado_prestamo = identificacion_empleado_prestamo;
    }

    public void setIsbn_libro_ejemplar_prestamo(String isbn_libro_ejemplar_prestamo) {
        this.isbn_libro_ejemplar_prestamo = isbn_libro_ejemplar_prestamo;
    }

    public void setNumero_ejemplar_prestamo(String numero_ejemplar_prestamo) {
        this.numero_ejemplar_prestamo = numero_ejemplar_prestamo;
    }

    public void setFecha_de_realizacion_prestamo(String fecha_de_realizacion_prestamo) {
        this.fecha_de_realizacion_prestamo = fecha_de_realizacion_prestamo;
    }

    public void setDescripcion_prestamo(String descripcion_prestamo) {
        this.descripcion_prestamo = descripcion_prestamo;
    }

    public void setFecha_de_devolucion_prestamo(String fecha_de_devolucion_prestamo) {
        this.fecha_de_devolucion_prestamo = fecha_de_devolucion_prestamo;
    }
    
}
