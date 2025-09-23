// ContenidoCrudRepository.java
package com.streaming.streaming.infraestructure.crud;

import org.springframework.data.repository.CrudRepository;

import com.streaming.streaming.infraestructure.model.Contenido;

public interface ContenidoCrudRepository extends CrudRepository<Contenido, Long> {
}
