package com.streaming.streaming.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.InheritInverseConfiguration;

import com.streaming.streaming.domain.dto.PlanDTO;
import com.streaming.streaming.infraestructure.model.Plan;

@Mapper(componentModel = "spring")
public interface PlanMapper {

    
    @Mapping(source = "nombrePlan", target = "namePlan")
    @Mapping(source = "precio", target = "price")
    @Mapping(source = "duracionDias", target = "durationDays")
    @Mapping(source = "id", target = "id")
    PlanDTO toDTOPlan(Plan plan);

    @InheritInverseConfiguration
    @Mapping(target = "usuarios", ignore = true) 
    Plan toEntityPlan(PlanDTO planDTO);
}

