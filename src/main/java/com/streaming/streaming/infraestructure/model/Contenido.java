package com.streaming.streaming.infraestructure.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String tipo; 
    private String genero;
    private int duracion; 

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

