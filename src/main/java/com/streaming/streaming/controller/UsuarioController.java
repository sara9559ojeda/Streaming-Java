package com.streaming.streaming.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streaming.streaming.domain.dto.UserDTO;
import com.streaming.streaming.infraestructure.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")  // ✅ prefijo común
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/obtener")
    public List<UserDTO> getAllUsuarios() {
        return usuarioRepository.getAll();
    }

    @GetMapping("/{id}")  // ✅ obtener usuario por id
    public Optional<UserDTO> getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.getById(id);
    }

    @PostMapping("/")
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return usuarioRepository.save(userDTO);
    }

    @DeleteMapping("/{id}")  // ✅ eliminar usuario
    public void deleteUsuario(@PathVariable Long id) {
        usuarioRepository.delete(id);
    }
}
