package com.streaming.streaming.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streaming.streaming.domain.dto.UserDTO;
import com.streaming.streaming.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // ✅ Obtener todos los usuarios
    @GetMapping(value = "/obtener", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<UserDTO>> getAllUsuarios() {
        List<UserDTO> usuarios = usuarioService.obtenerTodo();
        return ResponseEntity.ok(usuarios);
    }

    // ✅ Obtener un usuario por ID
    @GetMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
        Optional<UserDTO> usuario = usuarioService.obtenerPorId(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(404).body("No se encontró el usuario con ID " + id);
        }
    }

    // ✅ Guardar o actualizar usuario
    @PostMapping(value = "/", produces = "text/plain; charset=UTF-8")
    public ResponseEntity<String> save(@RequestBody UserDTO userDTO) {
        String mensaje = usuarioService.guardar(userDTO);
        return ResponseEntity.status(200).body(mensaje);
    }

    // ✅ Eliminar usuario por ID
    @DeleteMapping(value = "/{id}", produces = "text/plain; charset=UTF-8")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
        String mensaje = usuarioService.eliminar(id);
        return ResponseEntity.status(200).body(mensaje);
    }
}
