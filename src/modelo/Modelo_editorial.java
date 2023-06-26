/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author Franklin Aguirre
 */
public class Modelo_editorial {

    private String codigo_editorial ;
    private String nombre_editorial ;
    private String pagina_web_editorial ;
    private String pais_de_origen_editorial ;
    
    public String getCodigo_editorial() {
        return codigo_editorial;
    }

    public void setCodigo_editorial(String codigo_editorial) {
        this.codigo_editorial = codigo_editorial;
    }

    public String getNombre_editorial() {
        return nombre_editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        this.nombre_editorial = nombre_editorial;
    }

    public String getPagina_web_editorial() {
        return pagina_web_editorial;
    }

    public void setPagina_web_editorial(String pagina_web_editorial) {
        this.pagina_web_editorial = pagina_web_editorial;
    }

    public String getPais_de_origen_editorial() {
        return pais_de_origen_editorial;
    }

    public void setPais_de_origen_editorial(String pais_de_origen_editorial) {
        this.pais_de_origen_editorial = pais_de_origen_editorial;
    }
}
