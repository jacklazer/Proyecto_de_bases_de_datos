/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author juanc
 */
public class Modelo_descarga_de_libro {

    private String ip_descarga;
    private String codigo_usuario_descarga;
    private String isbn_libro_digital_descarga;
    private String fecha_descarga;
    private String hora_deacarga;
    
    public String getIp_descarga() {
        return ip_descarga;
    }

    public String getCodigo_usuario_descarga() {
        return codigo_usuario_descarga;
    }

    public String getIsbn_libro_digital_descarga() {
        return isbn_libro_digital_descarga;
    }

    public String getFecha_descarga() {
        return fecha_descarga;
    }

    public String getHora_deacarga() {
        return hora_deacarga;
    }

    public void setIp_descarga(String ip_descarga) {
        this.ip_descarga = ip_descarga;
    }

    public void setCodigo_usuario_descarga(String codigo_usuario_descarga) {
        this.codigo_usuario_descarga = codigo_usuario_descarga;
    }

    public void setIsbn_libro_digital_descarga(String isbn_libro_digital_descarga) {
        this.isbn_libro_digital_descarga = isbn_libro_digital_descarga;
    }

    public void setFecha_descarga(String fecha_descarga) {
        this.fecha_descarga = fecha_descarga;
    }

    public void setHora_deacarga(String hora_deacarga) {
        this.hora_deacarga = hora_deacarga;
    }

}
