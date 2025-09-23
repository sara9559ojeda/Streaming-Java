package com.streaming.streaming.infraestructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.streaming.streaming.domain.dto.PlanDTO;
import com.streaming.streaming.infraestructure.model.Plan;

@Component
public class PlanMapper {

    public PlanDTO toDTOPlan(Plan plan) {
        PlanDTO dto = new PlanDTO();
        dto.setId(plan.getId());
        dto.setNombrePlan(plan.getNombrePlan());
        dto.setPrecio(plan.getPrecio());
        dto.setDuracionDias(plan.getDuracionDias());
        return dto;
    }

    public Plan toEntityPlan(PlanDTO dto) {
        return Plan.builder()
                .id(dto.getId())
                .nombrePlan(dto.getNombrePlan())
                .precio(dto.getPrecio())
                .duracionDias(dto.getDuracionDias())
                .build();
    }

    public List<PlanDTO> toDTOPlans(List<Plan> planes) {
        return planes.stream().map(this::toDTOPlan).collect(Collectors.toList());
    }
}
