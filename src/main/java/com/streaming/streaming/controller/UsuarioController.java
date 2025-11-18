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
import com.streaming.streaming.domain.service.UserService;

@RestController
@RequestMapping("/usuarios")  
public class UsuarioController {
    @Autowired
    private UserService userService;

    @GetMapping("/obtener")
    public List<UserDTO> getAllUsuarios() {
        return userService.obtenerTodo();
    }

    @GetMapping("/{id}")  
    public Optional<UserDTO> getUsuarioById(@PathVariable Long id) {
        return userService.obtenerPorId(id);
    }

    @PostMapping("/")
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.guardar(userDTO);
    }

    @DeleteMapping("/{id}") 
    public void deleteUsuario(@PathVariable Long id) {
        userService.eliminar(id);
    }
}
