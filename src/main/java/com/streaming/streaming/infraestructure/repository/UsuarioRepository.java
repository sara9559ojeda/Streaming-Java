package com.streaming.streaming.infraestructure.repository;

import java.util.List;
import java.util.Optional;

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
    private UsuarioCrudRepository crud;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserDTO> getAll() {
        List<Usuario> usuarios = (List<Usuario>) crud.findAll();
        return mapper.toDTOUsers(usuarios);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        Usuario usuario = mapper.toEntityUser(userDTO);
        Usuario saved = crud.save(usuario);
        return mapper.toDTOUser(saved);
    }

    @Override
    public Optional<UserDTO> getById(Long id) {
        return crud.findById(id)
                   .map(mapper::toDTOUser);
    }

    @Override
    public void delete(Long id) {
        crud.deleteById(id);
    }
}
