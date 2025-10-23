package com.streaming.streaming.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streaming.streaming.domain.dto.UserDTO;
import com.streaming.streaming.domain.irepository.IUserRepository;

@Service
public class UsuarioService {

    @Autowired
    private IUserRepository userRepository;

    // Obtener todos los usuarios
    public List<UserDTO> obtenerTodo() {
        return userRepository.getAll();
    }

    // Guardar un nuevo usuario o actualizar uno existente
    public String guardar(UserDTO userDTO) {
        UserDTO savedUser = userRepository.save(userDTO);
        if (savedUser != null) {
            return "Usuario '" + savedUser.getName() + "' guardado correctamente.";
        } else {
            return "Error al guardar el usuario.";
        }
    }

    // Buscar un usuario por ID
    public Optional<UserDTO> obtenerPorId(Long id) {
        return userRepository.getById(id);
    }

    // Eliminar un usuario por ID
    public String eliminar(Long userId) {
        Optional<UserDTO> usuario = userRepository.getById(userId);
        if (usuario.isPresent()) {
            userRepository.delete(userId);
            String nombre = usuario.get().getName() != null ? usuario.get().getName() : "desconocido";
            return "Usuario '" + nombre + "' eliminado correctamente.";
        } else {
            return "No se encontró un usuario con ID " + userId + ".";
        }
    }
}
