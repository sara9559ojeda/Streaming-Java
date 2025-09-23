package com.streaming.streaming.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;

import java.util.List;

import com.streaming.streaming.domain.dto.PlanDTO;
import com.streaming.streaming.infraestructure.model.Plan;

@Mapper(componentModel = "spring")
public interface PlanMapper {

    // Entity -> DTO
    @Mapping(source = "nombrePlan", target = "name")
    @Mapping(source = "precio", target = "price")
    @Mapping(source = "duracionDias", target = "durationDays")
    PlanDTO toDTOPlan(Plan plan);
    List<PlanDTO> toDTOPlans(List<Plan> plans);

    // DTO -> Entity
    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)       // id lo maneja la BD
    @Mapping(target = "usuarios", ignore = true) // evitamos ciclos con Usuario
    Plan toEntityPlan(PlanDTO planDTO);
    List<Plan> toEntityPlans(List<PlanDTO> planDTOs);
}
