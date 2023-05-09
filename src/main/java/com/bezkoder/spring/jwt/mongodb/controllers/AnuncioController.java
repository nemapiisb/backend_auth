package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.exception.NullContenidoException;
import com.bezkoder.spring.jwt.mongodb.exception.ResourceNotFoundException;
import com.bezkoder.spring.jwt.mongodb.models.Anuncio;
import com.bezkoder.spring.jwt.mongodb.models.EAnuncioCategoria;
import com.bezkoder.spring.jwt.mongodb.services.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.bezkoder.spring.jwt.mongodb.models.AnuncioDto;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 4800)
@RequestMapping("/anuncios")
public class AnuncioController {

    @Autowired
    AnuncioService anuncioService;


    //Mapeo GET => Devuelve todos los anuncios
    @GetMapping()
    public ResponseEntity<List<Anuncio>> getAll(){
        return ResponseEntity.ok(anuncioService.getAll());
    }
    
    //Mapeo GET => Devuelve anuncio pasando id
    @GetMapping("/{id}")
    public ResponseEntity<Anuncio> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(anuncioService.getOne(id));
    }
    //Mapeo GET => Devuelve anuncio pasando categoria
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Anuncio>> getAnunciosCategoria(@PathVariable("categoria") EAnuncioCategoria categoria) {
        return ResponseEntity.ok(anuncioService.getAnunciosCategoria(categoria));
    }

    //Mapeo POST crear usuario => devuelve anuncio creado

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN') or hasRole('VECINO')")
    public ResponseEntity<Anuncio> save(@RequestBody AnuncioDto dto) throws NullContenidoException {
        return ResponseEntity.ok(anuncioService.save(dto));
    }

    //Mapeo PUT update usuario

    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Anuncio> update(@PathVariable("id") int id, @RequestBody AnuncioDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(anuncioService.update(id,dto));
    }

    //Mapeo DELETE borrar anuncio
    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Anuncio> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(anuncioService.delete(id));
    }

}
