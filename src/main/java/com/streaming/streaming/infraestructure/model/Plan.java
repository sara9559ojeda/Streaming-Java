package com.streaming.streaming.infraestructure.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;   // Free, Premium, Familiar
    private double precio;
    private int duracionDias; // duración en días

    @OneToMany(mappedBy = "plan")
    private List<Usuario> usuarios;
}
