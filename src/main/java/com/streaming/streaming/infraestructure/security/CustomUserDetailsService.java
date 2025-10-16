package com.streaming.streaming.infraestructure.security;

import com.streaming.streaming.infraestructure.crud.UsuarioCrudRepository;
import com.streaming.streaming.infraestructure.model.Usuario;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioCrudRepository usuarioCrudRepository;

    public CustomUserDetailsService(UsuarioCrudRepository usuarioCrudRepository) {
        this.usuarioCrudRepository = usuarioCrudRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioCrudRepository.findByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        return new User(
                usuario.getCorreo(),
                usuario.getContrasena(),
                Collections.emptyList()
        );
    }
}
