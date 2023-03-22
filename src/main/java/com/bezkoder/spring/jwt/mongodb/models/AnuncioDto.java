package com.bezkoder.spring.jwt.mongodb.models;

import java.util.Date;

public class AnuncioDto {
    private String contenido;
    private String fecha;

    public AnuncioDto() {
    }

    public AnuncioDto(String contenido) {
        this.contenido = contenido;
        //Asignamos fecha sistema como fecha de creación del anuncio
        Date systemDate= new Date();
        this.fecha = systemDate.toString();
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

    /*public void setFecha(String fecha) {
        this.fecha = fecha;
    }*/
}
