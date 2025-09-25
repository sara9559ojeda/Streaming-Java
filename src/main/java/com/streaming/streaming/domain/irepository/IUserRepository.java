package com.streaming.streaming.domain.irepository;

import java.util.List;
import java.util.Optional;

import com.streaming.streaming.domain.dto.UserDTO;

public interface IUserRepository {
    List<UserDTO> getAll(); 
    UserDTO save(UserDTO userDTO);

    Optional<UserDTO> getById(Long id);   // ✅ nuevo
    void delete(Long id);                 // ✅ nuevo
}
