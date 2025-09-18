package com.streaming.streaming.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;

import com.streaming.streaming.domain.dto.UserDTO;
import com.streaming.streaming.infraestructure.model.Usuario;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Entity -> DTO
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "plan.nombrePlan", target = "planName")
    UserDTO toDTOUser(Usuario usuario);
    List<UserDTO> toDTOUsers(List<Usuario> usuario);

    // DTO -> Entity
    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)       
    @Mapping(target = "contenidos", ignore = true)  
    List<Usuario> toEntityUsers(List<UserDTO> userDTO);
}
