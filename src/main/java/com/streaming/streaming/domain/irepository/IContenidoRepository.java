// IContenidoRepository.java
package com.streaming.streaming.domain.irepository;

import java.util.List;
import java.util.Optional;

import com.streaming.streaming.domain.dto.ContentDTO;

public interface IContenidoRepository {
    List<ContentDTO> getAll();
    ContentDTO save(ContentDTO contenidoDTO);
    Optional<ContentDTO> getById(Long id);
    void delete(Long id);
}
