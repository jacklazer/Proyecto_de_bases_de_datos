/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author juanc
 */
public class Modelo_libro {
        
    private String isbn_libro;
    private String titulo_libro;
    private String anyo_de_publicacion_libro;
    private String idioma_libro;
    private String numero_de_paginas_libro;
    private String codigo_area_de_conocimiento_libro;
    private String codigo_editorial_libro;

    public String getIsbn_libro() {
        return isbn_libro;
    }

    public String getTitulo_libro() {
        return titulo_libro;
    }

    public String getAnyo_de_publicacion_libro() {
        return anyo_de_publicacion_libro;
    }

    public String getIdioma_libro() {
        return idioma_libro;
    }

    public String getNumero_de_paginas_libro() {
        return numero_de_paginas_libro;
    }

    public String getCodigo_area_de_conocimiento_libro() {
        return codigo_area_de_conocimiento_libro;
    }

    public String getCodigo_editorial_libro() {
        return codigo_editorial_libro;
    }

    public void setIsbn_libro(String isbn_libro) {
        this.isbn_libro = isbn_libro;
    }

    public void setTitulo_libro(String titulo_libro) {
        this.titulo_libro = titulo_libro;
    }

    public void setAnyo_de_publicacion_libro(String anyo_de_publicacion_libro) {
        this.anyo_de_publicacion_libro = anyo_de_publicacion_libro;
    }

    public void setIdioma_libro(String idioma_libro) {
        this.idioma_libro = idioma_libro;
    }

    public void setNumero_de_paginas_libro(String numero_de_paginas_libro) {
        this.numero_de_paginas_libro = numero_de_paginas_libro;
    }

    public void setCodigo_area_de_conocimiento_libro(String codigo_area_de_conocimiento_libro) {
        this.codigo_area_de_conocimiento_libro = codigo_area_de_conocimiento_libro;
    }

    public void setCodigo_editorial_libro(String codigo_editorial_libro) {
        this.codigo_editorial_libro = codigo_editorial_libro;
    }

}
