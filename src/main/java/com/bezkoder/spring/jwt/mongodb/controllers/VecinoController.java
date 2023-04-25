package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.exception.NullContenidoException;
import com.bezkoder.spring.jwt.mongodb.exception.ResourceNotFoundException;
import com.bezkoder.spring.jwt.mongodb.models.User;
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
import com.bezkoder.spring.jwt.mongodb.services.VecinoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 4800)
@RequestMapping("/api/v1/vecinos")
public class VecinoController {

    @Autowired
    VecinoService vecinoService;

    // Mapeo GET => Devuelve todos los vecinos
    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(vecinoService.getVecinos());
    }

    // Mapeo GET => Devuelve vecino por ID

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(vecinoService.getVecinoById(id));
    }

    // Mapeo POST => Crea un nuevo vecino
    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) throws NullContenidoException {
        return ResponseEntity.ok(vecinoService.crearVecino(user));
    }

    // Mapeo PUT => Actualiza un vecino existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") String id, @RequestBody User dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(vecinoService.updateVecino(id, dto));
    }

    // Mapeo DELETE => Elimina un vecino por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") String id) throws ResourceNotFoundException {
        vecinoService.deleteVecino(id);
        return ResponseEntity.noContent().build();
    }
}
