package com.streaming.streaming.infraestructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.streaming.streaming.domain.dto.UserDTO;
import com.streaming.streaming.domain.irepository.IUserRepository;
import com.streaming.streaming.infraestructure.crud.UsuarioCrudRepository;
import com.streaming.streaming.infraestructure.mapper.UserMapper;
import com.streaming.streaming.infraestructure.model.Usuario;

@Repository
public class UsuarioRepository implements IUserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository; 
    @Autowired 
    private UserMapper userMapper;// Correct injection

    @Override
    public List<UserDTO> getAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll(); // Use the injected instance
        return userMapper.toDTOUsers(usuarios);
    }

    @Override
    public void save(UserDTO userDTO) {
        // Implementation here
    }
}