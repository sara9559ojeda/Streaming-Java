package com.streaming.streaming.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;

import java.util.List;

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
    List<ContentDTO> toDTOContents(List<Contenido> contenidos);

    // DTO -> Entity
    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)      // id lo maneja la BD
    @Mapping(target = "usuario", ignore = true) // evitamos ciclos con Usuario
    Contenido toEntityContent(ContentDTO contentDTO);
    List<Contenido> toEntityContents(List<ContentDTO> contentDTOs);
}
