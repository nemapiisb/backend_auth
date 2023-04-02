package com.bezkoder.spring.jwt.mongodb.models;

import java.util.Date;

public class AnuncioDto {
    private String contenido;
    private String fecha;

    private EAnuncioCategoria categoria;

    public AnuncioDto() {
    }

    public AnuncioDto(String contenido, EAnuncioCategoria categoria) {
        this.contenido = contenido;
        //Asignamos fecha sistema como fecha de creación del anuncio
        Date systemDate= new Date();
        this.fecha = systemDate.toString();
        //Asignamos tipo anuncio
        this.categoria=categoria;
    }

    public AnuncioDto(String contenido) {
        this.contenido = contenido;
        //Asignamos fecha sistema como fecha de creación del anuncio
        Date systemDate= new Date();
        this.fecha = systemDate.toString();
        //Asignamos tipo anuncio
    }


    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public EAnuncioCategoria getCategoria(){return categoria; }

    public void setCategoria(EAnuncioCategoria categoria){ this.categoria=categoria; }
    /*public void setFecha(String fecha) {
        this.fecha = fecha;
    }*/
}
