package com.streaming.streaming.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.streaming.streaming.domain.dto.UserDTO;
import com.streaming.streaming.infraestructure.model.Usuario;

@Mapper(componentModel = "spring", uses = { PlanMapper.class })
public interface UserMapper {

    // Entity -> DTO
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "plan", target = "plan") 
    UserDTO toDTOUser(Usuario usuario);

    // DTO -> Entity
    @Mapping(source = "email", target = "correo")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "plan", target = "plan") 
    Usuario toEntityUser(UserDTO userDTO);
}
