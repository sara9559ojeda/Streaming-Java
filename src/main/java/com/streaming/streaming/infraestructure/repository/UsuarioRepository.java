package com.streaming.streaming.infraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import com.streaming.streaming.infraestructure.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
}
