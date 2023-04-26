package com.bezkoder.spring.jwt.mongodb.services;

import com.bezkoder.spring.jwt.mongodb.models.*;
import com.bezkoder.spring.jwt.mongodb.exception.NullContenidoException;
import com.bezkoder.spring.jwt.mongodb.exception.ResourceNotFoundException;
import com.bezkoder.spring.jwt.mongodb.repository.AnuncioRepository;
import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.repository.RoleRepository;


import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Optional;




@Service
public class VecinoService {

    @Autowired
    UserRepository userRepository;

    // Listar vecinos
    public List<User> getVecinos() {
        return userRepository.findAll();
    }

    // Resto de los métodos comentados




    //Listar Usuario
    public User getVecinoById(String id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El anuncio no existe"));
    }


/*
    //Listar anuncios por categoría
    public List<Anuncio> getAnunciosCategoria(EAnuncioCategoria categoria) {
        return userRepository.findByCategoria(categoria);
    }
*/

    // Crear Usuario
    @Autowired
    private RoleRepository roleRepository;

    public User crearVecino(User dto) throws NullContenidoException {
        if (dto.getUsername().isEmpty())
            throw new NullContenidoException("El contenido no puede estar vacío");

        String id = dto.getId();
        User user = new User(dto.getUsername(), dto.getEmail(), dto.getPassword());
        Set<Role> roles = new HashSet<>(); // Crear un nuevo conjunto de Roles
        Optional<Role> vecinoRole = roleRepository.findByName(ERole.ROLE_VECINO); // Obtener el rol existente ROLE_VECINO desde RoleRepository
        if (vecinoRole.isPresent()) { // Verificar si el rol existe
            roles.add(vecinoRole.get()); // Agregar el rol existente al conjunto
            user.setRoles(roles); // Pasar el conjunto de Roles al método setRoles() en la clase User
        }
        return userRepository.save(user);
    }

    // Crear Usuario Admin
    public User crearAdmin(User dto) throws NullContenidoException {
        if (dto.getUsername().isEmpty())
            throw new NullContenidoException("El contenido no puede estar vacío");

        String id = dto.getId();
        User user = new User(dto.getUsername(), dto.getEmail(), dto.getPassword());
        Set<Role> roles = new HashSet<>(); // Crear un nuevo conjunto de Roles
        Optional<Role> adminRole = roleRepository.findByName(ERole.ROLE_ADMIN); // Obtener el rol existente ROLE_VECINO desde RoleRepository
        if (adminRole.isPresent()) { // Verificar si el rol existe
            roles.add(adminRole.get()); // Agregar el rol existente al conjunto
            user.setRoles(roles); // Pasar el conjunto de Roles al método setRoles() en la clase User
        }
        return userRepository.save(user);
    }




    //Update anuncio

    public User updateVecino(String id, User dto) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El anuncio no existe"));
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return userRepository.save(user);
    }

    //Delete User

    public User deleteVecino(String id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El anuncio no existe"));
        userRepository.delete(user);
        return user;
    }


    //Métodos Privados

/*
    //Autoiincremento del id
    private int autoincrement() {
        List<Anuncio> anuncios = anuncioRepository.findAll();
        return anuncios.isEmpty() ? 1 : anuncios.stream().max(Comparator.comparing(Anuncio::getId)).get().getId() + 1;
    }
 */
}


