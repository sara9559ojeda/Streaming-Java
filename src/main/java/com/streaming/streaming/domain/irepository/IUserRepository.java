package com.streaming.streaming.domain.irepository;

import java.util.List;

import com.streaming.streaming.domain.dto.UserDTO;

public interface IUserRepository {
    List<UserDTO> getAll();
    void save(UserDTO userDTO);
    
}
