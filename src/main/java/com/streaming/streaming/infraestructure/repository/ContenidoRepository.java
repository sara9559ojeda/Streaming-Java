// ContenidoRepository.java
package com.streaming.streaming.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.streaming.streaming.domain.dto.ContentDTO;
import com.streaming.streaming.domain.irepository.IContenidoRepository;
import com.streaming.streaming.infraestructure.crud.ContenidoCrudRepository;
import com.streaming.streaming.infraestructure.mapper.ContentMapper;
import com.streaming.streaming.infraestructure.model.Contenido;

@Repository
public class ContenidoRepository implements IContenidoRepository {

    @Autowired
    private ContenidoCrudRepository crud;

    @Autowired
    private ContentMapper mapper;

    @Override
    public List<ContentDTO> getAll() {
        List<Contenido> contenidos = (List<Contenido>) crud.findAll();
        return mapper.toDTOContents(contenidos);
    }

    @Override
    public ContentDTO save(ContentDTO contentDTO) {
        Contenido contenido = mapper.toEntityContent(contentDTO);
        Contenido saved = crud.save(contenido);
        return mapper.toDTOContent(saved);
    }

    @Override
    public Optional<ContentDTO> getById(Long id) {
        return crud.findById(id)
                   .map(mapper::toDTOContent);
    }

    @Override
    public void delete(Long id) {
        crud.deleteById(id);
    }
}
