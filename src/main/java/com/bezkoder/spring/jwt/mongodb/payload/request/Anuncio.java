package com.bezkoder.spring.jwt.mongodb.payload.request;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="anuncio")

public class Anuncio {
    @Id
    private int id;
    private String contenido;
    private String fecha;

    public Anuncio() {
    }

    public Anuncio(int id, String contenido) {
        this.id = id;
        this.contenido = contenido;
        //Asignamos fecha de creación del anuncio con la fecha del sistema en ese momento
        Date systemDate= new Date();
        this.fecha = systemDate.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

   /* public void setFecha(String fecha) {
        this.fecha = fecha;
    }*/
}
