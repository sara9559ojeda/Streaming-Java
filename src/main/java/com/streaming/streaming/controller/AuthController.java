package com.streaming.streaming.controller;

import com.streaming.streaming.infraestructure.security.JwtUtil;
import com.streaming.streaming.infraestructure.crud.UsuarioCrudRepository;
import com.streaming.streaming.infraestructure.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioCrudRepository usuarioCrudRepository;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder, UsuarioCrudRepository usuarioCrudRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.usuarioCrudRepository = usuarioCrudRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = jwtUtil.generateToken(username);

            return ResponseEntity.ok(Map.of("token", token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> registerRequest) {
        String username = registerRequest.get("username"); // correo
        String password = registerRequest.get("password");
        String name = registerRequest.getOrDefault("name", "");

        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "username and password are required"));
        }

        Optional<Usuario> existing = usuarioCrudRepository.findByCorreo(username);
        if (existing.isPresent()) {
            return ResponseEntity.status(409).body(Map.of("error", "User already exists"));
        }

        String hashed = passwordEncoder.encode(password);
        Usuario nuevo = Usuario.builder()
                .nombre(name)
                .correo(username)
                .contrasena(hashed)
                .plan(null)
                .build();

        usuarioCrudRepository.save(nuevo);

        String token = jwtUtil.generateToken(username);
        return ResponseEntity.status(201).body(Map.of("token", token));
    }
}
