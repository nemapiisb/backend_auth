package com.bezkoder.spring.jwt.mongodb.services;

import com.bezkoder.spring.jwt.mongodb.models.AnuncioDto;
import com.bezkoder.spring.jwt.mongodb.payload.request.Anuncio;
import com.bezkoder.spring.jwt.mongodb.exception.NullContenidoException;
import com.bezkoder.spring.jwt.mongodb.exception.ResourceNotFoundException;
import com.bezkoder.spring.jwt.mongodb.repository.AnuncioRepository;
import com.bezkoder.spring.jwt.mongodb.controllers.AnuncioController;
import com.bezkoder.spring.jwt.mongodb.models.AnuncioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AnuncioService {
    @Autowired
    AnuncioRepository anuncioRepository;


    //Listar Anuncios
    public List<Anuncio> getAll(){
        return anuncioRepository.findAll();
    }

    //Listar Anuncio
    public Anuncio getOne(int id) throws ResourceNotFoundException {
        return anuncioRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("El anuncio no existe"));
    }

    //Crear Anuncio

    public Anuncio save(AnuncioDto dto) throws NullContenidoException {
        if(dto.getContenido().isEmpty())
            throw new NullContenidoException("El contenido no puede estar vacio");
        int id=autoincrement();
        Anuncio anuncio= new Anuncio(id,dto.getContenido());
        return anuncioRepository.save(anuncio);
    }


    //Update anuncio

    public Anuncio update(int id, AnuncioDto dto) throws ResourceNotFoundException {
        Anuncio anuncio=anuncioRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("El anuncio no existe"));
        anuncio.setContenido(dto.getContenido());
        return anuncioRepository.save(anuncio);
    }

    //Delete anuncio

    public Anuncio delete(int id) throws ResourceNotFoundException {
        Anuncio anuncio=anuncioRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("El anuncio no existe"));
        anuncioRepository.delete(anuncio);
        return anuncio;
    }


    //Métodos Privados


    //Autoiincremento del id
    private int autoincrement(){
        List<Anuncio> anuncios=anuncioRepository.findAll();
        return anuncios.isEmpty() ? 1: anuncios.stream().max(Comparator.comparing(Anuncio::getId)).get().getId()+1;
    }


}
