package com.streaming.streaming.infraestructure.crud;

import org.springframework.data.repository.CrudRepository;
import com.streaming.streaming.infraestructure.model.Usuario;

import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}
