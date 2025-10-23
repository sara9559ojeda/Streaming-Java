package com.streaming.streaming.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streaming.streaming.domain.dto.UserDTO;
import com.streaming.streaming.infraestructure.repository.UsuarioRepository;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository userRepository;
    
    public List<UserDTO> obtenerTodo() {
        return userRepository.getAll();
    }

    public UserDTO guardar() {
        return userRepository.save(null);
    }

    public Optional<UserDTO> obtenerPorId() {
        return userRepository.getById(null);
    }

    public void eliminar() {
        userRepository.delete(null);
    }

    // agregar manejo de excepciones :v
}