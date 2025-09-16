package com.streaming.streaming.infraestructure.mapper;


import com.streaming.streaming.domain.dto.PlanDTO;
import com.streaming.streaming.infraestructure.model.Plan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // o "default" si no usas Spring
public interface PlanMapper {

    PlanMapper INSTANCE = Mappers.getMapper(PlanMapper.class);

    // Entity -> DTO
    @Mapping(source = "nombrePlan", target = "namePlan")
    @Mapping(source = "precio", target = "price")
    @Mapping(source = "duracionDias", target = "durationDays")
    PlanDTO toDTOPlan(Plan plan);

    // DTO -> Entity
    @Mapping(source = "namePlan", target = "nombrePlan")
    @Mapping(source = "price", target = "precio")
    @Mapping(source = "durationDays", target = "duracionDias")
    Plan toEntityPlan(PlanDTO dto);
}


