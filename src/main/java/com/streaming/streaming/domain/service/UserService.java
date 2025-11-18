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

    public UserDTO guardar(UserDTO userDTO) {
        return userRepository.save(userDTO);
    }

    public Optional<UserDTO> obtenerPorId(Long id) {
        return userRepository.getById(id);
    }

    public void eliminar(Long id) {
        userRepository.delete(id);
    }

    // agregar manejo de excepciones :v
}