// ContenidoController.java
package com.streaming.streaming.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streaming.streaming.domain.dto.ContentDTO;
import com.streaming.streaming.infraestructure.repository.ContenidoRepository;

@RestController
@RequestMapping("/contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @GetMapping("/obtener")
    public List<ContentDTO> getAllContenidos() {
        return contenidoRepository.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ContentDTO> getContenidoById(@PathVariable Long id) {
        return contenidoRepository.getById(id);
    }

    @PostMapping("/")
    public ContentDTO save(@RequestBody ContentDTO contentDTO) {
        return contenidoRepository.save(contentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteContenido(@PathVariable Long id) {
        contenidoRepository.delete(id);
    }
}
