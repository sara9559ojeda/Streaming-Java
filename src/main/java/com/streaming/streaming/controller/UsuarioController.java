package com.streaming.streaming.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.streaming.streaming.domain.dto.UserDTO;
import com.streaming.streaming.infraestructure.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

   
    @GetMapping("/obtener")
    public List<UserDTO> getAllUsuarios() {
        return (List<UserDTO>) usuarioRepository.getAll();
    }


}
