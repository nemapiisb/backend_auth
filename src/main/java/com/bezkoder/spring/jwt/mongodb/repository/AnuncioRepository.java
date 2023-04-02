package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.Anuncio;
import com.bezkoder.spring.jwt.mongodb.models.EAnuncioCategoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnuncioRepository extends MongoRepository<Anuncio,Integer> {
    List<Anuncio> findByCategoria(EAnuncioCategoria categoria);
}
