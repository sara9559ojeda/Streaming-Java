package com.streaming.streaming.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.streaming.streaming.infraestructure.model.Usuario;
import com.streaming.streaming.infraestructure.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.GetMapping;



@RestController

public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
   
    @GetMapping("/obtener")
    public List<Usuario> getAllUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

}
