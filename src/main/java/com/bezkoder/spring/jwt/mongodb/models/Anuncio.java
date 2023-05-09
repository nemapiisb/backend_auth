package com.bezkoder.spring.jwt.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="anuncio")

public class Anuncio {
    @Id
    private int id;
    private String contenido;
    private String fecha;

    private EAnuncioCategoria categoria;
    private String userId;
    public Anuncio() {
    }

    public Anuncio(int id, String contenido) {
        this.id = id;
        this.contenido = contenido;
        //Asignamos fecha de creación del anuncio con la fecha del sistema en ese momento
        Date systemDate= new Date();
        this.fecha = systemDate.toString();
    }
    public Anuncio(int id, String contenido,EAnuncioCategoria categoria) {
        this.id = id;
        this.contenido = contenido;
        //Asignamos fecha de creación del anuncio con la fecha del sistema en ese momento
        Date systemDate= new Date();
        this.fecha = systemDate.toString();
        this.categoria=categoria;
    }
    public Anuncio(int id, String contenido,EAnuncioCategoria categoria, String userId) {
        this.id = id;
        this.contenido = contenido;
        //Asignamos fecha de creación del anuncio con la fecha del sistema en ese momento
        Date systemDate= new Date();
        this.fecha = systemDate.toString();
        this.categoria=categoria;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setIdUser(String userId) {
        this.userId = userId;
    }
    public String getFecha() {
        return fecha;
    }

    public EAnuncioCategoria getCategoria(){return categoria; }

    public void setCategoria(EAnuncioCategoria categoria){ this.categoria=categoria; }

   /* public void setFecha(String fecha) {
        this.fecha = fecha;
    }*/
}
