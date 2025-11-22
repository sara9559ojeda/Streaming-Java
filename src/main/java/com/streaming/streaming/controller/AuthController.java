package com.streaming.streaming.controller;

import com.streaming.streaming.infraestructure.security.JwtUtil;
import com.streaming.streaming.domain.dto.RegisterRequest;
import com.streaming.streaming.infraestructure.crud.UsuarioCrudRepository;
import com.streaming.streaming.infraestructure.crud.PlanCrudRepository;
import com.streaming.streaming.infraestructure.model.Usuario;
import com.streaming.streaming.infraestructure.model.Plan;
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
    private final UsuarioCrudRepository usuarioCrudRepository;
    private final PlanCrudRepository planCrudRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UsuarioCrudRepository usuarioCrudRepository, PlanCrudRepository planCrudRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuarioCrudRepository = usuarioCrudRepository;
        this.planCrudRepository = planCrudRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        // Log credentials to console as requested
        System.out.println("Login attempt - Username: " + username + ", Password: " + password);

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
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        Optional<Usuario> existing = usuarioCrudRepository.findByCorreo(request.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity.status(409).body(Map.of("error", "Email already registered"));
        }

        Plan plan = null;
        if (request.getPlanId() != null) {
            plan = planCrudRepository.findById(request.getPlanId()).orElse(null);
        }

        Usuario usuario = Usuario.builder()
                .nombre(request.getName())
                .correo(request.getEmail())
                .contrasena(passwordEncoder.encode(request.getPassword()))
                .plan(plan)
                .build();

        usuarioCrudRepository.save(usuario);

        String token = jwtUtil.generateToken(request.getEmail());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
