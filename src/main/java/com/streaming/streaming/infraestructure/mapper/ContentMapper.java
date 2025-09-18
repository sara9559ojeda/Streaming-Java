package com.streaming.streaming.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.InheritInverseConfiguration;

import com.streaming.streaming.domain.dto.ContentDTO;
import com.streaming.streaming.infraestructure.model.Contenido;

@Mapper(componentModel = "spring")
public interface ContentMapper {

    // Entity -> DTO
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "tipo", target = "type")
    @Mapping(source = "genero", target = "genre")
    @Mapping(source = "duracion", target = "duration")
    ContentDTO toDTOContent(Contenido contenido);

    // DTO -> Entity
    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)       
    @Mapping(target = "usuario", ignore = true) 
    Contenido toEntityContent(ContentDTO contentDTO);
}
