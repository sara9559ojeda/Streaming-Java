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

    private String nombrePlan;  
    private double precio;
    private int duracionDias; 

    @OneToMany(mappedBy = "plan")
    private List<Usuario> usuarios;
}
